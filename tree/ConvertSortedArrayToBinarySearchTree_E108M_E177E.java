package tree;

public class ConvertSortedArrayToBinarySearchTree_E108M_E177E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(log n)
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}
	
	private TreeNode sortedArrayToBST(int[] num, int from, int to) {
		if (from > to) {
			return null;
		}
		
		int middle = (from + to) / 2;
		TreeNode node = new TreeNode(num[middle]);
		
		node.left = sortedArrayToBST(num, from, middle - 1);
		node.right = sortedArrayToBST(num, middle + 1, to);
		
		return node;
	}
	
	public TreeNode sortedArrayToBST(int n) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		
		return sortedArrayToBST(nums);
	}
	
	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree_E108M_E177E obj = new ConvertSortedArrayToBinarySearchTree_E108M_E177E();
		TreeNode.printBinaryTree(obj.sortedArrayToBST(null));	// NULL tree
		TreeNode.printBinaryTree(obj.sortedArrayToBST(new int[]{}));	// NULL tree
		
		TreeNode.printBinaryTree(obj.sortedArrayToBST(7));
		/**
		 *    4
		 *  ┌─┴─┐
		 *  2   6
		 * ┌┴┐ ┌┴┐
		 * 1 3 5 7
		 */
		
		TreeNode.printBinaryTree(obj.sortedArrayToBST(18));
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
		
		TreeNode.printBinaryTree(obj.sortedArrayToBST(100));
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
 * LeetCode #108
 * LintCode #177
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Example: Given [1,2,3,4,5,6,7], return
 *      4
 *    /   \
 *   2     6
 *  / \   / \
 * 1   3 5   7
 */
