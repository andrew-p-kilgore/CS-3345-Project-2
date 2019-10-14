
public class BinaryNode {

	public int key;
	public int height;
	public int balance;
	public BinaryNode leftPtr;
	public BinaryNode rightPtr;
	
	BinaryNode ( int key ) {
		this.key = key;
		height = 0;
		balance = 0;
		leftPtr = null;
		rightPtr = null;
	}
	
	
}
