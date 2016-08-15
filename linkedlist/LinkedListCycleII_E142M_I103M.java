package linkedlist;

public class LinkedListCycleII_E142M_I103M {
	/**
	 * Use three pointers.
	 * Time: O(n); Space: O(1) 
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;	// slow pointer move 1 step each time
			fast = fast.next.next;	// fast pointer move 2 steps each time
			
			if (slow == fast) {		// if they meet, it means there is a cycle
				ListNode slow2 = head;	// start another slow pointer
				
				while (slow2 != slow) {	// slow and slow2 move forward at the same speed
					slow = slow.next;
					slow2 = slow2.next;
				}
				
				return slow2;	// when slow meets slow2, it is where the cycle begins
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n4.next = n2;
		/**
		 * 1 -> 2 -> 3 -> 4 -> 5 - NULL
		 *      ^         |
		 *      |_________|
		 */
				
		LinkedListCycleII_E142M_I103M obj = new LinkedListCycleII_E142M_I103M();
		System.out.println(obj.detectCycle(null));	// null
		System.out.println(obj.detectCycle(n5));	// null
		
		System.out.println(obj.detectCycle(n1).val);	// 2
		System.out.println(obj.detectCycle(n2).val);	// 2
	}
}

/**
 * LeetCode #142
 * LintCode #103
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list. Follow up: Can you solve it without using extra space?
 */
