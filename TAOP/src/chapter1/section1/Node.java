package chapter1.section1;

public class Node {
	public Node next;
	public Node prev;
	public int data;
	
	public Node(int data){
		this.prev=null;
		this.next=null;
		this.data=data;
	}
}
