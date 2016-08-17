package tree;

public class ConvertSortedListToBinarySearchTree_E109M_I106M {
	/**
	 * DFS recursion. 
	 * Time: O(n); Space: O(log n) 
	 */
	private ListNode listNode;
	
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		
		int listSize = 0;	// size of the listNode
		ListNode pointer = head;
		while (pointer != null) {
			listSize++;
			pointer = pointer.next;
		}
		
		listNode = head;
		return sortedListToBST(0, listSize - 1);
	}
	
	private TreeNode sortedListToBST(int from, int to) {
		if (from > to) {
			return null;
		}
		
		int middle = (from + to) / 2;
		
		TreeNode leftChild = sortedListToBST(from, middle - 1);	// listNode will be at middle after this call
		TreeNode node = new TreeNode(listNode.val);	// store the middle node value in a node
		node.left = leftChild;	// link to the left child
		listNode = listNode.next;	// move listNode forward
		node.right = sortedListToBST(middle + 1, to);	// link to the right child
		
		return node;
	}
	
	public TreeNode sortedListToBST(int n) {
		ListNode[] nodes = new ListNode[n];
		nodes[0] = new ListNode(1);
		for (int i = 1; i < n; i++) {
			nodes[i] = new ListNode(i + 1);
			nodes[i - 1].next = nodes[i];
		}
		printLinkedList(nodes[0]);
		
		return sortedListToBST(nodes[0]);
	}

	public void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("NULL");
	}
	
	// Definition for singly-linked listNode.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		ConvertSortedListToBinarySearchTree_E109M_I106M obj = new ConvertSortedListToBinarySearchTree_E109M_I106M();
		TreeNode.printBinaryTree(obj.sortedListToBST(null));	// NULL tree
		
		TreeNode.printBinaryTree(obj.sortedListToBST(7));
		// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> NULL
		/**
		 *    4
		 *  ┌─┴─┐
		 *  2   6
		 * ┌┴┐ ┌┴┐
		 * 1 3 5 7
		 */
		
		TreeNode.printBinaryTree(obj.sortedListToBST(18));
		// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> NULL
		/**
		 *                                9
		 *                ┌───────────────┴───────────────┐
		 *                4                               14
		 *        ┌───────┴───────┐               ┌───────┴───────┐
		 *        2               6               11              16
		 *    ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐
		 *    1       3       5       7       10      12      15      17
		 *                            └─┐             └─┐             └─┐
		 *                              8               13              18
		 */
		
		TreeNode.printBinaryTree(obj.sortedListToBST(100));
		// 1 -> 2 -> 3 -> ... 98 -> -> 99 -> 100 -> NULL
		/**
		 *                                                                                                                                50
		 *                                                                ┌───────────────────────────────────────────────────────────────┴───────────────────────────────────────────────────────────────┐
		 *                                                                25                                                                                                                              75
		 *                                ┌───────────────────────────────┴───────────────────────────────┐                                                               ┌───────────────────────────────┴───────────────────────────────┐
		 *                                12                                                              37                                                              62                                                              88
		 *                ┌───────────────┴───────────────┐                               ┌───────────────┴───────────────┐                               ┌───────────────┴───────────────┐                               ┌───────────────┴───────────────┐
		 *                6                               18                              31                              43                              56                              68                              81                              94
		 *        ┌───────┴───────┐               ┌───────┴───────┐               ┌───────┴───────┐               ┌───────┴───────┐               ┌───────┴───────┐               ┌───────┴───────┐               ┌───────┴───────┐               ┌───────┴───────┐
		 *        3               9               15              21              28              34              40              46              53              59              65              71              78              84              91              97
		 *    ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐
		 *    1       4       7       10      13      16      19      23      26      29      32      35      38      41      44      48      51      54      57      60      63      66      69      73      76      79      82      86      89      92      95      99
		 *    └─┐     └─┐     └─┐     └─┐     └─┐     └─┐     └─┐   ┌─┴─┐     └─┐     └─┐     └─┐     └─┐     └─┐     └─┐     └─┐   ┌─┴─┐     └─┐     └─┐     └─┐     └─┐     └─┐     └─┐     └─┐   ┌─┴─┐     └─┐     └─┐     └─┐   ┌─┴─┐     └─┐     └─┐     └─┐   ┌─┴─┐
		 *      2       5       8       11      14      17      20  22  24      27      30      33      36      39      42      45  47  49      52      55      58      61      64      67      70  72  74      77      80      83  85  87      90      93      96  98 100
		 */
	}
}

/**
 * LeetCode #109
 * LintCode #106
 * Given a singly linked listNode where elements are sorted in ascending order, convert it to a height balanced BST.
 */
