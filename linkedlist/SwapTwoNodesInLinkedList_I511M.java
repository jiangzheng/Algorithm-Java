package linkedlist;

public class SwapTwoNodesInLinkedList_I511M {
	/**
	 * Use 2 pairs of pointers.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode swapNodes(ListNode head, int v1, int v2) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pren1 = dummy, pren2 = dummy;
		ListNode n1 = head, n2 = head;
		
		while (n1 != null) {	// find n1 whose value is v1
			if (n1.val == v1) {
				break;
			}
			pren1 = pren1.next;
			n1 = n1.next;
		}
		
		while (n2 != null) {	// find n2 whose value is v2
			if (n2.val == v2) {
				break;
			}
			pren2 = pren2.next;
			n2 = n2.next;
		}
		
		if (n1 != null && n2 != null) {	// swap the two nodes
			pren1.next = n2;
			pren2.next = n1;
			ListNode temp = n1.next;
			n1.next = n2.next;
			n2.next = temp;
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
		
		SwapTwoNodesInLinkedList_I511M obj = new SwapTwoNodesInLinkedList_I511M();
		ListNode.printLinkedList(obj.swapNodes(null, 2, 4));	// NULL
		ListNode.printLinkedList(obj.swapNodes(n1, 0, 4));	// 1 -> 2 -> 3 -> 4 -> NULL
		ListNode.printLinkedList(obj.swapNodes(n1, 2, 5));	// 1 -> 2 -> 3 -> 4 -> NULL
		
		ListNode.printLinkedList(obj.swapNodes(n1, 2, 4));	// 1 -> 4 -> 3 -> 2 -> NULL
		ListNode.printLinkedList(obj.swapNodes(n1, 2, 4));	// 1 -> 2 -> 3 -> 4 -> NULL
	}
}

/**
 * LintCode #511
 * Given a linked list and two values v1 and v2. 
 * Swap the two nodes in the linked list with values v1 and v2. 
 * It's guaranteed there is no duplicate values in the linked list. 
 * If v1 or v2 does not exist in the given linked list, do nothing.
 * Notice: You should swap the two nodes with values v1 and v2. Do not directly swap the values of the two nodes.
 * Example: Given 1->2->3->4->null and v1 = 2, v2 = 4. Return 1->4->3->2->null.
 */
