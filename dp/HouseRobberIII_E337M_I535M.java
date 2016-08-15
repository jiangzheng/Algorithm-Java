package dp;

import tree.TreeNode;

public class HouseRobberIII_E337M_I535M {
	/**
	 * DFS.
	 * Time: O(n); Space: O(n)
	 */
	public int rob(TreeNode root) {
		if (root == null) {
			return 0;	// invalid input
		}
		
		int[] money = dfs(root);
		
		return Math.max(money[0], money[1]);
	}
	
	private int[] dfs(TreeNode node) {
		if (node == null) {
			return new int[]{0, 0};
		}
		
		int[] left = dfs(node.left);
		int[] right = dfs(node.right);
		
		int[] money = new int[2];
		money[0] = node.val + left[1] + right[1];	// when root is robbed
		money[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);	// when root is NOT robbed
		
		return money;
	}
	
	public static void main(String[] args) {
		HouseRobberIII_E337M_I535M obj = new HouseRobberIII_E337M_I535M();
		System.out.println(obj.rob(null));	// 0
		
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(1);
		n1.left = n2; n1.right = n3; n2.right = n4; n3.right = n5;
		TreeNode.printBinaryTree(n1);
		/**
		 *    3
		 *  ┌─┴─┐
		 *  2   3
		 *  └┐  └┐
		 *   3   1
		 */
		System.out.println(obj.rob(n1));	// 7
		
		TreeNode n11 = new TreeNode(3);
		TreeNode n12 = new TreeNode(4);
		TreeNode n13 = new TreeNode(5);
		TreeNode n14 = new TreeNode(1);
		TreeNode n15 = new TreeNode(3);
		TreeNode n16 = new TreeNode(1);
		n11.left = n12; n11.right = n13; n12.left = n14; n12.right = n15; n13.right = n16;
		TreeNode.printBinaryTree(n11);
		/**
		 *    3
		 *  ┌─┴─┐
		 *  4   5
		 * ┌┴┐  └┐
		 * 1 3   1
		 */
		System.out.println(obj.rob(n11));	// 9
	}
}

/**
 * LeetCode #337
 * LintCode #535
 * The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called the "root." 
 * Besides the root, each house has one and only one parent house. 
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Example 1:
 *   3
 *  / \
 * 2   3
 *  \   \ 
 *   3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *     3
 *    / \
 *   4   5
 *  / \   \ 
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
