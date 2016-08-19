package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInonderAndPostorderTraversal_E106M_I72M {
	/**
	 * Recursion.
	 * Time: O(n); Space: O(log n)
	 */
	private Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
			return null;
		}
		
		int length = inorder.length;
		
		for (int i = 0; i < length; i++) {
			inorderMap.put(inorder[i], i);
		}
		
		return buildSubTree(postorder, length - 1, 0, length - 1);
	}
	
	private TreeNode buildSubTree(int[] postorder, int curr, int start, int end) {
		TreeNode root = new TreeNode(postorder[curr]);
		
		if (start < end) {
			int middle = inorderMap.get(postorder[curr]);
			if (middle > start) {
				root.left = buildSubTree(postorder, curr - (end - middle) - 1, start, middle - 1);	// end - mid = # of left subtree nodes
			}
			if (middle <end) {
				root.right = buildSubTree(postorder, curr - 1, middle + 1, end);
			}
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		int[] inorder = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] postorder = new int[]{1, 3, 5, 4, 2, 8, 9, 7, 6};
		
		ConstructBinaryTreeFromInonderAndPostorderTraversal_E106M_I72M obj = new ConstructBinaryTreeFromInonderAndPostorderTraversal_E106M_I72M();
		System.out.println(obj.buildTree(null, null));	// null
		System.out.println(obj.buildTree(null, postorder));	// null
		System.out.println(obj.buildTree(inorder, null));	// null
		System.out.println(obj.buildTree(new int[]{}, new int[]{}));	// null
		System.out.println(obj.buildTree(new int[]{}, postorder));	// null
		System.out.println(obj.buildTree(inorder, new int[]{}));	// null
		
		TreeNode root = obj.buildTree(inorder, postorder);
		TreeNode.printBinaryTree(root);
		/**
		 *        6
		 *    ┌───┴───┐
		 *    2       7
		 *  ┌─┴─┐     └─┐
		 *  1   4       9
		 *     ┌┴┐     ┌┘
		 *     3 5     8
		 */
	}
}

/**
 * LeetCode #106
 * LintCode #72
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 */
