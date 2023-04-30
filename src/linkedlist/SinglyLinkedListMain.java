package linkedlist;

public class SinglyLinkedListMain {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(0);
		list.add(1);
		list.addFirst(2);
		list.add(3, 3);
	
		list.add(2);
		list.printList();
		System.out.println(list.size());
		System.out.println(list.get(3));
		System.out.println(list.remove(3));
		list.printList();
//		System.out.println(list.indexOf(2));
		System.out.println(list.lastIndexOf(2));
		list.removeFirst();
		list.printList();
//		list.printList();
	}
}