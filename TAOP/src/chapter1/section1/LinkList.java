package chapter1.section1;

public class LinkList {
	public Node head;
	public Node tail;
	public int length;

	public LinkList() {
		head = null;
		tail = null;
		length = 0;
	}

	/**
	 * 往表尾部添加一个节点
	 * 
	 * @param node
	 */
	public void add(Node node) {
		if (null == head) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		length++;
	}

	public void print() {
		Node itr = head;
		while (itr.next != null) {
			System.out.print(itr.data + "->");
			itr = itr.next;
		}
		System.out.print(itr.data);
	}
}
