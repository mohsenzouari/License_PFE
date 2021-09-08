package TreeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import TreeManager.Node;

public class TreeEncoding {
	 static Node<String> nROOTa1;
	 static Node<String> nROOTa2;
	 static int ar1depth;
	 static int ar2depth;
	 static int ar2taille,ar1taille;
	 double SimWithMatrix;

	
	 List<Node> parcourDeNoeud = new ArrayList<>();
	 List<String> parcourinvDeNoeudDeLigne = new ArrayList<>();
	 List<String> parcourinvDeNoeudDeCollone = new ArrayList<>();
	

	
	//Convertion de la chaine vers un nombre décimal
	
	 public static double String2decimal(String s) {
		 String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        s = s.toUpperCase();
	        double val = 0;	       	        
	        for (int i = 0; i < s.length(); i++) { 
	        	 char c = s.charAt(i);
	        	if ((c!='(')&&(c!=')')&&(c!=','))
	            {	        		           
	            int d = digits.indexOf(c);
	            val = val + d;
	            }	        		        	
	        }	       	        	        
	        return val;
	  }
	 
	 
	 
	 
	 
	 public TreeEncoding(Node<String> nROOTa1,int ar1depth,int ar1taille ,Node<String> nROOTa2,int ar2depth,int ar2taille){
			this.nROOTa1 = nROOTa1;
			this.nROOTa2 = nROOTa2;
			this.ar2depth = ar2depth;
			this.ar1depth = ar1depth;
			this.ar2taille = ar2taille;
			this.ar1taille = ar1taille;
		    }
	 
	 public Double  AssemblyLineBalancing(){
		 
		
		//Extraction de l'Augmented Adjacency Matrix à partir de l'arbre 1
		 	     
		 Double[][] matrix = new Double[ar1taille][ar1taille];
		   Double[][] matrixx = new Double[ar1taille][ar1taille];
      
		   parcourDeNoeud=nROOTa1.parcour();
		  
		   for (int i=0; i<parcourDeNoeud.size(); i++) {
			   for (int j=0; j<parcourDeNoeud.size(); j++) {
				   Node nL=parcourDeNoeud.get(i);
				   Node nC=parcourDeNoeud.get(j);
				   
				   //la noeud de ligne 
				   int nLD=nL.getDepth();
				   //la noeud de collone 
				   int nCD=nC.getDepth();
				   
				   
				   double lev1=(ar1depth-nLD)+1;
				   double lev2=(ar1depth-nCD)+1;
				   double poid2= String2decimal((nC.getLabel()));
			    	 

				   
				   
				   if (nL!=nROOTa1){
					   parcourinvDeNoeudDeLigne=nROOTa1.parcourinv(nL);
					   parcourinvDeNoeudDeCollone=nROOTa1.parcourinv(nC); 
 
	    	        }
				   
				   matrix[i][j]=(double) 0 ;
				   
				    if (i<j){	
				    	
				    	 if (nLD<nCD){
                                int tstMB=1;                                                                                            
                                tstMB=nROOTa1.EnMemeBranche(parcourinvDeNoeudDeCollone, parcourinvDeNoeudDeLigne);
                                
				    			 if (tstMB==1)
				    			 {
				    				 if ((lev1-lev2)==1){
									   matrix[i][j]= (double) ((lev2/lev1)+poid2) ;  									    	
									  }
				    				 
									  else if ((lev1-lev2)>1){
									    matrix[i][j]= (double) ((lev2/lev1)) ;  	
									  }				    				 
				    			 }
				    			 
                           }
				    			 		    			 
				         else if (nLD>nCD){					    	
                               int tstMB=1;
                               tstMB=nROOTa1.EnMemeBranche(parcourinvDeNoeudDeLigne, parcourinvDeNoeudDeCollone);
                               
			    			   if (tstMB==1)
			    			   {
			    				      if ((lev1-lev2)==1){
								    	matrix[i][j]= (double) ((lev2/lev1)+poid2) ;  								    
								      }
			    				      
								      else if ((lev1-lev2)>1){
								        matrix[i][j]= (double) ((lev2/lev1)) ;  								    	 
								      }			    				 
			    			   }			    			 
			    		 }			
				    }
				    if (i>j){
					    matrix[i][j]=(double) 0 ;  						   
					}	
				    
				    if (lev1==lev2){
					    matrix[i][j]=(double) 0 ;  	   
					}	
				     
				    if (i==j){
					    matrix[i][j]=(double) 1 ;  						   
				    }
				     
			}				   
	      }
				    
				    
				
		   
		   
		   /*
		   
		   for (int i=0; i<matrix.length; i++) {
			   for (int j=0; j<matrix.length; j++) {				   
				   System.out.print(matrix[i][j]+"  ");					  
			   }   System.out.println();
		   }System.out.println();System.out.println();*/
		   
		   

				
		 //Extraction de l'Augmented Adjacency Matrix à partir de l'arbre 2	
				
		   Double[][] matrix2 = new Double[ar2taille][ar2taille];
		   Double[][] matrix2x = new Double[ar2taille][ar2taille];
		   parcourDeNoeud=nROOTa2.parcour();
		   
		      for (int i=0; i<parcourDeNoeud.size(); i++) {
				   for (int j=0; j<parcourDeNoeud.size(); j++) {
					   
					   //la noeud de ligne 
					   Node nL=parcourDeNoeud.get(i);
					   //la noeud de collone 
					   Node nC=parcourDeNoeud.get(j);
					   
					   int nLD=nL.getDepth();
					   int nCD=nC.getDepth();
					   
					   
					   double lev1=(ar2depth-nLD)+1;
					   double lev2=(ar2depth-nCD)+1;
					   double poid2= String2decimal(nC.getLabel());
			    	  					   
					   if (nL!=nROOTa2){
						   parcourinvDeNoeudDeLigne=nROOTa2.parcourinv(nL);
						   parcourinvDeNoeudDeCollone=nROOTa2.parcourinv(nC); 	 
		    	       }
					   
					   matrix2[i][j]=(double) 0 ;					   					    
					   					     					 
					     if (i<j){						    	 
					        if (nLD<nCD){							    	
	                          int tstMB=1;	                                                              
	                          tstMB=nROOTa2.EnMemeBranche(parcourinvDeNoeudDeCollone, parcourinvDeNoeudDeLigne);	                          
					    	    if (tstMB==1)
					    		{					    	    	
					    		  if ((lev1-lev2)==1){
								    matrix2[i][j]= (double) ((lev2/lev1)+poid2) ;  										    	  
								  }
								  else if ((lev1-lev2)>1){
									matrix2[i][j]= (double) ((lev2/lev1)) ;  										    	 
								  }					    				 
					    	    }					    			 							    	
	                        }					    			 					    			 					    			 
						    } else if (nLD>nCD){
	                            int tstMB=0;	                            
	                            tstMB=nROOTa2.EnMemeBranche(parcourinvDeNoeudDeLigne, parcourinvDeNoeudDeCollone);
				    			 if (tstMB==1)
				    			 {
				    				 if ((lev1-lev2)==1){
									   matrix2[i][j]= (double) ((lev2/lev1)+poid2) ;  									    	 
									 }
									 else if ((lev1-lev2)>1){
									   matrix2[i][j]= (double) ((lev2/lev1)) ;  									    	 
									 }				    				 
				    			 }				    			 
				    	    }
				    			 
					       if (i>j){
							 matrix2[i][j]=(double) 0 ;  							   
						   }	
					       
					       if (lev1==lev2){							   
					    	 matrix2[i][j]=(double) 0 ;  							   
						   }	
					     
					       if (i==j){
							   matrix2[i][j]=(double) 1 ;  							   
						   }					     
					   }						    						   
				 }
					    
					    
					
		   /*
		   for (int i=0; i<matrix2.length; i++) {
			   for (int j=0; j<matrix2.length; j++) {				   
				   System.out.print(matrix2[i][j]+"  ");					  
			   } System.out.println();
		   }*/
		  
		   
		   


		   
		   		  		  		   		   		   
		   //*******équilibrage des matrices********
		 
		   
		   
		 int nblignedemat1=matrix.length;
		 int nbcolonnedemat1=matrix[0].length; 
		  
		   
		   int nblignedemat2=matrix2.length;
		   int nbcolonnedemat2=matrix2[0].length; 
		                  
		   
		 //Si la taille de l'arbre 1 est plus grand que la taille de l'arbre 2	
		   
		   if(!(nbcolonnedemat1==nbcolonnedemat2) || !(nblignedemat1==nblignedemat2))
		   {
			   //System.out.println("not ok");
			   
			   
			   if(nbcolonnedemat1 > nbcolonnedemat2){
					 
				   for (int i1=0; i1<nblignedemat2; i1++) {
					   for (int j=0; j<nbcolonnedemat2; j++) {
						   matrixx[i1][j]=matrix2[i1][j];
						  
							  
						   } 
						}
				  
				   
				   
				   
				   for (int i=0; i<nblignedemat1; i++) {
					   for (int j=nbcolonnedemat2; j<nbcolonnedemat1; j++) {
						   matrixx[i][j]=(double) 0;}}
				   
				   
				   
			   
			  
		   
				   for (int i2=nblignedemat2; i2<matrixx.length; i2++) {
				       for (int j2=0; j2<nbcolonnedemat2; j2++) {
						   matrixx[i2][j2]=(double) 0;	  
					   } 
				   }
					
					
					/*
				   for (int i2=0; i2<matrixx.length; i2++) {
				       for (int j2=0; j2<matrixx.length; j2++) {					   
					       System.out.print(matrixx[i2][j2]+"  ");						  
					   } System.out.println();
					}System.out.println();System.out.println();		*/ 
						   
						   
					 double dotProduct = 0.0;
					 double normA = 0.0;
					 double normB = 0.0;
					  for (int i = 0; i < matrix.length; i++) {
					   for (int j = 0; j < matrix[0].length; j++) {
					     dotProduct += matrix[i][j] * matrixx[i][j];
					     normA += Math.pow(matrix[i][j], 2);
					     normB += Math.pow(matrixx[i][j], 2);
					   } 
					  } 
					    SimWithMatrix= dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));		 
					    return SimWithMatrix;
					 
					 
				
			   //Si la taille de l'arbre 2 est plus grand que la taille de l'arbre 1	    
					 
				   
			     } if(nbcolonnedemat1 < nbcolonnedemat2){
					 
					   for (int i1=0; i1<nblignedemat1; i1++) {
						   for (int j=0; j<nbcolonnedemat1; j++) {
							   matrix2x[i1][j]= matrix[i1][j];
							  
								  
							   } 
							}
					  
					   for (int i=0; i<nblignedemat2; i++) {
						   for (int j=nbcolonnedemat1; j<nbcolonnedemat2; j++) {
							   matrix2x[i][j]=(double) 0;}}
					   
					   
					   
				   
				  
			   
						for (int i2=nblignedemat1; i2<matrix2x.length; i2++) {
							   for (int j2=0; j2<nbcolonnedemat1; j2++) {
								   matrix2x[i2][j2]=(double) 0;
								   
									  
								   } 
								}
						
												
						/*
						 for (int i2=0; i2<matrix2x.length; i2++) {
					   for (int j2=0; j2<matrix2x.length; j2++) {
						   
						   System.out.print(matrix2x[i2][j2]+"  ");
							  
						   } System.out.println();
						}System.out.println();System.out.println();
						*/
						
			   			   
						
						
				   
						 double dotProduct = 0.0;
						    double normA = 0.0;
						    double normB = 0.0;
						    for (int i = 0; i < matrix2.length; i++) {
						    	for (int j = 0; j < matrix2[0].length; j++) {
						        dotProduct += matrix2[i][j] * matrix2x[i][j];
						        normA += Math.pow(matrix2[i][j], 2);
						        normB += Math.pow(matrix2x[i][j], 2);
						    }  } 
						    SimWithMatrix= dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));		 
						    return SimWithMatrix;					   				   				   
			         }
			     
		 							   							   							   							   							   							   							   							   							   
			 }else {
				 				   
			//Si les deux arbres ont la meme taille	
								   
			   //System.out.println("it's ok");
		   		   
			   double dotProduct = 0.0;
			    double normA = 0.0;
			    double normB = 0.0;
			    for (int i = 0; i < matrix.length; i++) {
			    	for (int j = 0; j < matrix[0].length; j++) {
			        dotProduct += matrix[i][j] * matrix2[i][j];
			        normA += Math.pow(matrix[i][j], 2);
			        normB += Math.pow(matrix2[i][j], 2);
			        }  
			    } 
			    SimWithMatrix= dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));	
			    return(SimWithMatrix);
		     }
		return SimWithMatrix;	  
	 }
}
