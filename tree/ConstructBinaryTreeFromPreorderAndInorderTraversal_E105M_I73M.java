package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_E105M_I73M {
	/**
	 * Recursion.
	 * Time: O(n); Space: O(log n) 
	 */
	private Map<Integer, Integer> inorderMap = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
			return null;
		}
		
		int length = inorder.length;
		
		for (int i = 0; i < length; i++) {
			inorderMap.put(inorder[i], i);
		}
		
		return buildSubTree(preorder, 0, 0, length - 1);
	}
	
	private TreeNode buildSubTree(int[] preorder, int curr, int start, int end) {
		TreeNode root = new TreeNode(preorder[curr]);
		
		if (start < end) {
			int middle = inorderMap.get(preorder[curr]);
			if (middle > start) {
				root.left = buildSubTree(preorder, curr + 1, start, middle - 1);
			}
			if (middle < end) {
				root.right = buildSubTree(preorder, curr + middle - start + 1, middle + 1, end);	// mid - start = # of left subtree nodes
			}
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		int[] preorder = new int[]{6, 2, 1, 4, 3, 5, 7, 9, 8};
		int[] inorder = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		ConstructBinaryTreeFromPreorderAndInorderTraversal_E105M_I73M obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal_E105M_I73M();
		System.out.println(obj.buildTree(null, null));	// null
		System.out.println(obj.buildTree(null, inorder));	// null
		System.out.println(obj.buildTree(preorder, null));	// null
		System.out.println(obj.buildTree(new int[]{}, new int[]{}));	// null
		System.out.println(obj.buildTree(new int[]{}, inorder));	// null
		System.out.println(obj.buildTree(preorder, new int[]{}));	// null
		
		TreeNode root = obj.buildTree(preorder, inorder);
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
 * LeetCode #105
 * LintCode #73
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 */
