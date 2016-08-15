package linkedlist;

public class SwapNodesInPairs_E24M_I451E {
	/**
	 * Use two adjacent pointers.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode slow = dummy, fast = slow.next;	// two adjacent pointers
		while (fast != null && fast.next != null) {	// until fast == null (even elements) or fast.next == null (odd elements)
			ListNode temp = fast.next.next;
			fast.next.next = slow.next;
			slow.next = fast.next; 
			fast.next = temp;
			
			slow = fast;
			fast = fast.next;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2; n2.next = n3; n3.next = n4;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> NULL
		
		SwapNodesInPairs_E24M_I451E obj = new SwapNodesInPairs_E24M_I451E();
		ListNode.printLinkedList(obj.swapPairs(null));	// NULL
		
		ListNode.printLinkedList(obj.swapPairs(n1));	// 2 -> 1 -> 4 -> 3 -> NULL
		ListNode.printLinkedList(obj.swapPairs(n1));	// 4 -> 1 -> 3 -> NULL
		ListNode.printLinkedList(obj.swapPairs(n1));	// 3 -> 1 -> NULL
		ListNode.printLinkedList(obj.swapPairs(n1));	// 1 -> NULL
	}
}

/**
 * LeetCode #24
 * LintCode #451
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 */
