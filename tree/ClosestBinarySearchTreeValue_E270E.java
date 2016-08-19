package tree;

public class ClosestBinarySearchTreeValue_E270E {
	/**
	 * DFS recursion.
	 * Time: O(log n); Space: O(1)
	 */
	int result;
	double min = Double.MAX_VALUE;
	
	public int closestValue(TreeNode root, double target) {
		if (root == null) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		dfs(root, target);
		
		return result;
	}
	
	public void dfs(TreeNode node, double target) {
		if (node == null) {
			return;
		}
		
		if (Math.abs((double)node.val - target) < min) {
			min = Math.abs((double)node.val - target);
			result = node.val;
		}
		
		if (node.val > target) {
			dfs(node.left, target);
		} else if (node.val < target) {
			dfs(node.right, target);
		}
	}
	
	public static void main(String[] args) {
		ClosestBinarySearchTreeValue_E270E obj = new ClosestBinarySearchTreeValue_E270E();
		System.out.println(obj.closestValue(null, 2.3));	// -2147483648
		
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
		
		System.out.println(obj.closestValue(n4, 2.3));	// 2
		System.out.println(obj.closestValue(n4, 5.9));	// 6
	}
}

/**
 * LeetCode #270
 * Given a non-empty binary search tree and a target value, 
 *   find the value in the BST that is closest to the target.
 * Note: Given target value is a floating point. 
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
