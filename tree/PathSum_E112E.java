package tree;

public class PathSum_E112E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(log n)
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		
		if (root.left == null && root.right == null) {	// reach a leaf node
			return root.val == sum;
		}
		
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(1);
		n1.left = n2; n1.right = n3;
		n2.left = n4; n3.left = n5; n3.right = n6;
		n4.left = n7; n4.right = n8; n6.right = n9;
		TreeNode.printBinaryTree(n1);
		/**
		 *                5
		 *        ┌───────┴───────┐
		 *        4               8
		 *    ┌───┘           ┌───┴───┐
		 *    11              13      4
		 *  ┌─┴─┐                     └─┐
		 *  7   2                       1
		 */
		
		PathSum_E112E obj = new PathSum_E112E();
		System.out.println(obj.hasPathSum(n1, 22));	// true
		
		System.out.println(obj.hasPathSum(n1, 21));	// false
	}
}

/**
 * LeetCode #112
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 *   such that adding up all the values along the path equals the given sum.
 * For example: Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
