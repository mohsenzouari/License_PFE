package com.multiTenancy.Discovery;


import java.util.ArrayList;
import java.util.List;

import com.FeatureModel.Matching.Node;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Node> listeServicesAbstract= new ArrayList<Node>();
		List<Node> listeServicesConcret= new ArrayList<Node>();
	
		
		Node n1 = new Node("request abstraite","VacationPlanner",null,"alternative");
		Node n2 = new Node("N2","CurrencyConverter","optional");
		Node n3 = new Node("N3","Flight","mandatory","or");
		Node n4 = new Node("N4","Hotel","optional");
		Node n5 = new Node("N5","Guide","optional");
		Node n6 = new Node("N6","Payment","mandatory");
		Node n7 = new Node("N7","BookRoundFlight");
		Node n8 = new Node("N8","BookWayFlight");
		Node n9 = new Node("N9","SendConfirmation");
		Node n10 = new Node("N10","BankTransfer");
		Node n11 = new Node("N11","CreditCard");
		Node n12 = new Node("N12","BWFlightInput","mandatory");
		Node n13 = new Node("N13","BWFlightOutput","mandatory");
		Node n14 = new Node("N14","BWFlightFault","optional","");
		Node n15 = new Node("N15","Destination","mandatory","alternative");
		Node n16 = new Node("N16","DeparDate","mandatory");
		Node n17 = new Node("N17","FlightType","optional");
		Node n18 = new Node("N18","FlightNum","mandatory");
		
		n1.addChild(n2);
		n1.addChild(n3);
		n1.addChild(n4);
		n1.addChild(n5);
		n1.addChild(n6);
		n3.addChild(n7);
		n3.addChild(n8);
		n3.addChild(n9);
		n6.addChild(n10);
		n6.addChild(n11);
		n8.addChild(n12);
		n8.addChild(n13);
		n8.addChild(n14);
		n12.addChild(n15);
		n12.addChild(n16);
		n12.addChild(n17);
		n13.addChild(n18);
		
		
		Node n30 = new Node("request concrete","VacationPlanner",null,"alternative");
		Node n31 = new Node("N31","CurrencyConverter","optional");
		Node n32 = new Node("N32","Flight","mandatory","or");
		Node n33 = new Node("N33","Hotel","optional");
		Node n34 = new Node("N34","Guide","optional");
		Node n35 = new Node("N35","Payment","mandatory");
		Node n36 = new Node("N36","BookRoundFlight");
		Node n37 = new Node("N37","BookWayFlight");
		Node n38 = new Node("N38","SendConfirmation");
		Node n39 = new Node("N39","BankTransfer");
		Node n40 = new Node("N40","CreditCard");
		Node n41 = new Node("N41","BWFlightInput","mandatory");
		Node n42 = new Node("N42","BWFlightOutput","mandatory");
		Node n43 = new Node("N43","BWFlightFault","optional");
		Node n44 = new Node("N44","Destination","mandatory","alternative");
		Node n45 = new Node("N45","DeparDate","mandatory");
		Node n46 = new Node("N46","FlightType","optional");
		Node n47 = new Node("N47","FlightNum","mandatory");
		
		n30.addChild(n31);
		n30.addChild(n32);
		n30.addChild(n33);
		n30.addChild(n34);
		n30.addChild(n35);
		
		n32.addChild(n36);
		n32.addChild(n37);
		n32.addChild(n38);
		n37.addChild(n41);
		n37.addChild(n42);
		n37.addChild(n43);
		n41.addChild(n44);
		n41.addChild(n45);
		n41.addChild(n46);
		
		
		
		

	/////////////////////////////////////////////////////////    arbre absraite
		Node n01 = new Node("request abstraite","VacationPlanner",null,"alternative");
		n01.addChild(n2);
		n01.addChild(n3);
		n01.addChild(n4);
		n01.addChild(n5);
		n01.addChild(n6);
		n3.addChild(n7);
		n3.addChild(n8);
		n3.addChild(n9);
		n6.addChild(n10);
		n6.addChild(n11);
		n8.addChild(n12);
		n8.addChild(n13);
		n8.addChild(n14);
		n12.addChild(n15);
		n12.addChild(n16);
		n12.addChild(n17);
		n13.addChild(n18);
/////////////////////////////////////////////////////////    arbre concraite
		Node n02 = new Node("request concrete","VacationPlanner",null,"alternative");
		n02.addChild(n31);
		n02.addChild(n32);
		n02.addChild(n33);
		n02.addChild(n34);
		n02.addChild(n35);
		n32.addChild(n36);
		n32.addChild(n37);
		n32.addChild(n38);
		n37.addChild(n41);
		n37.addChild(n42);
		n37.addChild(n43);
		n41.addChild(n44);
		n41.addChild(n45);
		n41.addChild(n46);
/////////////////////////////////////////////////////////    arbre abstraite
		Node n001 = new Node("request abstraite","VacationPlanner",null,"alternative");
   		Node n002 = new Node("N002","CurrencyConverter","optional");
   		Node n003 = new Node("N003","Flight","mandatory","or");
   		Node n004 = new Node("N004","Hotel","optional");
   		Node n005 = new Node("N005","Guide","optional");
   		Node n006 = new Node("N006","Payment","mandatory");
   		Node n007 = new Node("N007","BookRoundFlight");
   		Node n008 = new Node("N008","BookWayFlight");
   		Node n009 = new Node("N009","SendConfirmation");
   		Node n0010 = new Node("N0010","BankTransfer");
   		Node n0011 = new Node("N0011","CreditCard");
   		Node n0012 = new Node("N0012","BWFlightInput","mandatory");
   		Node n0013 = new Node("N0013","BWFlightOutput","mandatory");
   		Node n0014 = new Node("N0014","BWFlightFault","optional");
   		Node n0015 = new Node("N0015","Destination","mandatory","alternative");
   		n001.addChild(n002);
   		n001.addChild(n003);
   		n001.addChild(n004);
   		n001.addChild(n005);
   		n001.addChild(n006);
   		n003.addChild(n007);
   		n003.addChild(n008);
   		n006.addChild(n0010);
   		n006.addChild(n0011);
   		n008.addChild(n0012);
   		n008.addChild(n0013);
/////////////////////////////////////////////////////////    arbre concrete
   		Node n0030 = new Node("request concrete","VacationPlanner","","alternative");
			Node n0031 = new Node("N0031","CurrencyConverter","optional","");
			Node n0032 = new Node("N0032","Flight","mandatory","or");
			Node n0033 = new Node("N0033","Hotel","optional","");
			Node n0034 = new Node("N0034","Guide","optional","");
			Node n0035 = new Node("N0035","Payment","mandatory","");
			Node n0036 = new Node("N0036","BookRoundFlight","","");
			Node n0037 = new Node("N0037","BookWayFlight","","");
			Node n0038 = new Node("N0038","SendConfirmation","","");
			Node n0039 = new Node("N0039","BankTransfer","","");
			Node n0040 = new Node("N0040","CreditCard","","");
			Node n0041 = new Node("N0041","BWFlightInput","mandatory","");
			Node n0042 = new Node("N0042","BWFlightOutput","mandatory","");
			Node n0043 = new Node("N0043","BWFlightFault","optional","");
   		
			n0030.addChild(n0031);
				n0030.addChild(n0032);
				n0030.addChild(n0033);
				n0030.addChild(n0034);
				n0030.addChild(n0035);
				n0032.addChild(n0036);
   				n0032.addChild(n0037);
   				n0035.addChild(n0039);
   				n0035.addChild(n0040);
   				n0037.addChild(n0041);
   				n0037.addChild(n0042);
/////////////////////////////////////////////////////////    arbre abstratet
   				Node n0001 = new Node("request abstraite","VacationPlanner","","alternative");
					Node n0002 = new Node("N2","CurrencyConverter","optional","");
					Node n0003 = new Node("N3","Flight","mandatory","or");
					Node n0004 = new Node("N4","Hotel","optional","");
					Node n0005 = new Node("N5","Guide","optional","");
					Node n0006 = new Node("N6","Payment","mandatory","");
					Node n0007 = new Node("N7","BookRoundFlight","","");
					Node n0008 = new Node("N8","BookWayFlight","","");
					Node n0009 = new Node("N9","SendConfirmation","","");
					Node n00010 = new Node("N10","BankTransfer","","");
					Node n00011 = new Node("N11","CreditCard","","");
					Node n00012 = new Node("N12","BWFlightInput","mandatory","");
					Node n00013 = new Node("N13","BWFlightOutput","mandatory","");
					Node n00014 = new Node("N14","BWFlightFault","optional","");
					Node n00015 = new Node("N15","Destination","mandatory","alternative");
					Node n00016 = new Node("N16","DeparDate","mandatory","");
					Node n00017 = new Node("N17","FlightType","optional","");
					Node n00018 = new Node("N18","FlightNum","mandatory","");
					
					n0001.addChild(n0002);
						n0001.addChild(n0003);
						n0001.addChild(n0004);
						n0001.addChild(n0005);
						n0001.addChild(n0006);
						n0003.addChild(n0007);
   						n0003.addChild(n0008);
   						n0003.addChild(n0009);
   						n0006.addChild(n00010);
   						n0006.addChild(n00011);
   						n0008.addChild(n00012);
   						n0008.addChild(n00013);
   						n0008.addChild(n00014);
   						n00012.addChild(n00015);
   						n00012.addChild(n00016);
   						n00012.addChild(n00017);
   						n00013.addChild(n00018);
/////////////////////////////////////////////////////////    arbre concrete
   						Node n00030 = new Node("request concrete","VacationPlanner","","alternative");
   						
   						n00030.addChild(n0031);
   						n00030.addChild(n0032);
   						n00030.addChild(n0033);
   						n00030.addChild(n0034);
   						n00030.addChild(n0035);
   						n0032.addChild(n0036);
   		   				n0032.addChild(n0037);
   		   				n0035.addChild(n0039);
   		   				n0035.addChild(n0040);
   		   				n0037.addChild(n0041);
   		   				n0037.addChild(n0042);
   		   				
   		   				//////////////////////////////////////////////////////////////////////////// abstraite
   		   				
   		   				
   		   				
   		   			Node n000111 = new Node("request abstraite","VacationPlanner","","alternative");
   		   		    n000111.addChild(n0002);
					n000111.addChild(n0003);
					n000111.addChild(n0004);
					n000111.addChild(n0005);
					n000111.addChild(n0006);
				
					n0003.addChild(n0007);
						n0003.addChild(n0008);
						n0003.addChild(n0009);
						n0006.addChild(n00010);
   						n0006.addChild(n00011);
   						n0008.addChild(n00012);
   						n0008.addChild(n00013);
   						n0008.addChild(n00014);
   						n00012.addChild(n00015);
   						n00012.addChild(n00016);
   						n00012.addChild(n00017);
   						n00013.addChild(n00018);
////////////////////////////////////////////////////////////////////////////concrette
   						Node n000300 = new Node("request concrete","VacationPlanner","","alternative");
   					 n000300.addChild(n0002);
 					n000300.addChild(n0003);
 					n000300.addChild(n0004);
 					n000300.addChild(n0005);
 					n000300.addChild(n0006);
 					n0003.addChild(n0007);
					n0003.addChild(n0008);
					n0003.addChild(n0009);
					n0008.addChild(n00012);
						n0008.addChild(n00013);
						n0008.addChild(n00014);
						n00012.addChild(n00015);
						n00012.addChild(n00016);
						n00012.addChild(n00017);
						n00013.addChild(n00018);
		////////////////////////////////////////////////////////////////				
						
   		   			// for (int I=0; I<5; I++) { 
   		   			listeServicesAbstract.add(n01); 
   		   		    listeServicesConcret.add(n02);
   		   		    
   		   		    listeServicesAbstract.add(n001); 
		   		    listeServicesConcret.add(n0030);
   		   				 
		   		 listeServicesAbstract.add(n0001); 
		   		    listeServicesConcret.add(n00030);	
		   		    
		   			listeServicesAbstract.add(n01); 
		   		   listeServicesConcret.add(n0030);
		   		   
		   		    listeServicesAbstract.add(n000111); 
		   		    listeServicesConcret.add(n000300);
		   		    
		   			listeServicesAbstract.add(n01); 
   		   		    listeServicesConcret.add(n02);
   		   		    
   		       		 listeServicesAbstract.add(n0001);
   		             	listeServicesConcret.add(n02);
		   		    
   		         	listeServicesAbstract.add(n01);
   		            listeServicesConcret.add(n000300);
   		   				 
   		         listeServicesAbstract.add(n01); 
		   		    listeServicesConcret.add(n02);
   		   				
		   		    
		   		 listeServicesAbstract.add(n01);
		            listeServicesConcret.add(n000300);
   		   				 
   		   				 
   		   			// }
   		   			 
		        	Thread tenant1 = new Thread(new DiscoverImpl(1,"tenant1",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant2 = new Thread(new DiscoverImpl(1,"tenant2",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant3 = new Thread(new DiscoverImpl(1,"tenant3",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant4 = new Thread(new DiscoverImpl(1,"tenant4",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant5 = new Thread(new DiscoverImpl(1,"tenant5",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant6 = new Thread(new DiscoverImpl(1,"tenant6",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant7 = new Thread(new DiscoverImpl(1,"tenant7",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant8 = new Thread(new DiscoverImpl(1,"tenant8",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant9 = new Thread(new DiscoverImpl(1,"tenant9",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant10 = new Thread(new DiscoverImpl(1,"tenan10",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant11 = new Thread(new DiscoverImpl(1,"tenant1",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant12 = new Thread(new DiscoverImpl(1,"tenant2",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant13 = new Thread(new DiscoverImpl(1,"tenant3",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant14 = new Thread(new DiscoverImpl(1,"tenant4",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant15 = new Thread(new DiscoverImpl(1,"tenant5",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant16 = new Thread(new DiscoverImpl(1,"tenant6",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant17 = new Thread(new DiscoverImpl(1,"tenant7",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant18 = new Thread(new DiscoverImpl(1,"tenant8",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant19 = new Thread(new DiscoverImpl(1,"tenant9",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant20 = new Thread(new DiscoverImpl(1,"tenan10",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant21 = new Thread(new DiscoverImpl(1,"tenant1",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant22 = new Thread(new DiscoverImpl(1,"tenant2",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant23 = new Thread(new DiscoverImpl(1,"tenant3",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant24 = new Thread(new DiscoverImpl(1,"tenant4",n1,listeServicesAbstract,n30,listeServicesConcret));
	   				Thread tenant25 = new Thread(new DiscoverImpl(1,"tenant5",n1,listeServicesAbstract,n30,listeServicesConcret));
			
			
			
			  long debut = System.currentTimeMillis();
			  
			   tenant1.run(); 
			   tenant2.run();
			   tenant3.run();
			   tenant4.run();
			   tenant5.run();
			   tenant6.run();
			   tenant7.run();
			   tenant8.run();
			   tenant9.run();
			   tenant10.run();
			   tenant11.run(); 
			   tenant12.run();
			   tenant13.run();
			   tenant14.run();
			   tenant15.run();
			   tenant16.run();
			   tenant17.run();
			   tenant18.run();
			   tenant19.run();
			   tenant20.run();
			   tenant21.run(); 
			   tenant22.run();
			   tenant23.run();
			   tenant24.run();
			   tenant25.run();
	   
	    System.out.println("temps d'exécution = ");
	    System.out.println(System.currentTimeMillis()-debut);  
	 
	    
	    

//	    
//	    

	}

}


