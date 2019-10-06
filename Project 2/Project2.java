import java.util.Scanner;
import java.io.*;

public class Project2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		File inputfile = new File("Books.txt");
		Scanner input = new Scanner (inputfile);
		AVLTree tree = new AVLTree();
		Book[] books = new Book[5];
		
		for (int i = 0; i < books.length; i++) {
			books[i] = new Book (input.next(), input.next(), input.next());
			tree.add(books[i].ISBN, books[i]);
		}	
		
		System.out.println(tree.root.leftPtr.toString());
		
	}
}
