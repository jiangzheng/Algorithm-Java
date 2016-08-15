package linkedlist;

public class AddTwoNumbers_E2M_I167E {
	/**
	 * Time: O(n1 + n2); Space: O(n1 + n2)
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);	// new head for the result linked list
		ListNode pointer = dummy;
		int carry = 0;

		while (l1 != null || l2 != null) {	// stop when reaching the ends of both lists
			int digit = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;	// add up
			pointer.next = new ListNode(digit % 10);	// add a new node for this place
			carry = digit / 10;
			if (l1 != null) {
				l1 = l1.next;	// move forward in the l1 list
			}
			if (l2 != null) {
				l2 = l2.next;	// move forward in the l2 list
			}
			pointer = pointer.next;	// move forward in the result list
		}

		if (carry > 0) {	// if there is a carry in the highest place
			pointer.next = new ListNode(carry);	// add a new place
		}
		
		return dummy.next;	
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(4);
		n1.next = n2; n2.next = n3;
		n4.next = n5; n5.next = n6;
		ListNode.printLinkedList(n1);	// 2 -> 4 -> 3 -> NULL
		ListNode.printLinkedList(n4);	// 5 -> 6 -> 4 -> NULL
		
		AddTwoNumbers_E2M_I167E obj = new AddTwoNumbers_E2M_I167E();
		ListNode.printLinkedList(obj.addTwoNumbers(null, null));	// NULL
		ListNode.printLinkedList(obj.addTwoNumbers(null, n4));	// 5 -> 6 -> 4 -> NULL
		ListNode.printLinkedList(obj.addTwoNumbers(n1, null));	// 2 -> 4 -> 3 -> NULL
		
		ListNode.printLinkedList(obj.addTwoNumbers(n1, n4));	// 7 -> 0 -> 8 -> NULL
	}
}

/**
 * LeetCode #2
 * LintCode #167
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
