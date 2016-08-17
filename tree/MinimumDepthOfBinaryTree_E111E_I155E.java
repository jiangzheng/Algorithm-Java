package tree;

public class MinimumDepthOfBinaryTree_E111E_I155E {
	/**
	 * Recursion.
	 * Time: O(n); Space: O(log n)
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null) {			// if only left child is null, return right child's minDepth + 1
			return minDepth(root.right) + 1;
		} else if (root.right == null) {	// if only right child is null, return left child's minDepth + 1
			return minDepth(root.left) + 1;
		} else {							// if (root.left != null && root.right != null)
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2; n1.right = n3;
		n3.left = n4; n3.right = n5;
		TreeNode.printBinaryTree(n1);
		/**
		 *    1
		 *  ┌─┴─┐
		 *  2   3
		 *     ┌┴┐
		 *     4 5
		 */

		MinimumDepthOfBinaryTree_E111E_I155E obj = new MinimumDepthOfBinaryTree_E111E_I155E();
		System.out.println(obj.minDepth(n1));	// 2
		System.out.println(obj.minDepth(n2));	// 1
		System.out.println(obj.minDepth(n3));	// 2
	}
}

/**
 * LeetCode #111
 * LintCode #155
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Given a binary tree as follow:
 *   1
 *  / \ 
 * 2   3
 *    / \
 *   4   5
 * The minimum depth is 2.
 */
