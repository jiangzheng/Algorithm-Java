package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_E144M_I66E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(n)
	 */
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		preorder(root, list);
		return list;
	}
	
	private void preorder(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		
		list.add(node.val);
		preorder(node.left, list);
		preorder(node.right, list);
	}

	/**
	 * Iteration with a Stack.
	 * Time: O(n); Space: O(n)
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
			
		return list;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		n6.left = n2; n6.right = n7;
		n2.left = n1; n2.right = n4; n7.right = n9;
		n4.left = n3; n4.right = n5; n9.left = n8;
		TreeNode.printBinaryTree(n6);
		/**
		 *        6
		 *    ┌───┴───┐
		 *    2       7
		 *  ┌─┴─┐     └─┐
		 *  1   4       9
		 *     ┌┴┐     ┌┘
		 *     3 5     8
		 */
		
		BinaryTreePreorderTraversal_E144M_I66E obj = new BinaryTreePreorderTraversal_E144M_I66E();
		System.out.println(obj.preorderTraversal1(n6));	// [6, 2, 1, 4, 3, 5, 7, 9, 8]
		System.out.println(obj.preorderTraversal2(n6));	// [6, 2, 1, 4, 3, 5, 7, 9, 8]
		System.out.println(obj.preorderTraversal1(n2));	// [2, 1, 4, 3, 5]
		System.out.println(obj.preorderTraversal2(n2));	// [2, 1, 4, 3, 5]
	}
}

/**
 * LeetCode #144
 * LintCode #66
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example: Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
