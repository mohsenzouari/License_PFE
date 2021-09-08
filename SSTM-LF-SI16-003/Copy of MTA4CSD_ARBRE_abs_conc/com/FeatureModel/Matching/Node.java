package com.FeatureModel.Matching;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node {
    private List<Node> children = new ArrayList<Node>();
    private Node parent = null;
    private String data = null;//les indices des noeuds
    private String label ;
    private int depth = 0;
    private String type1= null;
    private String type2= null;

    public Node(String data, String label) {
        this.data = data;
        this.label = label;
    }

    public Node(String data, String label, Node parent) {
        this.data = data;
        this.label = label;
        this.setParent(parent);
    }
    
    public Node(String data, String label,String type1, String type2){
    	this.data= data;
    	this.label=label;
    	//this.setParent(parent);
    	this.setType1(type1);
    	this.setType2(type2);
    }
    public Node(String data, String label, String type1){
    	this.data= data;
    	this.label=label;
    	//this.setParent(parent);
    	this.setType1(type1);
    }
    public List<Node> getChildren() {
        return children;
    }

    public void setParent(Node parent) { 
        //System.out.println("ok");
    	//parent.addChild(this);
        this.parent = parent;
        Node  iterator = parent;
        int depth = 1;
        while (!iterator.isRoot()) {
			depth ++;
			iterator = iterator.parent;
		}
        this.depth = depth;
    }

    public void addChild(String data, String label) {
        Node child = new Node(data,label,this);
        //child.setParent(this);
        this.children.add(child);
    }
   /* public void addChild(T data, String label,String type1,String type2) {
        Node<T> child = new Node<T>(data,label,type1,type2,this);
        //child.setParent(this);
        this.children.add(child);
    }
    
    public void addChild(T data, String label,String type1) {
        Node<T> child = new Node<T>(data,label,type1,this);
        //child.setParent(this);
        this.children.add(child);
    }*/

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getLabel() {
        return this.label;
    }
    

    public void setLabel(String label) {
        this.label = label;
    }


    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if(this.children.size() == 0) 
            return true;
        else 
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }

	public int getDepth() {
		return depth;
	}
	
	public int getChildrenCount() {
		return getChildren().size();
	}
	
	public Node getChildAt(int i) {
		return getChildren().get(i-1);//getChildren designe la liste des noeuds fils
	}
	public int GetTaille()
	{ int taille=1;
	for(Node enfant:this.children)
	taille+= enfant.GetTaille();
	return taille;
	  }
	
	/*public int Get_Cardinality_Non_Intermediaire()
	{int nb=0;
	 if(this.isRoot()==true || this.isLeaf()==true )
		{	if (this.type1!=null || this.type2!=null)
		     	nb=1;
		for(Node<T> enfant:this.children)
		{if (enfant.isLeaf()==true)
			if (enfant.getType1()!=null || ) 
			
		}
	 }	
	 return nb;	
	}*/
	
	public int Get_Nb_Cardinality1()
	{ int Nb=0;
	  if (this.type1!= null) 
			 Nb=1; 
	  for(Node enfant:this.children)
	  {  if (enfant.getType1()!= null)
			  Nb+= enfant.Get_Nb_Cardinality1();
	  }
	  return Nb;
	}
	
	public int Get_Nb_Cardinality2()
	{ int Nb=0;
	  if (this.type2!= null) 
			 Nb=1; 
	  for(Node enfant:this.children)
	  {  if (enfant.getType2()!= null)
			  Nb+= enfant.Get_Nb_Cardinality2();
	  }
	  return Nb;
	}
	


	/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		String output = "";
		if (this.isRoot()) output+= "\n I'm ROOT, my name is "+this.getLabel()+" my data = "+this.getData();
		else if (this.isLeaf()) output+= "\n I'm LEAF, my name is "+this.getLabel()+", my data = "+this.getData()+", my depth is "+this.getDepth();
		else output+= "\n I'm NODE, my name is "+this.getLabel()+" my data = "+this.getData()+", my depth is "+this.getDepth();
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			output += node.toString();
		}
		return output;
	}*/
	//*********** fonction retourne nbCardinality1 des noeuds intermédiaires******
public int Cardinality1_Inter()
{
 int compteurInter=0;
	if (this.isLeaf()==false && this.isRoot()==false)
	
	{if (this.getType1()!=null)
		compteurInter=compteurInter+1;
	}
	for (Iterator iterator = children.iterator(); iterator.hasNext();) {
		Node node = (Node) iterator.next();
		compteurInter=compteurInter+node.Cardinality1_Inter();
	}
	
	return compteurInter;}

//*********** fonction retourne nbCardinality1 des feuilles******
public int Cardinality1_Leaf()
{
 int compteurLeaf=0;
	if (this.isLeaf()==true)
	
	{if (this.getType1()!=null)
		compteurLeaf=compteurLeaf+1;
	}
	for (Iterator iterator = children.iterator(); iterator.hasNext();) {
		Node node = (Node) iterator.next();
		compteurLeaf=compteurLeaf+node.Cardinality1_Leaf();
	}
	
	return compteurLeaf;}

//*********** fonction retourne nbCardinality2 des noeuds intermédiaires******
public int Cardinality2_Inter()
{
int compteurInter=0;
	if (this.isLeaf()==false && this.isRoot()==false)
	
	{if (this.getType2()!=null)
		compteurInter=compteurInter+1;
	}
	for (Iterator iterator = children.iterator(); iterator.hasNext();) {
		Node node = (Node) iterator.next();
		compteurInter=compteurInter+node.Cardinality2_Inter();
	}
	
	return compteurInter;}
//***************************************************************************
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
}