package com.multiTenancy.Discovery;
import java.util.ArrayList;
import java.util.List;

import com.FeatureModel.Matching.*;
public class DiscoverImpl implements Runnable {
	
	private int tenantId;
	private String tenantName;
	//private Repository repository; 
	private List<Node> listeServicesAbstract = new ArrayList<Node>();
	private List<Node> listeServicesConcrete = new ArrayList<Node>();
	private Node servicerequestAbstract;
	private Node servicerequestConcrete;
	 

	public DiscoverImpl( int tenantId, String tenantName, Node servicerequestAbstract, List<Node> listeServicesAbstract, Node servicerequestConcrete, List<Node> listeServicesConcrete  ) {
	this.tenantId=tenantId;
	this.tenantName = tenantName;
	this.servicerequestAbstract=servicerequestAbstract;
	this.servicerequestConcrete=servicerequestConcrete;
	this.listeServicesAbstract=listeServicesAbstract;
	this.listeServicesConcrete=listeServicesConcrete;
	
	}
	
	
	
	
	
	
	public void run() {
		SimpleTreeMatching._nbCard1=0;
		 SimpleTreeMatching._nbCard2=0;
		 SimpleTreeMatching._nbCard11=0;
		 SimpleTreeMatching._nbCard22=0;
		 
		 SimpleTreeMatching._nbCardconcrete1=0;
		    SimpleTreeMatching._nbCardconcrete2=0;
		    SimpleTreeMatching._nbCardconcrete11=0;  //card1'
		    SimpleTreeMatching._nbCardconcrete22=0;
	
		System.out.println("c'est le tenant numero   "+this.tenantId+"  son nom="+this.tenantName+" partie abstraite de son requete : "+this.servicerequestAbstract.getLabel()+ " partie concrete de son requete : "+this.servicerequestConcrete.getLabel()+ "\n" );	
		   
		for (int i=0;i<listeServicesAbstract.size();i++)
		 {	 SimpleTreeMatching._nbCard1=0;
		 SimpleTreeMatching._nbCard2=0;
		 SimpleTreeMatching._nbCard11=0;
		 SimpleTreeMatching._nbCard22=0;
		 
		 SimpleTreeMatching._nbCardconcrete1=0;
		    SimpleTreeMatching._nbCardconcrete2=0;
		    SimpleTreeMatching._nbCardconcrete11=0;  //card1'
		    SimpleTreeMatching._nbCardconcrete22=0;
			
			double result= SimpleTreeMatching.ComputeDistance(servicerequestAbstract, this.listeServicesAbstract.get(i), servicerequestConcrete, this.listeServicesConcrete.get(i));
			 if (result>0)
			 {
				 System.err.print("service web plus similaire: " + this.listeServicesAbstract.get(i).getLabel()+"     "+this.listeServicesAbstract.get(i).getData()+"      "+ " de similarité = "+"        "+result+" pour "+this.tenantName+"\n");
				}
			
			 SimpleTreeMatching._nbCard1=0;
			 SimpleTreeMatching._nbCard2=0;
			 SimpleTreeMatching._nbCard11=0;
			 SimpleTreeMatching._nbCard22=0;
			 
			 SimpleTreeMatching._nbCardconcrete1=0;
			    SimpleTreeMatching._nbCardconcrete2=0;
			    SimpleTreeMatching._nbCardconcrete11=0;  //card1'
			    SimpleTreeMatching._nbCardconcrete22=0;
			 
		     }
		
	
			 
		 }
		 
		
	
	

}
