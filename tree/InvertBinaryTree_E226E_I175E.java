package tree;

public class InvertBinaryTree_E226E_I175E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(n) 
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		// switch left and right
		root.left = right;
		root.right = left;
		
		return root;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		n4.left = n2; n4.right = n7;
		n2.left = n1; n2.right = n3;
		n7.left = n6; n7.right = n9;
		
		System.out.println("Before: ");
		TreeNode.printBinaryTree(n4);
		/**
		 * Before: 
		 *    4
		 *  ┌─┴─┐
		 *  2   7
		 * ┌┴┐ ┌┴┐
		 * 1 3 6 9
		 */
		
		InvertBinaryTree_E226E_I175E obj = new InvertBinaryTree_E226E_I175E();
		TreeNode head = obj.invertTree(n4);
		System.out.println("After: ");
		TreeNode.printBinaryTree(head);
		/**
		 * After: 
		 *    4
		 *  ┌─┴─┐
		 *  7   2
		 * ┌┴┐ ┌┴┐
		 * 9 6 3 1
		 */
	}
}

/**
 * LeetCode #226
 * LintCode #175?
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
