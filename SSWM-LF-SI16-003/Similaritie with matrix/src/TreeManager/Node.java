package TreeManager;


import java.awt.Label;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.xml.crypto.Data;

public class Node<T> {
    List<String> Listparcourinv = new ArrayList<>();
    List<String> ListparcourinvN1 = new ArrayList<>();
    List<String> ListparcourinvN2 = new ArrayList<>();
    List<String> ListparcourinvN2moinN1 = new ArrayList<>();
    
    List<Node<T>> children = new ArrayList<Node<T>>();    
    List<Node<T>> children1 = new ArrayList<Node<T>>();
   
  
    
    List<String> conc = new ArrayList<String>();
    public Node<T> parent ;
    private T data ;
    private String label;
    



	String type1=null;
    String type2=null;
    private int depth = 1;
    private int depthf = 1;
 
    
       
    public Node(T data, String label, String type1, String type2) {
        this.data = data;
        this.label = label;
        this.type1=type1;
        this.type2=type2;
        
    }
    public Node(T data, String label) {
        this.data = data;
        this.label = label;
    }
 

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
    
    
    
     public Node(T data,String label, Node<T> parent) {
        this.data = data;
        this.label = label;
        this.setParent(parent);
    }
    
    
     public void setParent(Node<T> parent) {
        this.parent = parent;
        Node <T> iteratorrr = parent;
        int depth= 2;
        while (!iteratorrr.isRoot()) {
        	depth ++;
			iteratorrr = iteratorrr.parent;
		}       
        this.depth = depth;
     }
    
     
    public void removeParent() {
        this.parent = null;
    }
    
    
    public boolean isRoot() {
    	
        return ((this.parent) == null);
    }
    
public boolean isRoott() {
    	
        return (((this.parent).parent) == null);
    }
    
    
    public int getDepth() {
		return depth;
	}
      
    
    public List<Node<T>> getChildren() {
        return children;
    }
     
         
    public void addChild(T data, String label) {
       Node<T> child = new Node<T>(data,label,type1,type2);
       child.setParent(this);
       this.children.add(child);
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }
     
    
    public boolean isLeaf() {
       if(this.children.size() == 0) 
         return true;
       else 
         return false;
    }
    
    
    public int getChildrenCount() {
	  return getChildren().size();
	}
	
	public Node<T> getChildAt(int i) {
		return getChildren().get(i-1);
	}
    
    
    public int GetTaille()
		{ int taille=1;
		for(Node<T> enfant:this.children)
		taille+= enfant.GetTaille();
		return taille;

		  }
    
	
	 public List<Node> parcour() {			
		List<Node> result = new ArrayList<Node>();
	    result.add(this);   			
		for (Iterator iterator = children.iterator(); iterator.hasNext();) 
		  {				
		    Node<T> node = (Node<T>) iterator.next();
			result.addAll(node.parcour()); 
		  } 
			return result;
     } 
	 
	 public List<String> parcourinv(Node<T> t) {
	    Node  iterator = t;
		 while ((!iterator.isRoot())   ) {
			 Listparcourinv.add(iterator.getLabel());
			iterator = iterator.parent;
		 } 
			return Listparcourinv;
	 }
	 
	 
	 public int EnMemeBranche(List<String> s1,List<String> s2) {				 
		 ListparcourinvN1=s1;
		 ListparcourinvN2=s2;
        
        int b=1;
        ListparcourinvN2moinN1 = ListparcourinvN1.subList(0, ListparcourinvN2.size());       	  
		 if (!(ListparcourinvN2moinN1.equals(ListparcourinvN2)))
		 {
		   b=0;
		 }
	  return b;
	 }

	 
	 // Résumé les noeuds
	 public String summarize() {			
		 String txt="";
		 children1=this.getChildren();
		 for (int j=0; j<children1.size(); j++) { 			  
		   txt=txt+children1.get(j).getLabel()+",";			  
		 }
		 
		 txt=this.getType1()+this.getType2()+"("+txt+")";
		 return txt;
     }
	 
	 
	 // Affichage de l'arbre
	 public String toStringg() {
	
		String output = "";
		if (this.isRoot()) output+= "\n I'm ROOT, my name is "+this.getLabel()+" my data = "+this.getData();
		else if (this.isLeaf()) output+= "\n I'm LEAF, my name is "+this.getLabel()+", my data = "+this.getData()+", my depth is "+this.getDepth();
		else output+= "\n I'm NODE, my name is "+this.getLabel()+" my data = "+this.getData()+", my depth is "+this.getDepth();
		for (Iterator iterator = children.iterator(); iterator.hasNext();) 
		{
			Node<T> node = (Node<T>) iterator.next();
			output += node.toString();
		}
		return output;
	} 
	
	 	 
	public String toString() {
		
		 
	        return "[ data=" + data + ", label=" + label + "]";
	    }


}
