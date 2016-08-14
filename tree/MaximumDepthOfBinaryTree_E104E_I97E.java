package tree;

public class MaximumDepthOfBinaryTree_E104E_I97E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(log n) 
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {	// If reaching a leaf's child, return 0
			return 0;
		}

		// Get the max of max depths of left and right subtrees and then add 1 to it
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n5.left = n6;
		TreeNode.printBinaryTree(n1);
		/**
		 *        1
		 *    ┌───┴───┐
		 *    2       3
		 *  ┌─┴─┐
		 *  4   5
		 *     ┌┘
		 *     6
		 */
		
		MaximumDepthOfBinaryTree_E104E_I97E obj = new MaximumDepthOfBinaryTree_E104E_I97E();
		System.out.println(obj.maxDepth(n1));	// 4
		System.out.println(obj.maxDepth(n2));	// 3
		System.out.println(obj.maxDepth(n5));	// 2
		System.out.println(obj.maxDepth(n6));	// 1
	}
}

/**
 * LeetCode #104
 * LintCode #97
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
