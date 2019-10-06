public class AVLTree {

	public AVLNode root;
	public Boolean imbalanced;
	
	AVLTree () { root = null; }
	
	public void add(String isbn, Book book) { 
		root = addBooktoTree (root, isbn, book);
	}
	
	public AVLNode addBooktoTree (AVLNode node, String isbn, Book book) {
		if ( node == null ) { //if node doesn't exist yet, create it
			node = new AVLNode(isbn, book);
			//root.height++;
			return node;
		}
		
		if ( isbn.compareTo(node.key) < 0 ) {
			node.height++;
			addBooktoTree(node.leftPtr, isbn, book);
		}
		else if ( isbn.compareTo(node.key) > 0 )
			addBooktoTree(node.rightPtr, isbn, book);
		return node;
	}
	
	void inorder()  { 
	       inorderRec(root); 
	    } 
	  
	    // A utility function to do inorder traversal of BST 
	    void inorderRec(AVLNode root) { 
	        if (root != null) { 
	            inorderRec(root.leftPtr); 
	            System.out.println(root.key); 
	            inorderRec(root.rightPtr); 
	        } 
	    } 
}