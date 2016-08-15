package linkedlist;

public class MergeTwoSortedLists_E21E_I165E {
	/**
	 * Time: O(n1 + n2); Space: O(1)
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1, p2 = l2;	// two "pointers"
		ListNode dummyHead = new ListNode(0);	// dummy node, followed by the result sorted list
		ListNode pointer = dummyHead;		// the "pointer" to the dummy node
		
		while (p1 != null && p2 != null) {	// stop if reaching the end of either list
			if (p1.val < p2.val) {
				pointer.next = p1;
				p1 = p1.next;
			} else {
				pointer.next = p2;
				p2 = p2.next;
			}
			pointer = pointer.next;
		}
		
		if (p1 != null) {
			pointer.next = p1;	// attach the remaining 1st linked list
		}
		
		if (p2 != null) {
			pointer.next = p2;	// attach the remaining 2nd linked list
		}
		
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(8);
		ListNode n4 = new ListNode(11);
		ListNode n5 = new ListNode(15);
		ListNode n6 = new ListNode(2);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(18);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		n6.next = n7; n7.next = n8;
		ListNode.printLinkedList(n1);	// 1 -> 3 -> 8 -> 11 -> 15 -> NULL
		ListNode.printLinkedList(n6);	// 2 -> 7 -> 18 -> NULL
		
		MergeTwoSortedLists_E21E_I165E obj = new MergeTwoSortedLists_E21E_I165E();
		ListNode.printLinkedList(obj.mergeTwoLists(null, null));	// NULL
		ListNode.printLinkedList(obj.mergeTwoLists(n1, null));	// 1 -> 3 -> 8 -> 11 -> 15 -> NULL
		ListNode.printLinkedList(obj.mergeTwoLists(null, n6));	// 2 -> 7 -> 18 -> NULL
		
		ListNode.printLinkedList(obj.mergeTwoLists(n1, n6));	// 1 -> 2 -> 3 -> 7 -> 8 -> 11 -> 15 -> 18 -> NULL
	}
}

/**
 * LeetCode #21
 * LintCode #165
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 */
