package linkedlist;

public class PalindromeLinkedList_E234E_I223E {
	/**
	 * Find the middle, reverse the 2nd half, compare the 1st half with the 2nd half.
	 * Time: O(n); Space: O(1)
	 */
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;	// invalid input or shortcut
		}
		
		// find the center of the list 
		// the slow pointer stops at the middle node (odd # of nodes) or at the end of the 1st half (even # of nodes)
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;	// twice speed as slow
			slow = slow.next;
		}
		
		// reverse the 2nd half of the list (slow.next is the beginning of the 2nd half of the list)
		// slow doesn't move, fast always points to the original slow.next node
		// after reversion, slow.next still points to the beginning of the reverted 2nd half
		fast = slow.next;
		while (fast != null && fast.next != null) {
			ListNode temp = fast.next.next;
			fast.next.next = slow.next;
			slow.next = fast.next;
			fast.next = temp;
		}

		// compare two list (start from head and slow.next) to see if they're the same.
		while (slow.next != null) {
			slow = slow.next;
			if (head.val != slow.val) {
				return false;
			}
			head = head.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(1);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7;
		ListNode.printLinkedList(n1);	// 1 -> 3 -> 2 -> 3 -> 2 -> 3 -> 1 -> NULL
		
		PalindromeLinkedList_E234E_I223E obj = new PalindromeLinkedList_E234E_I223E();
		System.out.println(obj.isPalindrome(null));	// true
		
		System.out.println(obj.isPalindrome(n1));	// true
		System.out.println(obj.isPalindrome(n2));	// false
		System.out.println(obj.isPalindrome(n3));	// false
		System.out.println(obj.isPalindrome(n4));	// false
		System.out.println(obj.isPalindrome(n5));	// false
		System.out.println(obj.isPalindrome(n6));	// false
		System.out.println(obj.isPalindrome(n7));	// true
	}
}

/**
 * LeetCode #234
 * LintCode #223
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
