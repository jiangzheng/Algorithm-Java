package linkedlist;

public class ReverseLinkedListII_E92M_I36M {
	/**
	 * Use two pointers.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = slow.next;	// 2 pointers
		int position = 1;

		while (position < m && fast != null) {	// move slow to m-1th node, fast to the mth node, final position = m
			slow = fast;
			fast = fast.next;
			position++;
		}
		
		while (position < n && fast != null) {	// reverse between m and n, final position = n
			ListNode temp = fast.next.next;
			fast.next.next = slow.next;
			slow.next = fast.next;
			fast.next = temp;
			position++;
		}
		
		return dummy.next;
	}
		
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> 5 -> NULL

		ReverseLinkedListII_E92M_I36M obj = new ReverseLinkedListII_E92M_I36M();
		ListNode.printLinkedList(obj.reverseBetween(null, 2, 4));	// NULL
		ListNode.printLinkedList(obj.reverseBetween(null, 0, 4));	// NULL
		ListNode.printLinkedList(obj.reverseBetween(null, 2, 6));	// NULL
		
		ListNode.printLinkedList(obj.reverseBetween(n1, 2, 4));	// 1 -> 4 -> 3 -> 2 -> 5 -> NULL
	}
}

/**
 * LeetCode #92
 * LintCode #36
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 * Note: Given m, n satisfy the following condition: 1 <= m <= n <= length of list.
 */
