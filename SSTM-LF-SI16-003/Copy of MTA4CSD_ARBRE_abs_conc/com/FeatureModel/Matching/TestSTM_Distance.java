package com.FeatureModel.Matching;

//import TreeManager.Node;

public class TestSTM_Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node serviceRequest2 = new Node("request2(vacation planner)","VacationPlanner");
		Node num2 = new Node("N2","CurrencyConverter");
		Node num3 = new Node("N3","Flight");
		Node num4 = new Node("N4", "Hotel");
		Node num5 = new Node("N5", "Guide");
		Node num6 = new Node("N6", "Payment");
		// root children
		serviceRequest2.addChild(num2);
		serviceRequest2.addChild(num3);
		serviceRequest2.addChild(num4);
		serviceRequest2.addChild(num5);
		serviceRequest2.addChild(num6);
// service dans listeService (similaire à serviceRequest2)
		Node serviceVacation = new Node("vacation planner dans liste","VacationPlanner");
		Node node2 = new Node("N2","CurrencyConverter");
		Node node3 = new Node("N3","Flight");
		Node node4 = new Node("N4", "Hotel");
		Node node5 = new Node("N5", "Guide");
		//root children
		serviceVacation.addChild(node2);
		serviceVacation.addChild(node3);
		serviceVacation.addChild(node4);
		serviceVacation.addChild(node5);
		
		// Tree A
				Node n1 = new Node("N1","a");
				Node n2 = new Node("N2","b");
				Node n3 = new Node("N3","c");
				Node n4 = new Node("N4","b");
				Node n5 = new Node("N5","c");
				Node n6 = new Node("N6","d");
				Node n7 = new Node("N7","e");
				Node n8 = new Node("N8","f");
				Node n9 = new Node("N9","e");
				Node n10 = new Node("N10","d");
				Node n11 = new Node("N11","g");
				Node n12 = new Node("N12","h");
				Node n13 = new Node("N13","i");	
				Node n14 = new Node("N13","j");	
				// Root Children
				n1.addChild(n2);
				n1.addChild(n3);
				n1.addChild(n4);
				n1.addChild(n5);
				//N2 Children
				n2.addChild(n6);
				n2.addChild(n7);
				//N3 Children
				n3.addChild(n8);
				//N4 Children
				n4.addChild(n9);
				n4.addChild(n10);
				// N5 Children
				n5.addChild(n11);
				// N11 Children
				n11.addChild(n12);
				n11.addChild(n13);
				n11.addChild(n14);
				
				// Tree B
				Node n15 = new Node("N15","a");
				Node n16 = new Node("N16","b");
				Node n17 = new Node("N17","c");
				Node n18 = new Node("N18","d");
				Node n19 = new Node("N19","e");
				Node n20 = new Node("N20","g");
				Node n21 = new Node("N21","f");
				Node n22 = new Node("N22","h");
				
				// Root Children
				
				n15.addChild(n16);
				n15.addChild(n17);
				//N16 Children
				n16.addChild(n18);
				n16.addChild(n19);
				//N17 Children
				n17.addChild(n20);
				n17.addChild(n21);
						
				//N20 Children
				n20.addChild(n22);
				
				Node system8=new Node("Nsystem8","System");
				Node transport8=new Node("Ntransport","Transport","optional");
				Node reservation8=new Node("Nreservation","Reservation","mandatory");
				Node payment8=new Node("Npayment","Mode Payment","mandatory","alternative");
				Node hotel8= new Node("NHotel","Hotel","mandatory");
				Node flight8=new Node("NFlight","Flight","mandatory");
				Node creditCard8=new Node("NcreditCard","Credit Card");
				Node bankTransfert8=new Node("NBankTransfert","Bank Transfert");
				// add children
				system8.addChild(reservation8);
				system8.addChild(transport8);
				system8.addChild(payment8);
				reservation8.addChild(hotel8);
				reservation8.addChild(flight8);
				payment8.addChild(creditCard8);
				payment8.addChild(bankTransfert8);
				
				Node system=new Node("REQUESTSystem","System");
				Node transport=new Node("NTransport","Transport","optional");
				Node reservation=new Node("NReservation","Reservation","mandatory");
				Node guide=new Node("NGuide","Guide","optional");
				Node payment=new Node("NPayment","Payment","mandatory");
				Node hotel= new Node("NHotel","Hotel","mandatory");
				Node flight=new Node("NFlight","Flight","mandatory");
				Node bankTransfert=new Node("NBankTransfert","Bank Transfert","mandatory");
				// add children
				system.addChild(guide);
				system.addChild(transport);
				system.addChild(reservation);
				system.addChild(payment);
				payment.addChild(bankTransfert);
				reservation.addChild(hotel);
				reservation.addChild(flight);

		//System.out.println("on va voir");
				//System.out.println(SimpleTreeMatching.simpleTreeMatching(n1, n15));
System.out.println("similarité ="+SimpleTreeMatching.ComputeDistance(system8, system,system,system));

		


	}

}
