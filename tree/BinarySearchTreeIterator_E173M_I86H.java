package tree;

import java.util.Stack;

public class BinarySearchTreeIterator_E173M_I86H {
	/**
	 * Use Stack.
	 */
	private TreeNode node;
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public BinarySearchTreeIterator_E173M_I86H(TreeNode root) {
		this.node = root;
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return !stack.isEmpty() || node != null;
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
		 
		TreeNode curr = stack.pop();
		node = curr.right;
		 
		return curr.val;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n4.left = n2; n4.right = n6; n2.left = n1; n2.right = n3; n6.left = n5;
		TreeNode.printBinaryTree(n4);
		/**
		 *    4
		 *  ┌─┴─┐
		 *  2   6
		 * ┌┴┐ ┌┘
		 * 1 3 5
		 */
		
		BinarySearchTreeIterator_E173M_I86H obj = new BinarySearchTreeIterator_E173M_I86H(n1);
		while (obj.hasNext()) {
			System.out.println(obj.next());	// 1
		}
	}
}

/**
 * LeetCode #173
 * LintCode #86
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: 
 * - next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext())
 *   v[f()] = i.next();
 */
