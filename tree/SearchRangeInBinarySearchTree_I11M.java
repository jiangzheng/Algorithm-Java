package tree;

import java.util.ArrayList;

public class SearchRangeInBinarySearchTree_I11M {
	/**
	 * DFS recursion.
	 * Time: O(log n); Space: O(n)
	 */
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		if (root == null || k1 > k2) {
			return list;	// invalid input
		}
		
		dfs(root, k1, k2);
		
		return list;
	}
	
	private void dfs(TreeNode node, int k1, int k2) {
		if (node == null) {
			return;
		}
		
		if (node.val > k1) {
			dfs(node.left, k1, k2);
		}
		
		if (k1 <= node.val && node.val <= k2) {
			list.add(node.val);
		}
		
		if (node.val < k2) {
			dfs(node.right, k1, k2);
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(20);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(22);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(12);
		n1.left = n2; n1.right = n3; n2.left = n4; n2.right = n5;
		TreeNode.printBinaryTree(n1);
		/**
		 *        20
		 *    ┌───┴───┐
		 *    8       22
		 *  ┌─┴─┐
		 *  4   12
		 */
		
		SearchRangeInBinarySearchTree_I11M obj = new SearchRangeInBinarySearchTree_I11M();
		System.out.println(obj.searchRange(n1, 10, 22));	// [12, 20, 22]
	}
}

/**
 * LintCode #11
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
 * Find all the keys of tree in range k1 to k2. 
 * i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.
 * Example: If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 *     20
 *    /  \
 *   8   22
 *  / \
 * 4   12
 */
