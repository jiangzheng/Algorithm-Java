package linkedlist;

public class DeleteNodeInALinkedList_E237E_I372E {
	/**
	 * Time: O(1); Space: O(1)
	 */
	public void deleteNode(ListNode node) {
		if (node != null && node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2; n2.next = n3; n3.next = n4;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> NULL
		
		DeleteNodeInALinkedList_E237E_I372E obj = new DeleteNodeInALinkedList_E237E_I372E();
		obj.deleteNode(null);
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> NULL
		obj.deleteNode(n4);
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> NULL
		
		obj.deleteNode(n3);
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 4 -> NULL
	}
}

/**
 * LeetCode #237
 * LintCode #372
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 *   the linked list should become 1 -> 2 -> 4 after calling your function.
 */
