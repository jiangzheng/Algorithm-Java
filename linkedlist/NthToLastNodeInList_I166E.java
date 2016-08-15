package linkedlist;

public class NthToLastNodeInList_I166E {
	/**
	 * Use two pointers.
	 * Time: O(n); Space: O(1)
	 */
	ListNode nthToLast(ListNode head, int n) {
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
		
		ListNode slow = head, fast = head;
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4;
		ListNode.printLinkedList(n1);	// 3 -> 2 -> 1 -> 5 -> NULL
		
		NthToLastNodeInList_I166E obj = new NthToLastNodeInList_I166E();
		ListNode.printLinkedList(obj.nthToLast(null, 2));	// NULL
		ListNode.printLinkedList(obj.nthToLast(n1, -1));	// NULL
		ListNode.printLinkedList(obj.nthToLast(n1, 0));	// NULL
		ListNode.printLinkedList(obj.nthToLast(n1, 5));	// NULL
		
		ListNode.printLinkedList(obj.nthToLast(n1, 2));	// 1 -> 5 -> NULL
		ListNode.printLinkedList(obj.nthToLast(n1, 4));	// 3 -> 2 -> 1 -> 5 -> NULL
	}
}

/**
 * LintCode #166
 * Find the nth to last element of a singly linked list. 
 * The minimum number of nodes in list is n.
 * Example: Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
 */
