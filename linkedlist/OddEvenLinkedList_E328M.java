package linkedlist;

public class OddEvenLinkedList_E328M {
	/**
	 * Use three pointers.
	 * Time: O(n); Space: O(1)
	 */
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode lastOdd = head;
		ListNode lastEven = head.next;
		ListNode firstEven = head.next;
		
		while (lastEven != null && lastEven.next != null) {
			lastOdd.next = lastOdd.next.next;	// link all odd notes together
			lastEven.next = lastEven.next.next;	// link all even notes together
			lastOdd = lastOdd.next;
			lastEven = lastEven.next;
		}
		
		lastOdd.next = firstEven;	// odd list -> even list
		
		return head;		
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode.printLinkedList(n1);	// 1 -> 2 -> 3 -> 4 -> 5 -> NULL
		
		OddEvenLinkedList_E328M obj = new OddEvenLinkedList_E328M();
		ListNode.printLinkedList(obj.oddEvenList(null));	// NULL
		
		ListNode.printLinkedList(obj.oddEvenList(n1));	// 1 -> 3 -> 5 -> 2 -> 4 -> NULL
	}
}

/**
 * LeetCode #328
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * Example: Given 1->2->3->4->5->NULL, return 1->3->5->2->4->NULL.
 * Note: The relative order inside both the even and odd groups should remain as it was in the input. 
 * The first node is considered odd, the second node even and so on ...
 */
