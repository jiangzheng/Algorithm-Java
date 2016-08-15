package linkedlist;

public class RemoveDuplicatesFromSortedList_E83E_I112E {
	/**
	 * Use one pointer.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode pointer = head;
		
		while (pointer != null && pointer.next != null) {
			if (pointer.val == pointer.next.val) {
				pointer.next = pointer.next.next;	// If duplicated, skip the duplicated pointer.next
			} else {
				pointer = pointer.next;	// If not duplicated, move pointer forward
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode.printLinkedList(n1);	// 1 -> 1 -> 2 -> 3 -> 3 -> NULL
		
		RemoveDuplicatesFromSortedList_E83E_I112E obj = new RemoveDuplicatesFromSortedList_E83E_I112E();
		ListNode.printLinkedList(obj.deleteDuplicates(null));	// NULL
		
		ListNode.printLinkedList(obj.deleteDuplicates(n1));	// 1 -> 2 -> 3 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n2));	// 1 -> 2 -> 3 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n3));	// 2 -> 3 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n4));	// 3 -> NULL
		ListNode.printLinkedList(obj.deleteDuplicates(n5));	// 3 -> NULL
	}
}

/**
 * LeetCode #83
 * LintCode #112
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
