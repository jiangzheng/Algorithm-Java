package linkedlist;

/**
 * The ListNode class and linked list utilities for LeetCode/LintCode code.
 */
public class ListNode {
	int val;
	ListNode next;
	
	public ListNode(int x) {
		this.val = x;
	}
	
	/**
	 * Print a linked list.
	 */
	public static void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("NULL");
	}
	
	public static void main(String[] args) {
		ListNode.printLinkedList(null);	// NULL
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
	}
}
