package linkedlist;

public class ReverseLinkedList_E206E_I35E {
	/**
	 * Iteration.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode reverseList1(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode slow = dummy, fast = slow.next;
		while (fast != null && fast.next != null) {
			ListNode temp = fast.next.next;
			fast.next.next = slow.next;
			slow.next = fast.next;
			fast.next = temp;
		}
		
		return dummy.next;
	}
	
	/**
	 * Recursion.
	 * Time: O(n); Space: O(n)
	 */
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode restStart = head.next;
		head.next = null;
		ListNode restEnd = reverseList2(restStart);
		restStart.next = head;
		
		return restEnd;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> 5 -> NULL
		
		ReverseLinkedList_E206E_I35E obj = new ReverseLinkedList_E206E_I35E();
		ListNode.printLinkedList(obj.reverseList1(null));	// NULL
		ListNode.printLinkedList(obj.reverseList2(null));	// NULL
		
		ListNode.printLinkedList(obj.reverseList1(n1));	// 5 -> 4 -> 3 -> 2 -> 1 -> NULL
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;
		ListNode.printLinkedList(obj.reverseList2(n1));	// 5 -> 4 -> 3 -> 2 -> 1 -> NULL
	}
}

/**
 * LeetCode #206
 * LintCode #35
 * Reverse a singly linked list.
 * Hint: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
