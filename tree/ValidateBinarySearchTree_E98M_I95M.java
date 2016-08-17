package tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree_E98M_I95M {
	/**
	 * 1) DFS recursion.
	 * Time: O(n); Space: O(log n) 
	 */
	public boolean isValidBST1(TreeNode root) {
		return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);	// restrict the min and max of a subtree
	}
	
	private boolean isValid(TreeNode node, double min, double max) {
		if (node == null) {
			return true;
		}
		
		if(node.val <= min || node.val >= max) {
			return false;
		}
		
		return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
	}
	
	/**
	 * 2) Check if the in-order traversal returns an ascending order.
	 * Time: O(n); Space: O(n)
	 */
	List<Integer> list = new ArrayList<Integer>();
	
	public boolean isValidBST2(TreeNode root) {
		inorder(root);	// in-order traversal
		
		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i - 1) > list.get(i)) {
				return false;
			}
		}
		
		return true;
	}

	private void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		
		inorder(node.left);
		list.add(node.val);
		inorder(node.right);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(20);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(22);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(12);
		TreeNode n6 = new TreeNode(1);
		n1.left = n2; n1.right = n3; n2.left = n4; n2.right = n5;
		TreeNode.printBinaryTree(n1);
		/**
		 *        20
		 *    ┌───┴───┐
		 *    8       22
		 *  ┌─┴─┐
		 *  4   12
		 */
		
		ValidateBinarySearchTree_E98M_I95M obj = new ValidateBinarySearchTree_E98M_I95M();
		System.out.println(obj.isValidBST1(null));	// true
		System.out.println(obj.isValidBST2(null));	// true
		
		System.out.println(obj.isValidBST1(n1));	// true
		System.out.println(obj.isValidBST1(n2));	// true
		
		n4.right = n6;
		System.out.println(obj.isValidBST1(n1));	// false
		System.out.println(obj.isValidBST1(n2));	// false
	}
}

/**
 * LeetCode #98
 * LintCode #95
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
