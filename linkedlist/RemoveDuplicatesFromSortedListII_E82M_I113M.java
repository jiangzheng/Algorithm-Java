package linkedlist;

public class RemoveDuplicatesFromSortedListII_E82M_I113M {
	/**
	 * Use two pointers.
	 * Use slow as the node pointing to the first duplicate node.
	 * If fast.val == fast.next.val, move fast forward until a distinct node appears (fast is the last duplicate node), 
	 *   and skip all these duplicates by slow.next = fast.next;
	 * If fast.val != fast.next.val, move slow and fast forward.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy.next;	// 2 pointers
		
		while (fast != null && fast.next != null) {
			if (fast.val != fast.next.val) {	// no duplicate, move slow to fast
				slow = fast;
			} else {	// skip duplicates by moving fast to the last duplicated element and link slow to fast.next
				while (fast.next != null && fast.val == fast.next.val) {
					fast = fast.next;
				}
				slow.next = fast.next;
			}
			fast = fast.next;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 -> NULL
		
		RemoveDuplicatesFromSortedListII_E82M_I113M obj = new RemoveDuplicatesFromSortedListII_E82M_I113M();
		ListNode.printLinkedList(obj.deleteDuplicates(null));	// NULL
		
		ListNode.printLinkedList(obj.deleteDuplicates(n1));	// 1 -> 2 -> 5 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n2));	// 2 -> 5 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n3));	// 5 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n4));	// 3 -> 5 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n5));	// 5 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n6));	// 4 -> 5 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n7));	// 5 -> NULL
		
		n1 = new ListNode(1);
		n2 = new ListNode(1);
		n3 = new ListNode(1);
		n4 = new ListNode(2);
		n5 = new ListNode(3);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;
		ListNode.printLinkedList(n1);	// 1 -> 1 -> 1 -> 2 -> 3 -> NULL
		
		ListNode.printLinkedList(obj.deleteDuplicates(n1));	// 2 -> 3 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n2));	// 2 -> 3 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n3));	// 1 -> 2 -> 3 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n4));	// 2 -> 3 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n5));	// 3 -> NULL
	}
}

/**
 * LeetCode #82
 * LintCode #113
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 *   leaving only distinct numbers from the original list.
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.
 */
