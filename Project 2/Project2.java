import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Project2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		File inputfile = new File("Books.txt");
		Scanner input = new Scanner (inputfile);
		AVLTree tree = new AVLTree();
		Book[] books = new Book[11];
		
		Random seed = new Random(); //Needed for Part 2
		BinaryTree bst = new BinaryTree();
		int num = 0;
		
		//Part 1
		for (int i = 0; i < books.length; i++) {
			books[i] = new Book (input.next(), input.next(), input.next());
			tree.add(books[i].ISBN, books[i]);
		}
		
		//System.out.println(new File(".").getAbsolutePath());
		System.out.println("\nPrinting AVL tree 'pre-order' (root-left-right)");
		tree.toString(tree.root);
		input.close();
		
		//Part 2
		num = seed.nextInt(25) + 1;
		
		for ( int i = 0; i < num; i++ ) {
			bst.add(seed.nextInt(100));
		}
		
		System.out.println("\nPrinting binary tree 'in order' (left-root-right)");
		bst.displayBT(bst.root);
	}
}
