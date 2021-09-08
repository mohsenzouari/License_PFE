package com.FeatureModel.Matching;




import java.io.File;
import java.io.FileWriter;
import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.math.*;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.math.*;



public class ClusteredTM {

	//static File logFile;
	//static  BufferedWriter writer;
	/* public static  int _nbCard1;
	 public static int _nbCard2;
	public static int _nbCard11;  //card1'
	public static int _nbCard22; // card2'
	
	
	public static  int _nbCardconcrete1;
	 public static int _nbCardconcrete2;
	public static int _nbCardconcrete11;  //card1'
	public static int _nbCardconcrete22*/; // card2'
	
	
	public static double clusteredTreeMatching(Node treeA,Node treeB)
	{	double retour=0;
	double cost1=0.75;
	 double cost2=0.5;
		//log("Call CTM ("+treeA.getData()+" ,"+treeB.getData()+")");		
		if (treeA.getLabel() != treeB.getLabel())
		{
		//	log("** END Call CTM("+treeA.getData()+" ,"+treeB.getData()+") = 0 **");
			return 0;
		}
		int m = treeA.getChildrenCount();
		int n = treeB.getChildrenCount();
		//log("@CTM("+treeA.getData()+" ,"+treeB.getData()+") -> m= "+m+" n= "+n);
		double[][] M = new double[50][50];
		
		// Initialize Matrix M
		for(int i =0;i<=m;i++)
			for(int j =0;j<=n;j++)
				M[i][j] = 0;

		for(int i =1;i<=m;i++)
			{
					for(int j = 1;j<=n;j++)
					{				
						//printMatrix(M, i, j);
						M[i][j] = max(
										M[i][j-1], 
										M[i-1][j], 
										M[i-1][j-1] + clusteredTreeMatching(treeA.getChildAt(i), treeB.getChildAt(j))
										);
						/*if (j==n)
						{log("The matrix of STM("+treeA.getData()+" ,"+treeB.getData()+")");
						printMatrix(M, i, j);}*/
					}
					
			
			}
		
		
		/*if (m>0 &&n>0) 
		{ retour = (M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling());
		log("*********max=   "+Math.max(treeA.getSibling(),treeB.getSibling()));
		log("*********sibling de nodeA:   "+treeA.getSibling()+"   et sibling de nodeB:   "+treeB.getSibling());
		log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
		}
		else
		{
			//log("retour avant:  "+retour);
			 retour = (M[m][n]+1)/Math.max(treeA.getSibling(),treeB.getSibling());
			  log("retour après:  "+retour);
			 log("sibling de nodeA:   "+treeA.getSibling()+"   et sibling de nodeB:   "+treeB.getSibling());
			 log("max=   "+Math.max(treeA.getSibling(),treeB.getSibling()));
			log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
		}
		//System.out.println("resultat=  "+retour+"\n");
		for(int i =1;i<=m;i++)
			
			for(int j = 1;j<=n;j++)
			{
				printMatrix(M, i, j);
			}*/
	
	//	return retour;
		
	
	
	
	//**************** Cas des noeuds racines *******************
			if (treeA.isRoot()== true)
			{
				if (treeA.getType2()!= null && treeB.getType2()!= null)
				{/*_nbCard2=_nbCard2+2;
				_nbCardconcrete2=_nbCardconcrete2+2;*/
				
				//log("+card2 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard2);
				
				
				if (  treeA.getType2()== treeB.getType2() )
			      {retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*1;
				  // log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
			      }
				else
				
					{retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost2;
				    // log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
					}
				}
				else if (treeA.getType2()== null && treeB.getType2()== null)
					{
					retour = (M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling());
					//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
					}
				
				//XOR   vs null
				
				else if (treeA.getType2()== null && treeB.getType2()!= null || treeA.getType2()!= null && treeB.getType2()== null)
				
				{/*_nbCard22=_nbCard22+1;
				_nbCardconcrete22=_nbCardconcrete22+1;*/
				
				
				
				
				//log("-----------------card22 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard22);
					retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost2;
					//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");		
				}
			}
			
			//************** Cas des noeuds feuilles ********************
			if (treeA.isLeaf()== true && treeB.isLeaf()== true)
			{ 
				if (treeA.getType1()!= null && treeB.getType1()!= null)
				{	/*  _nbCard1=_nbCard1+2;
				     _nbCardconcrete1=_nbCardconcrete1+2;*/
					//log("______________card1 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard1);
					if (treeA.getType1()== treeB.getType1())
					{retour= ((M[m][n]+1)/Math.max(treeA.getSibling(),treeB.getSibling()))*1;
					//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
					}
				else
					{retour= ((M[m][n]+1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1;
					//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
					}
				}
					
			else if (treeA.getType1()== null && treeB.getType1()== null)
					{retour= (M[m][n]+1)/Math.max(treeA.getSibling(),treeB.getSibling());
					//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
					}
				
			else if (treeA.getType1()== null && treeB.getType1()!= null || treeA.getType1()!= null && treeB.getType1()== null)
					
					{/*_nbCard11=_nbCard11+1;
					_nbCardconcrete11=_nbCardconcrete11+1;*/
					retour= ( (M[m][n]+1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1;
					//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
					}
			 }
			//**************** Cas des noeuds intermédiaires ********************
			if (treeA.isLeaf()== false && treeA.isRoot()== false && treeB.isLeaf()== false && treeB.isRoot()== false)
			
			{	
				//*********** Cas où les 2 cardinalités existent ************** 
				if (treeA.getType1()!=null && treeB.getType1()!=null && treeA.getType2()!=null && treeB.getType2()!=null)
					{	/*_nbCard1=_nbCard1+2;
					_nbCardconcrete1=_nbCardconcrete1+2;*/
					//log("_________________card1 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard1);
						//_nbCard2=_nbCard2+2;
						//_nbCardconcrete2=_nbCardconcrete2+2;
						//log("**********card2 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard2);
						
						//System.out.println("__________________"+_nbCard1+" \n");
						
						//System.out.println("+++++++++"+_nbCard2);
						
						//System.out.println("node1= "+treeA.getData()+"  nodeB= "+treeB.getData()+ "\n");
						if ( treeA.getType1()== treeB.getType1() &&  treeA.getType2()== treeB.getType2())
							{retour =( (M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*1;
							//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
							}
						else if (treeA.getType1()!= treeB.getType1() &&  treeA.getType2()!= treeB.getType2())
							{retour= ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*(cost1*cost2);
							//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
							}
						else if (treeA.getType1()== treeB.getType1() &&  treeA.getType2()!= treeB.getType2())
							{
								retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*1*cost2;
							//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
							}
						else if (treeA.getType1()!= treeB.getType1() &&  treeA.getType2()== treeB.getType2())
							{
								retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1*1;
							//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
							}
					}
			//************ Cas où cardinalité (or/alternative) n’existe pas
					
					if ( treeA.getType2() == null && treeB.getType2() == null && treeA.getType1()!=null && treeB.getType1()!=null )
					{	/*_nbCard1=_nbCard1+2;
					_nbCardconcrete1=_nbCardconcrete1+2;*/
					//log("_________________card1 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard1);
						if ( treeA.getType1() == treeB.getType1() )
							{
							
							retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*1;
							//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
							}
							else 
							{
								
								retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1;
							//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
							}
					}
			//************* Cas où cardinalité (mandatory/opt) existe et (or/xor) pour seul noeud
				if (treeA.getType1()!=null && treeB.getType1()!=null)
					
					{
					if (treeA.getType2() == null && treeB.getType2() != null || (treeA.getType2() != null && treeB.getType2() == null))
						{/* _nbCard1=_nbCard1+2;
						_nbCardconcrete1=_nbCardconcrete1+2;*/
						//log("_________________card1 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard1);
						//_nbCard22=_nbCard22+1;
						//_nbCardconcrete22=_nbCardconcrete22+1;
						//log("---------------card22 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard22);
						if  (treeA.getType1()==treeB.getType1())
						  { retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*1*cost2;
							
						  //log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
						  }
						else 
			              {
							retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1*cost2;
			             // log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
			              }}
					}
				
				
				
				//////////////////////////////////////////////////////
				
					//*********** cas où cardinalité(mandatory/opt) n'existe pas et (or/xor) existe***********
					if  (treeA.getType1()==null && treeB.getType1()== null&& treeA.getType2() != null && treeB.getType2() != null)
					{/* _nbCard2=_nbCard2=2;
					 _nbCardconcrete2=_nbCardconcrete2=2;*/
						if (treeA.getType2()==treeB.getType2())
							  {
							  retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*1;
							  //log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
							  }
							  else 
							   {
								  
								  retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost2;
							  // log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
							   }
					}	
					//**********Cas où les deux cardinalités n'existent pas**********
					
						if (treeA.getType1()==null &&  treeB.getType1()== null && treeA.getType2()==null && treeB.getType2()==null) 
						{retour = (M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling());
						//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
						}
				//************** Cas où la cardinalité (mandatory/opt) n'existe pas et (or/xor) existe dans un seul	
					 if (treeA.getType1()==null &&  treeB.getType1()== null)
							  if((treeA.getType2()!= null && treeB.getType2()== null) ||
								(treeA.getType2()== null && treeB.getType2()!= null))
							  {// _nbCard22=_nbCard22+1;
							  //_nbCardconcrete22=_nbCardconcrete22+1;
							  retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost2;	
							 // log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
							  }
					//****** Cas (mandatory/opt) existe dans seul noeud et (or/xor) les deux
					
						
						if (treeA.getType2() !=null && treeB.getType2()!=null)
						{
						{if ((treeA.getType1()!= null && treeB.getType1() == null) ||
									(treeA.getType1() == null && treeB.getType1()!= null))
										{	/*_nbCard2=_nbCard2+2;
										_nbCardconcrete2=_nbCardconcrete2+2;*/
										//log("!!!!!!!!!!!!!!!!!!!!!!card2 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard2);
										//_nbCard11=_nbCard11+1;
										//_nbCardconcrete11=_nbCardconcrete11+1;
										//log("card11 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard11);
											if ( treeA.getType2() == treeB.getType2())	
											{
											retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*1*cost1;
											//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
											}
										else
											{
											retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1*cost2;
											//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
											}
										}	
						}}
					//************* Cas (mandatory/optional) existe seul noeud et (or/xor) n'existe pas
					if ( treeA.getType2() ==null && treeB.getType2()==null)
					{ if ((treeA.getType1()!= null && treeB.getType1()== null) ||
							     (treeA.getType1() == null && treeB.getType1()!= null))
								{	/*_nbCard11=_nbCard11+1;
								_nbCardconcrete11=_nbCardconcrete11+1;*/
									
									retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1;
									//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
								}
					}
					//******** Cas (mandatory/opt) et (or/xor) existent dans un seul noeud
					
						if ((treeA.getType1()!= null && treeB.getType1() == null) ||
								(treeA.getType1() == null && treeB.getType1()!= null))
						{ 	
							if((treeA.getType2()!= null && treeB.getType2()== null) ||
										(treeA.getType2()== null && treeB.getType2()!= null))
								 {	/*_nbCard11=_nbCard11+1;
								 _nbCardconcrete11=_nbCardconcrete11+1;*/
								 //_nbCard22=_nbCard22+1;
								 	//_nbCardconcrete22=_nbCardconcrete22+1;
									
									retour = ((M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1*cost2;
									//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
								 }
					}
			}	
							//Cas de nœud intermédiaire avec nœud fils ou le contraire 
			
			if  ((treeA.isRoot()==false && treeA.isLeaf()==false && treeB.isLeaf()==true) ||
			 (treeA.isLeaf()==true && treeB.isRoot()==false && treeB.isLeaf()==false))
			 { 
			 //*******Cas où la cardinalité (mandatory/optional) existe dans les deux nœuds ********
			 { if (treeA.getType1()!= null && treeB.getType1()!=null) 
			 	{	/* _nbCard1=_nbCard1+2;
			 _nbCardconcrete1=_nbCardconcrete1+2;*/
			 	//log("__________card1 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard1);
			 //	log("____________________card1 feuilles de "+treeA.getData()+" et "+treeB.getData()+" = "+_nbCard1);
				 	if  (treeA.getType1() == treeB.getType1())
					 	{
					 	retour =( (M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*1;
					 	//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
					 	}
				 	else
					 { 
					 retour =( (M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1;
				 		//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
					 }
			 }
			 }
			//******Cas où la cardinalité (mandatory/optional) n’existe pas ******
			 {
				 if ( treeA.getType1()==null && treeB.getType1() == null) 
					 
				 { 
				 retour = (M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling());
						 //log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
				 }
			 }
				//********Cas où cardinalité (mandatory/optional) existe dans un seul nœud 
			 {
				 if (treeA.getType1()== null && treeB.getType1()!= null || treeA.getType1()!= null && treeB.getType1()== null)
						
						{/*_nbCard11=_nbCard11+1;
						_nbCardconcrete11=_nbCardconcrete11+1;*/
					 	
					 	retour =( (M[m][n]*1)/Math.max(treeA.getSibling(),treeB.getSibling()))*cost1;
				 		//log("** END Call STM("+treeA.getData()+" ,"+treeB.getData()+") = "+retour+" **");
					 	}
				 
			 }
					
					
			 }		
			
			return retour;
			
			
		}
	
	private static void printMatrix(double[][] M,int m, int n)
	{
		String s="";
		for(int i =0;i<=m;i++)
		{
			for(int j = 0;j<=n;j++)
			{
				s+=(M[i][j]+" ");
			}
			s+="\n";
		}
		//log(s);
	}
	
	private static double max(double a, double b, double c)
	{
		if (a>b)
			if (a>c)
				return a;
			else
				return c;
		else 
			if (b>c)
				return b;
			else
				return c;
	}
	
	/*public static void createLogFiles()
	{
		try {
		    //create a temporary file
		    String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(
		        Calendar.getInstance().getTime());    
		    logFile=new File("log/"+timeLog+".log");

		    writer = new BufferedWriter(new FileWriter(logFile));
		    writer.append("#####################################\n Début LOG STM");

		} catch(Exception e) {
		    e.printStackTrace();
		}
	}*/
	
/*	private static void log(String string)
	{
		try {		   
		    writer.append("\n"+string);

		} catch(Exception e) {
		    e.printStackTrace();
		}
	}*/
	
	
	
	public static  double ComputeDistance (Node AbstracttreeA ,Node AbstracttreeB, Node ConcretetreeA ,Node ConcretetreeB)
	{

		 System.out.println("racine de l'arbre concrète=   "+AbstracttreeA.getData());
	    double distancePartieAbstraite= (float) ClusteredTM.clusteredTreeMatching(AbstracttreeA, AbstracttreeB);
	   
	
	   
	  
		   
	    System.out.println("racine de l'arbre concrète=   "+ConcretetreeA.getData());
	   double distancePartieConcrete= (float) ClusteredTM.clusteredTreeMatching(ConcretetreeA, ConcretetreeB);
	   
	//   System.out.println("cardinalité1 dans ///////////////////"+ AbstracttreeA.getData()+ "et  "+AbstracttreeB.getData()+" = "+ _nbCard1);
	 //   System.out.println("cardinalité2 dans /////////////////// " +AbstracttreeA.getData()+ "et  "+AbstracttreeB.getData()+" = "+ _nbCard2);
	   
	    
	   
	    System.out.println("++++++++++++++++++++++++distance partie abstrate de requete"+ AbstracttreeA.getData()+ " et "+AbstracttreeB+" = "+ distancePartieAbstraite);
		System.out.println("****************distance partie concrete de requete "+ConcretetreeA.getData()+" et "+ConcretetreeB+ " = "+ distancePartieConcrete);
	   /* System.out.println( " nbCardinalité1 partie abstrait="+ClusteredTM._nbCard1);
	    System.out.println( " nbCardinalitéconcrète1="+ClusteredTM._nbCardconcrete1);
	    System.out.println(" nb cardinalité2 abstraite= "+ClusteredTM._nbCard2);
	   System.out.println("nb cardinalité 2 concrète= "+ ClusteredTM._nbCardconcrete2);*/
	    double finalDistance= 0.5*distancePartieAbstraite+0.5*distancePartieConcrete;
	   

	    
		return finalDistance;
		 
	}
	
	
	/*public static void closeWriter()
	{
		try {		   
		    writer.append("\n####### End of the LOG file ############");

		    //Close writer
		  writer.close();
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}*/}

