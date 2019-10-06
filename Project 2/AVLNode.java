public class AVLNode {

	public String key;
	public Book value;
	public int height;
	public int balance;
	public AVLNode leftPtr;
	public AVLNode rightPtr;
	
	AVLNode (String isbn, Book book) {
	key = isbn;
	value = new Book (book.ISBN, book.Title, book.AuthorLastName);
	height = 0;
	leftPtr = null;
	rightPtr = null;
	}
	
	public String toString() {
		return key + " " + value.Title + " " + value.AuthorLastName;
	}
	
}
