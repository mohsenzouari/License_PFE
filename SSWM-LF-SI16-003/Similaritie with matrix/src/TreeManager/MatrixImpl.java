package TreeManager;

import java.util.ArrayList;
import java.util.List;

public class MatrixImpl implements Runnable  {
	private int tenantId;
	private int reqConcDepth;
	private int reqAbstDepth;
	private String tenantName;
	private List<Node> listeServicesAbstract = new ArrayList<Node>();
	private List<Node> listeServicesConcrete = new ArrayList<Node>();
	List<Integer> listearAbstractdepth= new ArrayList<Integer>();
	List<Integer> listearConcredepth= new ArrayList<Integer>();
	private Node servicerequestAbstract;
	private Node servicerequestConcrete;
	
	
	
	public MatrixImpl(int tenantId, String tenantName,Node servicerequestAbstract,
			List<Node> listeServicesAbstract,List<Integer> listearAbstractdepth,int reqAbstDepth, Node servicerequestConcrete,
			List<Node> listeServicesConcrete,List<Integer> listearConcredepth,int reqConcDepth) {
		
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.listeServicesAbstract = listeServicesAbstract;
		this.listeServicesConcrete = listeServicesConcrete;
		this.listearAbstractdepth = listearAbstractdepth;
		this.listearConcredepth = listearConcredepth;
		this.servicerequestAbstract = servicerequestAbstract;
		this.servicerequestConcrete = servicerequestConcrete;
		this.reqAbstDepth = reqAbstDepth;
		this.reqConcDepth = reqConcDepth;
	}



	@Override
	public void run() {
		
		System.out.println("c'est le tenant numero"+this.tenantId+"  et son nom="+this.tenantName+" et la partie abstraite de son requete est: "+this.servicerequestAbstract.getLabel()+ " et la partie concrete de son requete est: "+this.servicerequestConcrete.getLabel()+ "\n" );
		
		
		for (int i=0;i<listeServicesAbstract.size();i++)
		{
		TreeEncoding trait =new TreeEncoding(servicerequestAbstract, reqConcDepth,servicerequestAbstract.GetTaille(), listeServicesAbstract.get(i),listearAbstractdepth.get(i), listeServicesAbstract.get(i).GetTaille())	;  
		double SimWithMatrixAbst=trait.AssemblyLineBalancing();         
        System.out.println("La similarité de la partie abstraite  = "+SimWithMatrixAbst );
		
		TreeEncoding traitt =new TreeEncoding(servicerequestConcrete, reqAbstDepth,servicerequestConcrete.GetTaille(), listeServicesConcrete.get(i),listearConcredepth.get(i), listeServicesConcrete.get(i).GetTaille())	;  
		double SimWithMatrixconc=trait.AssemblyLineBalancing();         
        System.out.println("La similarité de la partie concrete = "+SimWithMatrixconc );
        
        double SimWithMatrix=(0.5*SimWithMatrixAbst)+(0.5*SimWithMatrixconc);
        System.out.println("La similarité entre la request et le service N°"+i+" est = "+SimWithMatrix );	
        
        if (SimWithMatrix>0.5)
		{
			 System.err.print("Ce service web N°"+i+" est plus similaire de similarité= "+SimWithMatrix+"   pour   "+this.tenantName+"\n");
		}else{
			 System.err.print("Ce service web N°"+i+" n'est pas similaire de similarité= "+SimWithMatrix+"   pour   "+this.tenantName+"\n");
		}
        
        System.out.println();
        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************");
        
		}
		
		
		
	}
	

	
	
	
}
