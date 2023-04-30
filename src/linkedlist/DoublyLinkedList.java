package linkedlist;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;// by default it's 0 , no need to initialize explicitly
	}

	private class Node {
		private int data;
		private Node next;
		private Node previous;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	public void addFirst(int data) {
		Node node = new Node(data);
		if (head == null && size == 0) {
			this.head = this.tail = node;
			size++;
			return;
		}
		node.next = this.head;
		this.head.previous = node;
		this.head = node;
		size++;
	}

	public void add(int data) {
		Node node = new Node(data);
		if (isEmpty()) {
			this.head = this.tail = node;
			size++;
			return;
		}

		this.tail.next = node;
		node.previous = this.tail;
		this.tail = node;
		size++;
	}

	public void add(int data, int position) {
		if (position > this.size) {
			System.out.println("Index out of bound");
			return;
		}
		Node node = new Node(data);
		if (position == 0 && this.head == null && this.tail == null) {
			this.head = this.tail = node;
			size++;
			return;
		}
		Node temp = this.head;
		while (temp != null && position > 0) {
			temp = temp.next;
			position--;
		}
		node.previous = temp.previous;
		temp.previous.next = node;
		node.next = temp;
		temp.previous = node;
		size++;
	}

	public int removeFirst() {
		if (isEmpty()) {
			System.err.println("Empty List");
			return -1;
		}
		Node temp = this.head;
		this.head = this.head.next;
		this.head.previous = null;
		return temp.data;
	}

	public int remove(int index) {
		if (this.isEmpty()) {
			System.err.println("Empty List");
			return -1;
		}
		Node temp = this.head;
		if (size == 1) {
			this.head = this.tail = null;
			return temp.data;
		}
		while (index > 0 && temp != null) {
			temp = temp.next;
			index--;
		}
		temp.previous.next = temp.next;
		if (temp.next != null) {
			temp.next.previous = temp.previous;
		}
		temp.previous = temp.next = null;
		return temp.data;
	}

	public void addAll(DoublyLinkedList list) {
		if (this.head == null) {
			this.head = list.head;
			this.tail = list.tail;
			return;
		}
		this.tail.next = list.head;
		list.head.previous = this.tail;
		this.tail = list.tail;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void printList() {
		System.out.println();
		Node temp = this.head;
		System.out.print("Head->");
		while (temp != null) {
			System.out.print(temp.data + " <=>");
			temp = temp.next;
		}
		System.out.print("<-Tail <=> null");
	}

	public void printReverse() {
		System.out.println();
		Node temp = this.tail;
		System.out.print("Tail->");
		while (temp != null) {
			System.out.print(temp.data + " <=> ");
			temp = temp.previous;
		}
		System.out.print("<-Head <=> null");
	}
}
