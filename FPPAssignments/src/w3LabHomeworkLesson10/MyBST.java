package w3LabHomeworkLesson10;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
// Demo code for the user implemenation of Binary search tree
public class MyBST {
	/** The tree root. */
	private BinaryNode root;

	public MyBST() {
		root = null;
	}
	
	/**
	* Prints the values in the nodes of the tree
	* in sorted order. Inorder Traversal
	*/
	public void printTree() {
		if( root == null )
			System.out.println( "Empty tree" );
		else
			printTree(root);
	}
	// Inorder Traversal to print the nodes in Ascending order
	private void printTree( BinaryNode t ){
		if( t != null ){
			printTree( t.left );
		    System.out.print(t.element+",");
		    printTree( t.right );
		} 
	}
		 
	//Preorder
	private void preOrder(BinaryNode t){
		if(t!=null)
		{
			System.out.print(t.element+" ");
			preOrder(t.left);
			preOrder(t.right);
		}
	}
	
	//Postorder
	private void postOrder(BinaryNode t){
		if(t!=null)
		{
			postOrder(t.left);
			postOrder(t.right);
			System.out.print(t.element+" ");	
		}
	}

	public boolean contains(int key){
		BinaryNode t = root;
		
		while(t!=null)
		{
			if(t.element == key)
				return true;
			if(key>t.element)
			{
				t = t.right;
			}
			else if(key<t.element)
			{
				t=t.left;
			}
		}
		return false;
		
	}
	
	
	public BinaryNode getRoot(){
		return root;
	}
	
	public int leafNodes(BinaryNode t){
		if(t==null)
			return 0;
		if(t.left==null && t.right==null)
			return 1;
		else
		{
			return leafNodes(t.left)+leafNodes(t.right);
		}
	}
	
	public int size(){
		return size(root);
	}
	
	public int size(BinaryNode t)
	{
		if(t==null)
			return 0;
		else
			return 1+size(t.left)+size(t.right);
	}
	
	public boolean isLeaf(){
		if(root!=null)
		{
			if(root.left==null && root.right==null)
				return true;
			else
				return false;
		}
		return false;
	} 
	
	
	//Assume the data in the Node is an Integer.	

	public void insert(Integer x) {
		if (root == null) {
			root = new BinaryNode(x);
			return;
		}
		else { 
			BinaryNode n = root;
			boolean inserted = false;

			while(!inserted)//true
				{
				if(x.compareTo(n.element)<0) {
					//space found on the left
					if(n.left == null){
						n.left = new BinaryNode(x,null,null);
						inserted = true;
					}
					//keep looking for a place to insert (a null)
					else {
						n = n.left;
					}
				}				
				else if(x.compareTo(n.element)>0){ 
					//space found on the right					
					if(n.right==null){
					n.right = new BinaryNode(x,null,null);
					inserted = true;
					}
						//keep looking for a place to insert (a null)
					else {
							n = n.right;
					}
										
				}
				// if a node already exists
				else {
					inserted = true;
				}

			}

		}
	}
	private class BinaryNode {

		private Integer element;// The data in the node
		private BinaryNode left;      // Left child
		private BinaryNode right;     // Right child	  
		// Constructors 
		
		BinaryNode( Integer theElement ){
			this( theElement, null, null );
		}	

		BinaryNode( Integer element, BinaryNode left, BinaryNode right ){
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
	}
		

	public static void main(String[] args) {
		
		MyBST mybst = new MyBST();
		
		int [] a = {15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25};
	
		for (int j = 0; j < a.length; j++ ) {
			mybst.insert(a[j]);
					
		}
		mybst.insert(12);
		mybst.printTree();
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		for (int j = 0; j < a.length; j++ ) {
			ts.add(a[j]);
			//System.out.println("\nAfter inserting " + j + "th item " + a[j]);
			Iterator<Integer> it = ts.iterator();		
			Integer nextItem = null;
			while(it.hasNext()) {
				nextItem = it.next();
			//	System.out.print(nextItem + " ");
			} 
		//	System.out.println();
		}
		
	/*	TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(8, "Hello");
		map.put(10, "World!");
		map.put(11, "Welcome");
		map.remove(8);
		String str = map.get(11)+", "+ map.get(10);
		System.out.println(str);
		*/
		System.out.println();
		System.out.println();
		System.out.println("Preorder Output:");
		mybst.preOrder(mybst.root);
		
		System.out.println();
		System.out.println();
		System.out.println("Postorder Output:");
		mybst.postOrder(mybst.root);
		
		System.out.println();
		System.out.println();
		System.out.println("Does tree contains 56? "+mybst.contains(56));
		System.out.println("Does tree contains 99? "+mybst.contains(99));
		
		System.out.println();
		System.out.println("The root element is "+mybst.getRoot().element);
		
		System.out.println();
		System.out.println("The number of leafnodes are: "+mybst.leafNodes(mybst.root));
		
		System.out.println();
		System.out.println("Size of tree is: "+mybst.size());
		
		System.out.println();
		System.out.println("Is tree leaf? "+mybst.isLeaf());
	}
}