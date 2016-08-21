package tree;

public class BinaryTreeMaximumPathSum_I94M {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(1)
	 */
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		
		dfs(root, max);
		
		return max[0];
	}
	
	public int dfs(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
	 
		int left = dfs(root.left, max);
		int right = dfs(root.right, max);
	 
		int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
	 
		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
	 
		return current;
	}
	
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum_I94M obj = new BinaryTreeMaximumPathSum_I94M();
		System.out.println(obj.maxPathSum(null));	// 0
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2; n1.right = n3;
		TreeNode.printBinaryTree(n1);
		/**
		 *  1
		 * ┌┴┐
		 * 2 3
		 */
		System.out.println(obj.maxPathSum(n1));	// 6
	}
}

/**
 * LintCode #94
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * Example,  * Given the below binary tree:
 *   1
 *  / \
 * 2   3
 * return 6.
 */
