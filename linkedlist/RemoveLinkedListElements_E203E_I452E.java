package linkedlist;

public class RemoveLinkedListElements_E203E_I452E {
	/**
	 * Use two pointers.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		// two pointers
		ListNode slow = dummy;
		ListNode fast = head;
		
		while (fast != null) {
			if (fast.val == val) {
				slow.next = slow.next.next;	// match, skip the node pointed by the fast pointer
			} else {
				slow = slow.next;	// not match, move forward the slow pointer
			}
			fast = fast.next;	// move forward the fast pointer
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(6);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
		ListNode n7 = new ListNode(6);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6 -> NULL
		
		RemoveLinkedListElements_E203E_I452E obj = new RemoveLinkedListElements_E203E_I452E();
		ListNode.printLinkedList(obj.removeElements(null, 6));	// NULL
		ListNode.printLinkedList(obj.removeElements(n1, 7));	// 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6 -> NULL
		
		ListNode.printLinkedList(obj.removeElements(n1, 6));	// 1 -> 2 -> 3 -> 4 -> 5 -> NULL
	}
}

/**
 * LeetCode #203
 * LintCode #452
 * Remove all elements from a linked list of integers that have value val.
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
