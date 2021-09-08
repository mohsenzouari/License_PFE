
import java.util.ArrayList;
import java.util.List;

import TreeManager.MatrixImpl;
import TreeManager.Node;

public class Main {
	
	
	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();
		List<Node> listeServicesAbstract= new ArrayList<Node>();
		List<Node> listeServicesConcret= new ArrayList<Node>();
		List<Integer> listearAbstractdepth= new ArrayList<Integer>();
		List<Integer> listearConcredepth= new ArrayList<Integer>();
		
		int ar2depth,ar1depth;
		int ar2taille,ar1taille;
		
			
		        //La creation et la summarize(résumé) de la request abstraite et concrete 
		
		
				Node<String> n1 = new Node<String>("request abstraite","VacationPlanner","","alternative");
				Node<String> n2 = new Node<String>("N2","CurrencyConverter","optional","");
				Node<String> n3 = new Node<String>("N3","Flight","mandatory","or");
				Node<String> n4 = new Node<String>("N4","Hotel","optional","");
				Node<String> n5 = new Node<String>("N5","Guide","optional","");
				Node<String> n6 = new Node<String>("N6","Payment","mandatory","");
				Node<String> n7 = new Node<String>("N7","BookRoundFlight","","");
				Node<String> n8 = new Node<String>("N8","BookWayFlight","","");
				Node<String> n9 = new Node<String>("N9","SendConfirmation","","");
				Node<String> n10 = new Node<String>("N10","BankTransfer","","");
				Node<String> n11 = new Node<String>("N11","CreditCard","","");
				Node<String> n12 = new Node<String>("N12","BWFlightInput","mandatory","");
				Node<String> n13 = new Node<String>("N13","BWFlightOutput","mandatory","");
				Node<String> n14 = new Node<String>("N14","BWFlightFault","optional","");
				Node<String> n15 = new Node<String>("N15","Destination","mandatory","alternative");
				Node<String> n16 = new Node<String>("N16","DeparDate","mandatory","");
				Node<String> n17 = new Node<String>("N17","FlightType","optional","");
				Node<String> n18 = new Node<String>("N18","FlightNum","mandatory","");
			
				
				Node<String> n1suroot = new Node<String>("N1suroot",n1.getLabel());
				// Root Children de l'arbre 1
				n1.addChild(n2);
				n1.addChild(n3);
				n1.addChild(n4);
				n1.addChild(n5);
				n1.addChild(n6);
				Node<String> n1su = new Node<String>("N1su",n1.summarize());

				
				//*****************N3 Children de l'arbre 1*********
				n3.addChild(n7);
				n3.addChild(n8);
				n3.addChild(n9);
				Node<String> n3su = new Node<String>("N3su",n3.summarize());

				//***************N6 Children de l'arbre 1************
				n6.addChild(n10);
				n6.addChild(n11);
				Node<String> n6su = new Node<String>("N6su",n6.summarize());

				//***************N8 Children de l'arbre 1************
				n8.addChild(n12);
				n8.addChild(n13);
				n8.addChild(n14);
				Node<String> n8su = new Node<String>("N8su",n8.summarize());

				//************N12 Children de l'arbre 1************
				n12.addChild(n15);
				n12.addChild(n16);
				n12.addChild(n17);
				Node<String> n12su = new Node<String>("N12su",n12.summarize());

				//***********N13 Children de l'arbre 1***********
				n13.addChild(n18);
				Node<String> n13su = new Node<String>("N13su",n13.summarize());
						
						
						// Root Children de l'arbre 1 résumée
						n1suroot.addChild(n1su);
						// n1su Children de l'arbre 1 résumée
						n1su.addChild(n3su);
						n1su.addChild(n6su);
						// n3su Children de l'arbre 1 résumée
						n3su.addChild(n8su);
						// n8su Children de l'arbre 1 résumée
						n8su.addChild(n12su);
						n8su.addChild(n13su);
						
				
						ar1depth =n13su.getDepth();
						
						
						
						
						
						Node<String> n30 = new Node<String>("request concrete","VacationPlanner","","alternative");
						Node<String> n31 = new Node<String>("N31","CurrencyConverter","optional","");
						Node<String> n32 = new Node<String>("N32","Flight","mandatory","or");
						Node<String> n33 = new Node<String>("N33","Hotel","optional","");
						Node<String> n34 = new Node<String>("N34","Guide","optional","");
						Node<String> n35 = new Node<String>("N35","Payment","mandatory","");
						Node<String> n36 = new Node<String>("N36","BookRoundFlight","","");
						Node<String> n37 = new Node<String>("N37","BookWayFlight","","");
						Node<String> n38 = new Node<String>("N38","SendConfirmation","","");
						Node<String> n39 = new Node<String>("N39","BankTransfer","","");
						Node<String> n40 = new Node<String>("N40","CreditCard","","");
						Node<String> n41 = new Node<String>("N41","BWFlightInput","mandatory","");
						Node<String> n42 = new Node<String>("N42","BWFlightOutput","mandatory","");
						Node<String> n43 = new Node<String>("N43","BWFlightFault","optional","");
						Node<String> n44 = new Node<String>("N44","Destination","mandatory","alternative");
						Node<String> n45 = new Node<String>("N45","DeparDate","mandatory","");
						Node<String> n46 = new Node<String>("N46","FlightType","optional","");
						Node<String> n47 = new Node<String>("N47","FlightNum","mandatory","");
						
				
						
						
						
						// Root Children
						n30.addChild(n31);
						n30.addChild(n32);
						n30.addChild(n33);
						n30.addChild(n34);
						n30.addChild(n35);
						Node<String> n30suroot = new Node<String>("n30suroot",n30.getLabel());
						Node<String> n30su = new Node<String>("n30su",n30.summarize());

						//*****************N3 Children*********
						n32.addChild(n36);
						n32.addChild(n37);
						n32.addChild(n38);
						Node<String> n32su = new Node<String>("n32su",n32.summarize());

						//***************N35 Children************
						n35.addChild(n39);
						n35.addChild(n40);
						Node<String> n35su = new Node<String>("n35su",n35.summarize());

						//***************N37 Children************
						n37.addChild(n41);
						n37.addChild(n42);
						n37.addChild(n43);
						Node<String> n37su = new Node<String>("n37su",n37.summarize());

						//************N41 Children************
							n41.addChild(n44);
							n41.addChild(n45);
							n41.addChild(n46);
							Node<String> n41su = new Node<String>("n41su",n41.summarize());

						//***********N42 Children ***********
							n42.addChild(n47);
							Node<String> n42su = new Node<String>("n42su",n42.summarize());

					
                                
								// Root Children de l'arbre 2 résumée
								n30suroot.addChild(n30su);
								// n30su Children de l'arbre 2 résumée
								n30su.addChild(n32su);
								n30su.addChild(n35su);
								// n32su Children de l'arbre 2 résumée
								n32su.addChild(n37su);
								// n37su Children de l'arbre 2 résumée
								n37su.addChild(n41su);
								n37su.addChild(n42su);
								

		
		                        ar2depth =n42su.getDepth();
								
								
								
		                        
		
		     
			//La creation et la summarize(résumé) de la provider abstraite et concrete 
			
				   Node<String> n1surootprovider = new Node<String>("Provider Abstraite",n1.getLabel());								
					
					// Root Children de Provider Abstraite
					n1surootprovider.addChild(n1su);
					// n1su Children de Provider Abstraite
					n1su.addChild(n3su);
					n1su.addChild(n6su);
				
					
					
					
			
					
					
					
					
					
					
					
					    Node<String> n30surootprovider = new Node<String>("Provider Concrete",n1.getLabel());
                         
							// Root Children de Provider Concrete
					        n30surootprovider.addChild(n30su);
							// n30su Children de Provider Concrete
							n30su.addChild(n32su);
							n30su.addChild(n35su);
							

	
	                       
			
							
							
		     
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							//La creation et la summarize(résumé) de l'Arbre 1
							
							
							Node<String> n01 = new Node<String>("N01","VacationPlanner","","alternative");
							Node<String> n02 = new Node<String>("N02","CurrencyConverter","optional","");
							Node<String> n03 = new Node<String>("N03","Flight","mandatory","or");
							Node<String> n04 = new Node<String>("N04","Hotel","optional","");
							Node<String> n05 = new Node<String>("N05","Guide","optional","");
							Node<String> n06 = new Node<String>("N06","Payment","mandatory","");
							Node<String> n07 = new Node<String>("N07","BookRoundFlight","","");
							Node<String> n08 = new Node<String>("N08","BookWayFlight","","");
							Node<String> n09 = new Node<String>("N09","SendConfirmation","","");
							Node<String> n010 = new Node<String>("N010","BankTransfer","","");
							Node<String> n011 = new Node<String>("N011","CreditCard","","");
							Node<String> n012 = new Node<String>("N012","BWFlightInput","mandatory","");
							Node<String> n013 = new Node<String>("N013","BWFlightOutput","mandatory","");
							Node<String> n014 = new Node<String>("N014","BWFlightFault","optional","");
							Node<String> n015 = new Node<String>("N015","Destination","mandatory","alternative");
							Node<String> n016 = new Node<String>("N016","DeparDate","mandatory","");
							Node<String> n017 = new Node<String>("N017","FlightType","optional","");
							
							
							Node<String> n01suroot = new Node<String>("N1suroot",n01.getLabel());
							// Root Children de l'arbre 1
							n01.addChild(n02);
							n01.addChild(n03);
							n01.addChild(n04);
							n01.addChild(n05);
							n01.addChild(n06);
							Node<String> n01su = new Node<String>("N01su",n01.summarize());

							
							//*****************N03 Children de l'arbre 1*********
							n03.addChild(n07);
							n03.addChild(n08);
							n03.addChild(n09);
							Node<String> n03su = new Node<String>("N03su",n03.summarize());

							//***************N06 Children de l'arbre 1************
							n06.addChild(n010);
							n06.addChild(n011);
							Node<String> n06su = new Node<String>("N6su",n06.summarize());

							//***************N08 Children de l'arbre 1************
							n08.addChild(n012);
							n08.addChild(n013);
							n08.addChild(n014);
							Node<String> n08su = new Node<String>("N08su",n08.summarize());

							//************N012 Children de l'arbre 1************
							n012.addChild(n015);
							n012.addChild(n016);
							n012.addChild(n017);
							Node<String> n012su = new Node<String>("N012su",n012.summarize());

							
									
									
									// Root Children de l'arbre 1 résumée
									n01suroot.addChild(n01su);
									// n1su Children de l'arbre 1 résumée
									n01su.addChild(n03su);
									n01su.addChild(n06su);
									// n3su Children de l'arbre 1 résumée
									n03su.addChild(n08su);
									// n8su Children de l'arbre 1 résumée
									n08su.addChild(n012su);
									
								
									
									//La creation et la summarize(résumé) de l'Arbre 2
									Node<String> n030 = new Node<String>("N030","VacationPlanner","","alternative");
									Node<String> n031 = new Node<String>("N031","CurrencyConverter","optional","");
									Node<String> n032 = new Node<String>("N032","Flight","mandatory","or");
									Node<String> n033 = new Node<String>("N033","Hotel","optional","");
									Node<String> n034 = new Node<String>("N034","Guide","optional","");
									Node<String> n035 = new Node<String>("N035","Payment","mandatory","");
									Node<String> n036 = new Node<String>("N036","BookRoundFlight","","");
									Node<String> n037 = new Node<String>("N037","BookWayFlight","","");
									Node<String> n038 = new Node<String>("N038","SendConfirmation","","");
									Node<String> n039 = new Node<String>("N039","BankTransfer","","");
									Node<String> n040 = new Node<String>("N040","CreditCard","","");
									Node<String> n041 = new Node<String>("N041","BWFlightInput","mandatory","");
									Node<String> n042 = new Node<String>("N042","BWFlightOutput","mandatory","");
									Node<String> n043 = new Node<String>("N043","BWFlightFault","optional","");
									Node<String> n044 = new Node<String>("N044","Destination","mandatory","alternative");
									Node<String> n045 = new Node<String>("N045","DeparDate","mandatory","");
									Node<String> n046 = new Node<String>("N046","FlightType","optional","");
									
							
									
									
									
									// Root Children
									n030.addChild(n031);
									n030.addChild(n032);
									n030.addChild(n033);
									n030.addChild(n034);
									n030.addChild(n035);
									Node<String> n030suroot = new Node<String>("n030suroot",n030.getLabel());
									Node<String> n030su = new Node<String>("n030su",n030.summarize());

									//*****************N03 Children*********
									n032.addChild(n036);
									n032.addChild(n037);
									n032.addChild(n038);
									Node<String> n032su = new Node<String>("n032su",n032.summarize());

									//***************N035 Children************
									n035.addChild(n039);
									n035.addChild(n040);
									Node<String> n035su = new Node<String>("n035su",n035.summarize());

									//***************N037 Children************
									n037.addChild(n041);
									n037.addChild(n042);
									n037.addChild(n043);
									Node<String> n037su = new Node<String>("n037su",n037.summarize());

									//************N041 Children************
										n041.addChild(n044);
										n041.addChild(n045);
										n041.addChild(n046);
										Node<String> n041su = new Node<String>("n041su",n041.summarize());

									
			                                
											// Root Children de l'arbre 2 résumée
											n030suroot.addChild(n030su);
											// n030su Children de l'arbre 2 résumée
											n030su.addChild(n032su);
											n030su.addChild(n035su);
											// n032su Children de l'arbre 2 résumée
											n032su.addChild(n037su);
											// n037su Children de l'arbre 2 résumée
											n037su.addChild(n041su);
											

					
					                        
											
							
							
							
							
							
							
											
											
											
          //La creation et la summarize(résumé) de la provider abstraite et concrete 
   		
   		
   		Node<String> n001 = new Node<String>("request abstraite","VacationPlanner","","alternative");
   		Node<String> n002 = new Node<String>("N002","CurrencyConverter","optional","");
   		Node<String> n003 = new Node<String>("N003","Flight","mandatory","or");
   		Node<String> n004 = new Node<String>("N004","Hotel","optional","");
   		Node<String> n005 = new Node<String>("N005","Guide","optional","");
   		Node<String> n006 = new Node<String>("N006","Payment","mandatory","");
   		Node<String> n007 = new Node<String>("N007","BookRoundFlight","","");
   		Node<String> n008 = new Node<String>("N008","BookWayFlight","","");
   		Node<String> n009 = new Node<String>("N009","SendConfirmation","","");
   		Node<String> n0010 = new Node<String>("N0010","BankTransfer","","");
   		Node<String> n0011 = new Node<String>("N0011","CreditCard","","");
   		Node<String> n0012 = new Node<String>("N0012","BWFlightInput","mandatory","");
   		Node<String> n0013 = new Node<String>("N0013","BWFlightOutput","mandatory","");
   		Node<String> n0014 = new Node<String>("N0014","BWFlightFault","optional","");
   		Node<String> n0015 = new Node<String>("N0015","Destination","mandatory","alternative");
   	
   		
   		Node<String> n001suroot = new Node<String>("N001suroot",n001.getLabel());
   		// Root Children de l'arbre 1
   		n001.addChild(n002);
   		n001.addChild(n003);
   		n001.addChild(n004);
   		n001.addChild(n005);
   		n001.addChild(n006);
   		Node<String> n001su = new Node<String>("N001su",n001.summarize());

   		
   		//*****************N003 Children de l'arbre 1*********
   		n003.addChild(n007);
   		n003.addChild(n008);		
   		Node<String> n003su = new Node<String>("N003su",n003.summarize());

   		//***************N006 Children de l'arbre 1************
   		n006.addChild(n0010);
   		n006.addChild(n0011);
   		Node<String> n006su = new Node<String>("N006su",n006.summarize());

   		//***************N008 Children de l'arbre 1************
   		n008.addChild(n0012);
   		n008.addChild(n0013);
   		
   		Node<String> n008su = new Node<String>("N008su",n008.summarize());

   				
   				
   				// Root Children de l'arbre 1 résumée
   				n001suroot.addChild(n001su);
   				// n1su Children de l'arbre 1 résumée
   				n001su.addChild(n003su);
   				n001su.addChild(n006su);
   				// n3su Children de l'arbre 1 résumée
   				n003su.addChild(n008su);
   				
   				
   		
   				
   				
   				
   				
   				Node<String> n0030 = new Node<String>("request concrete","VacationPlanner","","alternative");
   				Node<String> n0031 = new Node<String>("N0031","CurrencyConverter","optional","");
   				Node<String> n0032 = new Node<String>("N0032","Flight","mandatory","or");
   				Node<String> n0033 = new Node<String>("N0033","Hotel","optional","");
   				Node<String> n0034 = new Node<String>("N0034","Guide","optional","");
   				Node<String> n0035 = new Node<String>("N0035","Payment","mandatory","");
   				Node<String> n0036 = new Node<String>("N0036","BookRoundFlight","","");
   				Node<String> n0037 = new Node<String>("N0037","BookWayFlight","","");
   				Node<String> n0038 = new Node<String>("N0038","SendConfirmation","","");
   				Node<String> n0039 = new Node<String>("N0039","BankTransfer","","");
   				Node<String> n0040 = new Node<String>("N0040","CreditCard","","");
   				Node<String> n0041 = new Node<String>("N0041","BWFlightInput","mandatory","");
   				Node<String> n0042 = new Node<String>("N0042","BWFlightOutput","mandatory","");
   				Node<String> n0043 = new Node<String>("N0043","BWFlightFault","optional","");
   			
   				
   		
   				
   				
   				
   				// Root Children
   				n0030.addChild(n0031);
   				n0030.addChild(n0032);
   				n0030.addChild(n0033);
   				n0030.addChild(n0034);
   				n0030.addChild(n0035);
   				Node<String> n0030suroot = new Node<String>("n0030suroot",n0030.getLabel());
   				Node<String> n0030su = new Node<String>("n0030su",n0030.summarize());

   				//*****************N3 Children*********
   				n0032.addChild(n0036);
   				n0032.addChild(n0037);
   				Node<String> n0032su = new Node<String>("n32su",n0032.summarize());

   				//***************N0035 Children************
   				n0035.addChild(n0039);
   				n0035.addChild(n0040);
   				Node<String> n0035su = new Node<String>("n35su",n0035.summarize());

   				//***************N0037 Children************
   				n0037.addChild(n0041);
   				n0037.addChild(n0042);
   				
   				Node<String> n0037su = new Node<String>("n0037su",n0037.summarize());

                           
   						// Root Children de l'arbre 2 résumée
   						n0030suroot.addChild(n0030su);
   						// n0030su Children de l'arbre 2 résumée
   						n0030su.addChild(n0032su);
   						n0030su.addChild(n0035su);
   						// n32su Children de l'arbre 2 résumée
   						n0032su.addChild(n0037su);
   						
   						


                           
                           
   		                       
   								
											
											
											
											
											
											
											
											
											
											
											
											
											
							
							
							
							
							
					
   						
   						
   					//La creation et la summarize(résumé) de la provider abstraite et concrete 
   						
   						
   						Node<String> n0001 = new Node<String>("request abstraite","VacationPlanner","","alternative");
   						Node<String> n0002 = new Node<String>("N2","CurrencyConverter","optional","");
   						Node<String> n0003 = new Node<String>("N3","Flight","mandatory","or");
   						Node<String> n0004 = new Node<String>("N4","Hotel","optional","");
   						Node<String> n0005 = new Node<String>("N5","Guide","optional","");
   						Node<String> n0006 = new Node<String>("N6","Payment","mandatory","");
   						Node<String> n0007 = new Node<String>("N7","BookRoundFlight","","");
   						Node<String> n0008 = new Node<String>("N8","BookWayFlight","","");
   						Node<String> n0009 = new Node<String>("N9","SendConfirmation","","");
   						Node<String> n00010 = new Node<String>("N10","BankTransfer","","");
   						Node<String> n00011 = new Node<String>("N11","CreditCard","","");
   						Node<String> n00012 = new Node<String>("N12","BWFlightInput","mandatory","");
   						Node<String> n00013 = new Node<String>("N13","BWFlightOutput","mandatory","");
   						Node<String> n00014 = new Node<String>("N14","BWFlightFault","optional","");
   						Node<String> n00015 = new Node<String>("N15","Destination","mandatory","alternative");
   						Node<String> n00016 = new Node<String>("N16","DeparDate","mandatory","");
   						Node<String> n00017 = new Node<String>("N17","FlightType","optional","");
   						Node<String> n00018 = new Node<String>("N18","FlightNum","mandatory","");
   						
   						Node<String> n0001suroot = new Node<String>("N1suroot",n0001.getLabel());
   						// Root Children de l'arbre 1
   						n0001.addChild(n0002);
   						n0001.addChild(n0003);
   						n0001.addChild(n0004);
   						n0001.addChild(n0005);
   						n0001.addChild(n0006);
   						Node<String> n0001su = new Node<String>("N1su",n0001.summarize());

   						
   						//*****************N3 Children de l'arbre 1*********
   						n0003.addChild(n0007);
   						n0003.addChild(n0008);
   						n0003.addChild(n0009);
   						Node<String> n0003su = new Node<String>("N3su",n0003.summarize());

   						//***************N6 Children de l'arbre 1************
   						n0006.addChild(n00010);
   						n0006.addChild(n00011);
   						Node<String> n0006su = new Node<String>("N6su",n0006.summarize());

   						//***************N8 Children de l'arbre 1************
   						n0008.addChild(n00012);
   						n0008.addChild(n00013);
   						n0008.addChild(n00014);
   						Node<String> n0008su = new Node<String>("N8su",n0008.summarize());

   						//************N12 Children de l'arbre 1************
   						n00012.addChild(n00015);
   						n00012.addChild(n00016);
   						n00012.addChild(n00017);
   						Node<String> n00012su = new Node<String>("N12su",n00012.summarize());

   						//***********N13 Children de l'arbre 1***********
   						n00013.addChild(n00018);
   						Node<String> n00013su = new Node<String>("N13su",n00013.summarize());
   								
   								
   								// Root Children de l'arbre 1 résumée
   								n0001suroot.addChild(n0001su);
   								// n1su Children de l'arbre 1 résumée
   								n0001su.addChild(n0003su);
   								n0001su.addChild(n0006su);
   								
   								// n3su Children de l'arbre 1 résumée
   								n0003su.addChild(n0008su);
   								// n8su Children de l'arbre 1 résumée
   								n0008su.addChild(n00012su);
   								
   								n0008su.addChild(n00013su);
   								
   						
   								
   								
   								
   								
   								Node<String> n00030 = new Node<String>("request concrete","VacationPlanner","","alternative");
   								Node<String> n00031 = new Node<String>("N31","CurrencyConverter","optional","");
   								Node<String> n00032 = new Node<String>("N32","Flight","mandatory","or");
   								Node<String> n00033 = new Node<String>("N33","Hotel","optional","");
   								Node<String> n00034 = new Node<String>("N34","Guide","optional","");
   								Node<String> n00035 = new Node<String>("N35","Payment","mandatory","");
   								Node<String> n00036 = new Node<String>("N36","BookRoundFlight","","");
   								Node<String> n00037 = new Node<String>("N37","BookWayFlight","","");
   								Node<String> n00038 = new Node<String>("N38","SendConfirmation","","");
   								Node<String> n00039 = new Node<String>("N39","BankTransfer","","");
   								Node<String> n00040 = new Node<String>("N40","CreditCard","","");
   								Node<String> n00041 = new Node<String>("N41","BWFlightInput","mandatory","");
   								Node<String> n00042 = new Node<String>("N42","BWFlightOutput","mandatory","");
   								Node<String> n00043 = new Node<String>("N43","BWFlightFault","optional","");
   								Node<String> n00044 = new Node<String>("N44","Destination","mandatory","alternative");
   								Node<String> n00045 = new Node<String>("N45","DeparDate","mandatory","");
   								Node<String> n00046 = new Node<String>("N46","FlightType","optional","");
   								Node<String> n00047 = new Node<String>("N47","FlightNum","mandatory","");
   								
   						
   								
   								
   								
   								// Root Children
   								n00030.addChild(n00031);
   								n00030.addChild(n00032);
   								n00030.addChild(n00033);
   								n00030.addChild(n00034);
   								n00030.addChild(n00035);
   								Node<String> n00030suroot = new Node<String>("n30suroot",n00030.getLabel());
   								Node<String> n00030su = new Node<String>("n30su",n00030.summarize());

   								//*****************N3 Children*********
   								n00032.addChild(n00036);
   								n00032.addChild(n00037);
   								n00032.addChild(n00038);
   								Node<String> n00032su = new Node<String>("n32su",n00032.summarize());

   								//***************N35 Children************
   								n00035.addChild(n00039);
   								n00035.addChild(n00040);
   								Node<String> n00035su = new Node<String>("n35su",n00035.summarize());

   								//***************N37 Children************
   								n00037.addChild(n00041);
   								n00037.addChild(n00042);
   								n00037.addChild(n00043);
   								Node<String> n00037su = new Node<String>("n37su",n00037.summarize());

   								//************N41 Children************
   									n00041.addChild(n00044);
   									n00041.addChild(n00045);
   									n00041.addChild(n00046);
   									Node<String> n00041su = new Node<String>("n41su",n00041.summarize());

   								//***********N42 Children ***********
   									n00042.addChild(n00047);
   									Node<String> n00042su = new Node<String>("n42su",n00042.summarize());

   							
   				                        
   										// Root Children de l'arbre 2 résumée
   										n00030suroot.addChild(n00030su);
   										
   										
   										// n30su Children de l'arbre 2 résumée
   										n00030su.addChild(n00032su);
   										n00030su.addChild(n00035su);
   										
   										// n32su Children de l'arbre 2 résumée
   										n00032su.addChild(n00037su);
   										
   										// n37su Children de l'arbre 2 résumée
   									
   										n00037su.addChild(n00041su);
   										n00037su.addChild(n00042su);
   										


   				                      
   						
   						
   						
   						
   						
   						
   						
   						
   						
   						
   						
   						
   						
   						
   	             for (int I=0; I<5; I++) { 		
							
						 
							listeServicesAbstract.add(n0001suroot);												    
							listeServicesConcret.add(n30surootprovider);												  
							listearAbstractdepth.add(n00013su.getDepth());						  
							listearConcredepth.add(n42su.getDepth());	
							
							
							
							
							    
								listeServicesAbstract.add(n1surootprovider);															 
								listeServicesConcret.add(n30surootprovider);														   
								listearAbstractdepth.add(n13su.getDepth());														 
								listearConcredepth.add(n42su.getDepth());
							
							
							
							
							   
								listeServicesAbstract.add(n0001suroot);															   
								listeServicesConcret.add(n30surootprovider);														   
								listearAbstractdepth.add(n00013su.getDepth());						   
								listearConcredepth.add(n42su.getDepth());

							
							
							   
								listeServicesAbstract.add(n01suroot);							    
								listeServicesConcret.add(n030suroot);							 
								listearAbstractdepth.add(n012su.getDepth());					   
								listearConcredepth.add(n041su.getDepth());
							
							
							
							   
								listeServicesAbstract.add(n1surootprovider);						   
								listeServicesConcret.add(n30surootprovider);							   
								listearAbstractdepth.add(n13su.getDepth());							   
								listearConcredepth.add(n42su.getDepth());
		
							
							   
								listeServicesAbstract.add(n0001suroot);															   
								listeServicesConcret.add(n30surootprovider);							  
								listearAbstractdepth.add(n00013su.getDepth());  
								listearConcredepth.add(n42su.getDepth());
							
							
							
							
							    
								listeServicesAbstract.add(n0001suroot);
								listeServicesConcret.add(n00030suroot);
								listearAbstractdepth.add(n00013su.getDepth()); 
								listearConcredepth.add(n00042su.getDepth());
							
							
							
							
							
						   
								listeServicesAbstract.add(n1surootprovider);															    
								listeServicesConcret.add(n00030suroot);														   
								listearAbstractdepth.add(n13su.getDepth());						  
								listearConcredepth.add(n00042su.getDepth());
							
							
							
							
							
							
							    
								listeServicesAbstract.add(n1surootprovider);															
								listeServicesConcret.add(n30surootprovider);														  
								listearAbstractdepth.add(n13su.getDepth());    
								listearConcredepth.add(n42su.getDepth());
							
							
							
							
							
							
								listeServicesAbstract.add(n1surootprovider);
								listeServicesConcret.add(n00030suroot);
								listearAbstractdepth.add(n13su.getDepth());							 
								listearConcredepth.add(n00042su.getDepth());
						
   	             }
								
								
							
   Thread tenant1 = new Thread(new MatrixImpl(1,"tenant1",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));					
   Thread tenant2 = new Thread(new MatrixImpl(2,"tenant2",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant3 = new Thread(new MatrixImpl(3,"tenant3",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant4 = new Thread(new MatrixImpl(4,"tenant4",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant5 = new Thread(new MatrixImpl(5,"tenant5",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant6 = new Thread(new MatrixImpl(6,"tenant6",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant7 = new Thread(new MatrixImpl(7,"tenant7",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant8 = new Thread(new MatrixImpl(8,"tenant8",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant9 = new Thread(new MatrixImpl(9,"tenant9",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant10 = new Thread(new MatrixImpl(10,"tenant10",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant11 = new Thread(new MatrixImpl(11,"tenant11",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant12 = new Thread(new MatrixImpl(12,"tenant12",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant13 = new Thread(new MatrixImpl(13,"tenant13",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant14 = new Thread(new MatrixImpl(14,"tenant14",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant15 = new Thread(new MatrixImpl(15,"tenant15",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant16 = new Thread(new MatrixImpl(16,"tenant16",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant17 = new Thread(new MatrixImpl(17,"tenant17",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant18 = new Thread(new MatrixImpl(18,"tenant18",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant19 = new Thread(new MatrixImpl(19,"tenant19",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant20 = new Thread(new MatrixImpl(20,"tenant20",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant21 = new Thread(new MatrixImpl(21,"tenant21",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant22 = new Thread(new MatrixImpl(22,"tenant22",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant23 = new Thread(new MatrixImpl(23,"tenant23",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant24 = new Thread(new MatrixImpl(24,"tenant24",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   Thread tenant25 = new Thread(new MatrixImpl(25,"tenant25",n1suroot,listeServicesAbstract,listearAbstractdepth,ar1depth,n30suroot,listeServicesConcret,listearConcredepth,ar2depth));
   
   
   
   long debut = System.currentTimeMillis();   
   tenant1.run(); 
   System.out.println("temps d'excution = ");
   System.out.println(System.currentTimeMillis()-debut+" ms"); 
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
   System.out.println("temps d'excution = ");
   System.out.println(System.currentTimeMillis()-debut+" ms"); 
   tenant16.run();
   tenant17.run();
   tenant18.run();
   tenant19.run();
   tenant20.run();
   System.out.println("temps d'excution = ");
   System.out.println(System.currentTimeMillis()-debut+" ms"); 
   /*tenant21.run();
   tenant22.run();
   tenant23.run();
   tenant24.run();
   tenant25.run();
   System.out.println("temps d'excution = ");
   System.out.println(System.currentTimeMillis()-debut+" ms"); */
		
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
		
		
		
		
		/*
		TreeEncoding trait =new TreeEncoding(n1suroot, ar1depth,ar1taille, n30suroot, ar2depth,ar2taille)	;  


	         trait.AssemblyLineBalancing();    	
	         System.out.println();
		
		
	         System.out.println("*********************************************");
				System.out.println("l'affichage de la parcour de l'arbre 1");
				list=n1.parcour();
				for (int j=0; j<list.size(); j++) {    
					System.out.println(list.get(j).getLabel());}
				System.out.println("*********************************************");
				System.out.println("l'affichage de la parcour de l'arbre 1 aprés les traitements");
				list=n1suroot.parcour();	
				for (int j=0; j<list.size(); j++) {    
					System.out.println(list.get(j).getLabel());}
	         
	         
				System.out.println("*********************************************");
				System.out.println("l'affichage de la parcour de l'arbre 2");
				list=n30.parcour();
				for (int j=0; j<list.size(); j++) {    
					System.out.println(list.get(j).getLabel());}
				System.out.println("*********************************************");
				System.out.println("l'affichage de la parcour de l'arbre 2 aprés les traitements");
				list=n30suroot.parcour();	
				for (int j=0; j<list.size(); j++) {    
					System.out.println(list.get(j).getLabel());}*/		 

}}
