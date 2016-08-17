package tree;

import java.util.Stack;

public class SymmetricTree_E101E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(log n)
	 */
	public boolean isSymmetric1(TreeNode root) {
		if (root == null) {	// If root is null return true
			return true;
		}
		
		return isSymmetric(root.left, root.right);	// Check if this node's left child and right child are same
	}
	
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {	// If both reaching leaves' children
			return true;
		}
		
		if (left == null || right == null || left.val != right.val) {	// If there's any difference b/w left and right
			return false;
		}
		
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);	// Recursion
	}
	
	/**
	 * Iteration.
	 * Time: O(?); Space: O(?)
	 */
	public boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		Stack<TreeNode> s = new Stack<TreeNode>();	// Use a stack to store nodes in order
		s.push(root.left);
		s.push(root.right);
		
		while (!s.isEmpty()) {	// pop and compare
			TreeNode n1 = s.pop();
			TreeNode n2 = s.pop();
			
			if (n1 == null && n2 == null) {
				continue;
			}
			
			if (n1 == null || n2 == null || n1.val != n2.val) {
				return false;
			}
			
			// add those pairs that should be symmetric
			s.push(n1.left);
			s.push(n2.right);
			s.push(n1.right);
			s.push(n2.left);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(Integer.MIN_VALUE);
		TreeNode n6 = new TreeNode(Integer.MIN_VALUE);
		TreeNode n7 = new TreeNode(3);
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		TreeNode.printBinaryTree(n1);
		/**
		 *                                1
		 *                ┌───────────────┴───────────────┐
		 *                2                               2
		 *        ┌───────┴───────┐               ┌───────┴───────┐
		 *        3          -2147483648     -2147483648          3
		 */
		
		SymmetricTree_E101E obj = new SymmetricTree_E101E();
		System.out.println(obj.isSymmetric1(n1));	// true
		System.out.println(obj.isSymmetric2(n1));	// true
		
		n1.left = n2; n1.right = n3;
		n2.left = null; n2.right = n4;
		n3.left = null; n3.right = n7;
		TreeNode.printBinaryTree(n1);
		/**
		 *    1
		 *  ┌─┴─┐
		 *  2   2
		 *  └┐  └┐
		 *   3   3
		 */
		
		System.out.println(obj.isSymmetric1(n1));	// false
		System.out.println(obj.isSymmetric2(n1));	// false
	}
}

/**
 * LeetCode #101
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3   3
 */
