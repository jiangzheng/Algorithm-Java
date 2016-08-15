package linkedlist;

public class LinkedListCycle_E141M_I102M {
	/**
	 * Use two pointers.
	 * Time: O(n); Space: O(1)
	 */
	public boolean hasCycle(ListNode head) {
		ListNode slow = head, fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;		// slow pointer move 1 step each time
			fast = fast.next.next;	// fast pointer move 2 step each time
			if (slow == fast) {		// there is a cycle if they meet
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> 5 -> NULL
		
		LinkedListCycle_E141M_I102M obj = new LinkedListCycle_E141M_I102M();
		System.out.println(obj.hasCycle(n1));	// false
		
		n4.next = n2;
		System.out.println(obj.hasCycle(n1));	// true
	}
}

/**
 * LeetCode #141
 * LintCode #102
 * Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 */
