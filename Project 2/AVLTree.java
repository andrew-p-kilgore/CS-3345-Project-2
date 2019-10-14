public class AVLTree {

	public AVLNode root;
	public Boolean imbalanced = false;
	
	AVLTree () { root = null; }
	
	public void add(String isbn, Book book) { 
		System.out.println("Adding book ISBN " + isbn);
		root = addBooktoTree (root, isbn, book); //this function starts at the root and goes down the tree
	}
	
	public AVLNode addBooktoTree (AVLNode node, String key, Book book) {
		if ( node == null ) { //if node doesn't exist yet, create it
			node = new AVLNode(key, book);
			return node;
		}
		
		if ( key.compareTo(node.key) < 0 ) {
			node.leftPtr = addBooktoTree(node.leftPtr, key, book);
		}
		else if ( key.compareTo(node.key) > 0 ) {
			node.rightPtr = addBooktoTree(node.rightPtr, key, book);
		}
		else
			return node;
		
		node.height = 1 + max(calcheight(node.leftPtr),calcheight(node.rightPtr));
		
		node.balance = calcbalance(node);
		
		if ( node.balance > 1 && key.compareTo(node.leftPtr.key) < 0) {
			System.out.println("Imbalance detected at ISBN " + node.key + "."
					+ " Fixed in LeftLeft Rotation");
			return rightRotate(node);
		}
		if ( node.balance > 1 && key.compareTo(node.leftPtr.key) > 0) {
			node.leftPtr = leftRotate(node.leftPtr);
			System.out.println("Imbalance detected at ISBN " + node.key + "."
					+ " Fixed in LeftRight Rotation");
			return rightRotate(node);
		}
		if ( node.balance < -1 && key.compareTo(node.rightPtr.key) > 0) {
			System.out.println("Imbalance detected at ISBN " + node.key + "."
					+ " Fixed in RightRight Rotation");
			return leftRotate(node);
		}
		if ( node.balance < -1 && key.compareTo(node.rightPtr.key) < 0) {
			node.rightPtr = rightRotate(node.rightPtr);
			System.out.println("Imbalance detected at ISBN " + node.key + "."
					+ " Fixed in RightLeft Rotation");
			return leftRotate(node);
		}
		
		return node;
	}
	
	public void toString(AVLNode node) {
		if (node != null) {
			System.out.print(node.toString());
			toString(node.leftPtr);
			toString(node.rightPtr);
		}
	}
    
    public int calcheight (AVLNode node) {
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
    
    public int calcbalance (AVLNode node) {
    	if (node == null)
    		return 0;
    	else {
    		return (calcheight(node.leftPtr) - calcheight(node.rightPtr));
    	}
    }
    
    public AVLNode leftRotate(AVLNode node) {
    	AVLNode rightchild = node.rightPtr;
    	AVLNode leftgrandchild = rightchild.leftPtr;
    	rightchild.leftPtr = node;
    	node.rightPtr = leftgrandchild;
    	node.height = 1 + max( calcheight(node.leftPtr), calcheight(node.rightPtr));
    	rightchild.height = 1 + max( calcheight(rightchild.leftPtr), calcheight(rightchild.rightPtr));
    	node.balance = calcbalance(node);
    	return rightchild;
    }
    
    public AVLNode rightRotate(AVLNode node) {
    	AVLNode leftchild = node.leftPtr;
    	AVLNode rightgrandchild = leftchild.rightPtr;
    	leftchild.rightPtr = node;
    	node.leftPtr = rightgrandchild;
    	node.height = 1 + max( calcheight(node.leftPtr), calcheight(node.rightPtr));
    	leftchild.height = 1 + max( calcheight(leftchild.leftPtr), calcheight(leftchild.rightPtr));
    	node.balance = calcbalance(node);
    	return leftchild;
    }
}