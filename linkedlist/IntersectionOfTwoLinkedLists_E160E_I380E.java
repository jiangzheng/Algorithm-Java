package linkedlist;

public class IntersectionOfTwoLinkedLists_E160E_I380E {
	/**
	 * Two pointers.
	 * Time: O(n), Space: O(1)
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode pointer1 = headA, pointer2 = headB;	// two pointers
		int length1 = 0, length2 = 0;	// lengths of the two lists
		
		// Find the length of list A
		while (pointer1 != null) {
			length1++;
			pointer1 = pointer1.next;
		}
		
		// Find the length of list B
		while (pointer2 != null) {
			length2++;
			pointer2 = pointer2.next;
		}
		
		// reset pointers for the two lists
		pointer1 = headA;
		pointer2 = headB;
		for (int i = 0; i < Math.abs(length1 - length2); i++) {	// first go forward length-diff nodes in longer list 
			if (length1 < length2)
				pointer2 = pointer2.next;	// if list B is longer
			else
				pointer1 = pointer1.next;	// if list A is longer
		}
		
		while (pointer1 != pointer2) {	// go forward in both lists until find same node
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		
		return pointer1;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(11);
		ListNode n2 = new ListNode(12);
		ListNode n3 = new ListNode(21);
		ListNode n4 = new ListNode(22);
		ListNode n5 = new ListNode(23);
		ListNode n6 = new ListNode(31);
		ListNode n7 = new ListNode(32);
		ListNode n8 = new ListNode(33);
		n1.next = n2; n2.next = n6; 
		n3.next = n4; n4.next = n5; n5.next = n6;
		n6.next = n7; n7.next = n8;
		ListNode.printLinkedList(n1);	// 11 -> 12 -> 31 -> 32 -> 33 -> NULL
		ListNode.printLinkedList(n3);	// 21 -> 22 -> 23 -> 31 -> 32 -> 33 -> NULL
		
		IntersectionOfTwoLinkedLists_E160E_I380E obj = new IntersectionOfTwoLinkedLists_E160E_I380E();
		ListNode.printLinkedList(obj.getIntersectionNode(null, null));	// NULL
		ListNode.printLinkedList(obj.getIntersectionNode(null, n3));	// NULL
		ListNode.printLinkedList(obj.getIntersectionNode(n1, null));	// NULL
		
		ListNode.printLinkedList(obj.getIntersectionNode(n1, n3));	// 31 -> 32 -> 33 -> NULL
	}
}

/**
 * LeetCode #160
 * LintCode #380
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:       a1 -> a2
 *                 \
 *                  c1-> c2 -> c3
 *                 /			
 * B: b1 -> b2 -> b3
 * begin to intersect at node c1.
 * Notes:
 * - If the two linked lists have no intersection at all, return null.
 * - The linked lists must retain their original structure after the function returns.
 * - You may assume there are no cycles anywhere in the entire linked structure.
 * - Your code should preferably run in O(n) time and use only O(1) memory.
 */
