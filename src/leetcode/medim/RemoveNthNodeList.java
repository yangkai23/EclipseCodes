package leetcode.medim;

public class RemoveNthNodeList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		static int length;
		{
			length++;
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

	}

	public ListNode removeNthFromEnd(RemoveNthNodeList.ListNode head, int n) {

		if (head == null)
			return head;
		if (head.next == null && n == 1) {
			head = null;
			return head;
		}
		if (RemoveNthNodeList.ListNode.length - n == 0) {
			head = head.next;
			return head;
		}
		ListNode temp = head.next;
		ListNode prevTemp = head;
		int removePosition = 1;
		System.out.println(RemoveNthNodeList.ListNode.length - n + 1);
		while (temp.next != null && removePosition < (RemoveNthNodeList.ListNode.length - n)) {
			prevTemp = temp;
			temp = temp.next;
			removePosition++; //
			System.out.println(removePosition);
		}
		if (temp.next != null) {
			prevTemp.next = temp.next;
		} else {
			prevTemp.next = null;
			temp = prevTemp;
		}
		return head;

		// 0ms solution
		/*
		 * ListNode slow = head; ListNode fast = head; for (int i = 0; i < n; i++) {
		 * fast = fast.next; } if (fast == null) { return head.next; } while (fast.next
		 * != null) { slow = slow.next; fast = fast.next; } slow.next = slow.next.next;
		 * return head;
		 */
	}

	public static void printList(ListNode head) {
		StringBuilder builder = new StringBuilder();
		ListNode temp = head;
		builder.append("[ ");
		while (temp != null) {
			builder.append(temp.val);
			if (temp.next != null)
				builder.append(" -> ");
			temp = temp.next;
		}
		builder.append(" ]");
		System.out.println(builder);
	}

	public static void main(String[] args) {
		ListNode listNode1 = new RemoveNthNodeList.ListNode(1);
		ListNode listNode2 = new RemoveNthNodeList.ListNode(2);
		ListNode listNode3 = new RemoveNthNodeList.ListNode(3);
		ListNode listNode4 = new RemoveNthNodeList.ListNode(4);
		ListNode listNode5 = new RemoveNthNodeList.ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		ListNode head = listNode1;
		printList(head);
//		System.out.println(RemoveNthNodeList.ListNode.length);
		RemoveNthNodeList removeNthNodeList = new RemoveNthNodeList();
		ListNode resultList = removeNthNodeList.removeNthFromEnd(head, 3);
		printList(resultList);
	}
}
