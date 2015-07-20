package chapter1.section1;

public class ReverseLinkList {
	public static void main(String[] args) {
		LinkList list = new LinkList();
		for (int i = 0; i < 10; i++) {
			list.add(new Node(i + 1));
		}
		list.print();
		ReverseLinkList rl = new ReverseLinkList();
		System.out.println();
		rl.reverseLinkList(list, 4);
		list.print();
	}

	public void reverseLinkList(LinkList list, int k) {
		int n = list.length;
		k %= n;
		Node itr = list.head;
		while (k > 1) {
			itr = itr.next;
			k--;
		}

		list.tail.next = list.head;
		list.head.prev = list.tail;
		list.head = itr;

		while (n > 0) {
			Node prev = itr.prev;
			itr.prev = itr.next;
			itr.next = prev;
			itr = itr.next;
			n--;
		}
		list.tail = itr.prev;
		list.head.prev = null;
		list.tail.next = null;
	}
}
