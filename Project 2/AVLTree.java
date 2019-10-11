public class AVLTree {

	public AVLNode root;
	public Boolean imbalanced = false;
	
	AVLTree () { root = null; }
	
	public void add(String isbn, Book book) { 
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
		
		node.height = 1 + max(calcheight(node.leftPtr),calcheight(node.rightPtr));
		
		node.balance = calcbalance(node);
		
		return node;
	}
	
	public void inorder()  { 
	       inorderRec(root); 
	    } 
	  
    // A utility function to do inorder traversal of BST 
    public void inorderRec(AVLNode node) { 
        if (node != null) { 
            inorderRec(node.leftPtr); 
            System.out.println(node.toString()); 
            inorderRec(node.rightPtr); 
        } 
    }
    
    public int calcheight (AVLNode node) {
    	if ( node == null)
    		return 0;
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
}