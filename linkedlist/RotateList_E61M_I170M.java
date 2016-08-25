package linkedlist;

public class RotateList_E61M_I170M {
	/**
	 * Use two pointers.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k <= 0) {
			return head;	// invalid input or shortcut
		}
		
		ListNode slow = head, fast = head;	// 2 pointers
		int length = 0;
		while (fast != null) {
			length++;
			fast = fast.next;
		}
		k %= length;	// if k > n, don't have to move more than n times
		if (k == 0) {
			return head;
		}
		
		fast = head;
		while (fast.next != null) {	// find the kth node from end of list
			if (k > 0) {
				k--;	// don't move slow until k = 0, so that eventually the gap b/w slow and fast is k
			} else {
				slow = slow.next;	// move slow forward
			}
			fast = fast.next;	// move fast forward
		}
		
		fast.next = head;	// connect the last node to the first node
		head = slow.next;	// set new head (4)
		slow.next = null;	// cut the connection (b/w 3 and 4)
		
		return head;	// return new head (4)
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> 5 -> NULL
		
		RotateList_E61M_I170M obj = new RotateList_E61M_I170M();
		ListNode.printLinkedList(obj.rotateRight(null, 2));	// NULL
		ListNode.printLinkedList(obj.rotateRight(n1, -1));	// 1 -> 2 -> 3 -> 4 -> 5 -> NULL
		ListNode.printLinkedList(obj.rotateRight(n1, 0));	// 1 -> 2 -> 3 -> 4 -> 5 -> NULL
		
		ListNode.printLinkedList(obj.rotateRight(n1, 2));	// 4 -> 5 -> 1 -> 2 -> 3 -> NULL
		
		ListNode.printLinkedList(obj.rotateRight(n4, 2000001));	// 3 -> 4 -> 5 -> 1 -> 2 -> NULL
	}
}

/**
 * LeetCode #61
 * LintCode #170
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 */
