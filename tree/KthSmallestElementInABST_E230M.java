package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST_E230M {
	/**
	 * 1) Binary search based on the size of the left subtree.
	 * Time: O(n log n); Space: O(1)
	 */
	public int kthSmallest1(TreeNode root, int k) {
		if (k <= 0 || k > size(root)) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		return binarySearch(root, k);
	}
	
	private int binarySearch(TreeNode node, int k) {
		int n = size(node.left);	// O(n)
		
		if (k == n + 1) {
			return node.val;	// root is the kth smallest element
		} else if (k < n + 1) {
			return kthSmallest1(node.left, k);	// search the left subtree
		} else {	// if (k > n + 1)
			return kthSmallest1(node.right, k - (n + 1));	// search the right subtree
		}
	}
	
	private int size(TreeNode node) {
		return (node == null) ? 0 : size(node.left) + size(node.right) + 1;	// # of subtree nodes (including the root itself)
	}
	
	/**
	 * 2) In-order traversal.
	 * Time: O(n); Space: O(n)
	 */
	List<Integer> list = new ArrayList<Integer>();
	
	public int kthSmallest2(TreeNode root, int k) {
		if (k <= 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		inorder(root);	// in-order traversal
		
		if (k > list.size()) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		return list.get(k - 1);
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
		ConvertSortedArrayToBinarySearchTree_E108M_E177E obj = new ConvertSortedArrayToBinarySearchTree_E108M_E177E();
		TreeNode head = obj.sortedArrayToBST(18);
		TreeNode.printBinaryTree(head);
		/**
		 *                                9
		 *                ┌───────────────┴───────────────┐
		 *                4                               14
		 *        ┌───────┴───────┐               ┌───────┴───────┐
		 *        2               6               11              16
		 *    ┌───┴───┐       ┌───┴───┐       ┌───┴───┐       ┌───┴───┐
		 *    1       3       5       7       10      12      15      17
		 *                            └─┐             └─┐             └─┐
		 *                              8               13              18
		 */
		KthSmallestElementInABST_E230M obj2 = new KthSmallestElementInABST_E230M();
		System.out.println(obj2.kthSmallest1(null, 8));	// -2147483648
		System.out.println(obj2.kthSmallest2(null, 8));	// -2147483648
		System.out.println(obj2.kthSmallest1(head, 0));	// -2147483648
		System.out.println(obj2.kthSmallest2(head, 0));	// -2147483648
		System.out.println(obj2.kthSmallest1(head, 19));	// -2147483648
		System.out.println(obj2.kthSmallest2(head, 19));	// -2147483648

		System.out.println(obj2.kthSmallest1(head, 8));	// 8 (faster than method 2)
		System.out.println(obj2.kthSmallest2(head, 8));	// 8
	}
}

/**
 * LeetCode #230
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note: You may assume k is always valid, 1 <= k <= BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
 * How would you optimize the kthSmallest routine?
 * Hint:
 * - Try to utilize the property of a BST.
 * - What if you could modify the BST node's structure?
 * - The optimal runtime complexity is O(height of BST).
 */
