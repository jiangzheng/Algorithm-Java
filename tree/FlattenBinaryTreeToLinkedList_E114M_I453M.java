package tree;

public class FlattenBinaryTreeToLinkedList_E114M_I453M {
	/**
	 * Recursion.
	 * Time: O(n); Space: O(log n) 
	 */
	public void flatten1(TreeNode root) {
		if (root == null) {
			return;
		}
		
		// recursion
		flatten1(root.left);
		flatten1(root.right);
		
		if (root.left == null) {
			return;
		}
		
		// merge: root-left-right
		TreeNode node = root.left;
		while (node.right != null) {
			node = node.right;
		}
		
		node.right = root.right;
		root.right = root.left;
		root.left = null;
	}
	
	/**
	 * Iteration (no Stack).
	 * Time: O(n); Space: O(1)
	 */
	public void flatten2(TreeNode root) {
		TreeNode node = root;
		
		while (node != null) {
			if (node.left != null) {
				// connect the rightmost node in the left subtree to the right node
				if (node.right != null) {
					TreeNode next = node.left;
					while (next.right != null) {
						next = next.right;
					}
					next.right = node.right;
				}
				// move left node to right
				node.right = node.left;
				node.left = null;
			}
			node = node.right;
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2; n1.right = n5; n2.left = n3; n2.right = n4; n5.right = n6;
		TreeNode.printBinaryTree(n1);
		/**
		 *    1
		 *  ┌─┴─┐
		 *  2   5
		 * ┌┴┐  └┐
		 * 3 4   6
		 */
		
		FlattenBinaryTreeToLinkedList_E114M_I453M obj = new FlattenBinaryTreeToLinkedList_E114M_I453M();
		obj.flatten1(n1);
		TreeNode.printBinaryTree(n1);
		/**
		 *                                1
		 *                                └───────────────┐
		 *                                                2
		 *                                                └───────┐
		 *                                                        3
		 *                                                        └───┐
		 *                                                            4
		 *                                                            └─┐
		 *                                                              5
		 *                                                              └┐
		 *                                                               6
		 */
		
		n1.left = n2; n1.right = n5; n2.left = n3; n2.right = n4; n5.left = null; n5.right = n6;
		n3.left = null; n3.right = null; n4.left = null; n4.right = null; n6.left = null; n6.right = null;
		obj.flatten2(n1);
		TreeNode.printBinaryTree(n1);
		/**
		 *                                1
		 *                                └───────────────┐
		 *                                                2
		 *                                                └───────┐
		 *                                                        3
		 *                                                        └───┐
		 *                                                            4
		 *                                                            └─┐
		 *                                                              5
		 *                                                              └┐
		 *                                                               6
		 */
	}
}

/**
 * LeetCode #114
 * LintCode #153
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, Given
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Hints:
 * If you notice carefully in the flattened tree, 
 *   each node's right child points to the next node of a pre-order traversal.
 */
