package linkedlist;

public class DoublyLinkedListMain {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addFirst(0);
		list.add(2);
		list.add(5);
		list.addFirst(3);
		list.add(6, 2);
		list.printList();
		list.printReverse();
//		list.removeFirst();
		list.remove(2);
		list.printList();
		list.printReverse();
	}
}
