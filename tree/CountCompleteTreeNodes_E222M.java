package tree;

public class CountCompleteTreeNodes_E222M {
	/**
	 * Recursion.
	 * Time: O(n log n); Space: O(1)
	 */
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;	// invalid input
		}
		
		int leftHeight = 0, rightHeight = 0;
		TreeNode left = root, right = root;
		
		while (left != null) {
			left = left.left;
			leftHeight++;
		}
		
		while (right != null) {
			right = right.right;
			rightHeight++;
		}
		
		if (leftHeight == rightHeight) {
			return (1 << leftHeight) - 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}
	
	public static void main(String[] args) {
		CountCompleteTreeNodes_E222M obj = new CountCompleteTreeNodes_E222M();
		System.out.println(obj.countNodes(null));	// 0
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2; n1.right = n3; n2.left = n4; n2.right = n5; n3.left = n6;
		TreeNode.printBinaryTree(n1);
		/**
		 *    1
		 *  ┌─┴─┐
		 *  2   3
		 * ┌┴┐ ┌┘
		 * 4 5 6
		 */
		
		System.out.println(obj.countNodes(n1));	// 6
	}
}

/**
 * LeetCode #222
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 *   and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
