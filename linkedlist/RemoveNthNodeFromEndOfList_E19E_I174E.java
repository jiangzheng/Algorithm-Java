package linkedlist;

public class RemoveNthNodeFromEndOfList_E19E_I174E {
	/**
	 * Use two pointers.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return null;	// invalid input
		}
		
		ListNode p = head;
		int size = 0;
		while (p != null) {
			p = p.next;
			size++;
		}
		
		if (n > size) {
			return null;	// invalid input
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;	// two pointers - slow and fast - both start from dummy
		
		while (fast.next != null) {
			if (n > 0) {
				n--;	// don't move slow until gap is 0, so that eventually the gap b/w slow and fast is n
			} else {
				slow = slow.next;	// move slow forward
			}
			fast = fast.next;	// move fast forward
		}
		
		slow.next = slow.next.next;	// skip the node right after slow
		
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
		
		RemoveNthNodeFromEndOfList_E19E_I174E obj = new RemoveNthNodeFromEndOfList_E19E_I174E();
		ListNode.printLinkedList(obj.removeNthFromEnd(null, 2));	// NULL
		ListNode.printLinkedList(obj.removeNthFromEnd(n1, 0));	// NULL
		ListNode.printLinkedList(obj.removeNthFromEnd(n1, 6));	// NULL
		
		ListNode.printLinkedList(obj.removeNthFromEnd(n1, 2));	// 1 -> 2 -> 3 -> 5 -> NULL
	}
}

/**
 * LeetCode #19
 * LintCode #174
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *   Given linked list: 1->2->3->4->5, and n = 2.
 *   After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note: Given n will always be valid. Try to do this in one pass.
 */
