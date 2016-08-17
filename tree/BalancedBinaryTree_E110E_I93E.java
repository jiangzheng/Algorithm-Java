package tree;

public class BalancedBinaryTree_E110E_I93E {
	/**
	 * Top-down recursion.
	 * Time: O(n^2); Space: O(log n) 
	 * Need two levels of recursion, because a balanced parent node does not mean balanced child nodes.
	 * Duplicated calculation because maxDepth() has to be recalculated in child nodes.
	 */
	public boolean isBalanced1(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
			return false;
		}
		
		return isBalanced1(root.left) && isBalanced1(root.right);
	}
	
	private int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	/**
	 * Bottom-up recursion.
	 * Time: O(n); Space: O(log n) 
	 * Once the difference of maxDepth() of left and right child nodes is greater than 1, 
	 *   return -1 (unbalanced) and end up recursion quickly.
	 */
	public boolean isBalanced2(TreeNode root) {
		return maxDepth2(root) != -1;
	}

	private int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int l = maxDepth2(root.left);
		if (l == -1) {
			return -1;
		}
		
		int r = maxDepth2(root.right);
		if (r == -1) {
			return -1;
		}
		
		return (Math.abs(l - r) > 1) ? -1 : Math.max(l, r) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(9);
		n1.right = n2; n2.left = n3; n2.right = n4;
		TreeNode.printBinaryTree(n1);
		/**
		 *        3
		 *        └───┐
		 *            20
		 *          ┌─┴─┐
		 *          15  7
		 */
		
		BalancedBinaryTree_E110E_I93E obj = new BalancedBinaryTree_E110E_I93E();
		System.out.println(obj.isBalanced1(n1));	// false
		System.out.println(obj.isBalanced2(n1));	// false
		
		n1.left = n5;
		TreeNode.printBinaryTree(n1);
		/**
		 *        3
		 *    ┌───┴───┐
		 *    9       20
		 *          ┌─┴─┐
		 *          15  7
		 */
		System.out.println(obj.isBalanced1(n1));	// true
		System.out.println(obj.isBalanced2(n1));	// true
	}
}

/**
 * LeetCode #110
 * LintCode #93
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 *   in which the depth of the two subtrees of every node never differ by more than 1.
 * Example: Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}
 * A)  3     B) 3 
 *    / \        \
 *   9  20       20
 *     /  \      / \
 *    15   7    15  7
 * The binary tree A is a height-balanced binary tree, but B is not.
 */
