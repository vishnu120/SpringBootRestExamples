package binarySearchTree;

public class BinarySearhTree {
	Node root;

	public BinarySearhTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	
	// function to create new nodes
	public void insertNode(int data) {
		this.root = this.insertRec(this.root ,  data);
	}
	/* A utility function to insert a new node with given
    key in BST */

	public Node insertRec(Node node,int data) {
		// TODO Auto-generated method stub
		if(node == null) {
			 /* If the tree is empty, return a new node */
			this.root = new Node(data);
			return this.root;
		}
		 /* Otherwise, recur down the tree */
		if(data < node.data) {
			node.left = this.insertRec(node.left, data);
		}
		else {
			node.right = this.insertRec(node.right, data);
		}
		return null;
	}
	 void secondLargestUtil(Node node, count C)
	    {  
	        // Base cases, the second condition is important to
	        // avoid unnecessary recursive calls
	        if (node == null || C.c >= 2)
	            return;
	             
	        // Follow reverse inorder traversal so that the
	        // largest element is visited first
	        this.secondLargestUtil(node.right, C);
	         
	         // Increment count of visited nodes
	        C.c++;
	         
	        // If c becomes k now, then this is the 2nd largest
	        if (C.c == 2) {
	            System.out.print("2nd largest element is "+
	                                              node.data);
	            return;
	        }
	         
	         // Recur for left subtree
	        this.secondLargestUtil(node.left, C);
	    }
	 
	    // Function to find 2nd largest element
	    void secondLargest(Node node)
	    {  
	        // object of class count
	        count C = new count();
	        this.secondLargestUtil(this.root, C);
	    }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearhTree tree = new BinarySearhTree();
		tree.insertNode(50);
        tree.insertNode(30);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(70);
        tree.insertNode(60);
        tree.insertNode(80);
 
        tree.secondLargest(tree.root);

	}

}
// class that stores the value of count
 class count {
    int c = 0;
}
