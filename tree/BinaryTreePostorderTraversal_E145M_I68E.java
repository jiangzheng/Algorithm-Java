package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_E145M_I68E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(n)
	 */
	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postorder(root, list);
		return list;
	}
	
	private void postorder(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		postorder(node.left, list);
		postorder(node.right, list);
		list.add(node.val);
	}
	
	/**
	 * Iteration with a Stack.
	 * Time: O(n); Space: O(n)
	 */
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left == null && node.right == null) {
				list.add(stack.pop().val);
			} else {
				if (node.right != null) {
					stack.push(node.right);
					node.right = null;
				}
				if (node.left != null) {
					stack.push(node.left);
					node.left = null;
				}
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
		
		BinaryTreePostorderTraversal_E145M_I68E obj = new BinaryTreePostorderTraversal_E145M_I68E();
		System.out.println(obj.postorderTraversal1(n6));	// [1, 3, 5, 4, 2, 8, 9, 7, 6]
		System.out.println(obj.postorderTraversal2(n6));	// [1, 3, 5, 4, 2, 8, 9, 7, 6]
		
		n6.left = n2; n6.right = n7;
		n2.left = n1; n2.right = n4; n7.right = n9;
		n4.left = n3; n4.right = n5; n9.left = n8;
		System.out.println(obj.postorderTraversal1(n2));	// [1, 3, 5, 4, 2]
		System.out.println(obj.postorderTraversal2(n2));	// [1, 3, 5, 4, 2]
	}
}

/**
 * LeetCode #145
 * LintCode #68
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example: Given binary tree {1,#,2,3}, return [3,2,1].
 * 1
 *  \
 *   2
 *  /
 * 3
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
