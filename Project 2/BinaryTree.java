import java.util.Random;

public class BinaryTree {

	public BinaryNode root;
	
	BinaryTree () { root = null; }
	
	public void add( int key ) { 
		System.out.println("Adding node: " + key);
		root = addNodetoTree (root, key); //this function starts at the root and goes down the tree
	}
	
	public BinaryNode addNodetoTree (BinaryNode node, int key) {
		if ( node == null ) { //if node doesn't exist yet, create it
			node = new BinaryNode(key);
			return node;
		}
		
		//The following lines randomly determine if the node is inserted to the left or right
		Random seed = new Random();
		int direction = seed.nextInt(2);
		if ( direction == 1 )
			node.leftPtr = addNodetoTree(node.leftPtr, key);
		else
			node.rightPtr = addNodetoTree(node.rightPtr, key);
		
		//These two calculate the height and balance of the node, and account for additional nodes
		node.height = 1 + max(calcheight(node.leftPtr),calcheight(node.rightPtr));
		node.balance = calcbalance(node);
		
		/*if ( node.balance > 1 && key < node.leftPtr.key) {
			System.out.println("Imbalance detected at node: " + node.key);
		}
		if ( node.balance > 1 && key > node.leftPtr.key) {
			System.out.println("Imbalance detected at node: " + node.key);
		}
		if ( node.balance < -1 && key > node.rightPtr.key) {
			System.out.println("Imbalance detected at node: " + node.key);
		}
		if ( node.balance < -1 && key < node.rightPtr.key) {
			System.out.println("Imbalance detected at node: " + node.key);
		}*/
		if ( node.balance > 1 || node.balance < -1 )
			System.out.println("Imbalance detected at node: " + node.key);
		
		
		return node;
	}
	
	public int calcheight (BinaryNode node) {
    	if ( node == null)
    		return -1;
    	else
    		return node.height;
    }
    
    public int max (int height1, int height2) {
    	if ( height1 > height2 )
    		return height1;
    	else
    		return height2;
    }
    
    public int calcbalance (BinaryNode node) {
    	if (node == null)
    		return 0;
    	else {
    		return (calcheight(node.leftPtr) - calcheight(node.rightPtr));
    	}
    }
    
    public void displayBT(BinaryNode node) {
		if (node != null) {
			displayBT(node.leftPtr);
			System.out.println("Key: " + node.key + "  Height: " + calcheight(node) + "  Balance: " + calcbalance(node));
			checkifBST(node);
			checkAVLfinal(node);
			displayBT(node.rightPtr);
		}
	}
    
    public void checkifBST(BinaryNode node) {
    	if (node != null) {
    		if (node.leftPtr != null && node.key < node.leftPtr.key)
    			System.out.println("Node " + node.key + " fails BST check");
    		if (node.rightPtr != null && node.key > node.rightPtr.key)
    			System.out.println("Node " + node.key + " fails BST check");
    	}
    }
    
    public void checkAVLfinal(BinaryNode node) {
    	if (node != null) {
    		if (node.balance > 1 || node.balance < -1)
    			System.out.println("Node " + node.key + " fails AVL check");
    	}
    }
}
