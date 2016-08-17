package tree;

public class InsertNodeInABinarySearchTree_I85E {
	/**
	 * Recursion.
	 * Time: O(log n); Space: O(1)
	 */
	public TreeNode insertNode1(TreeNode root, TreeNode node) {
		if (root == null) {
			return node;
		}
		
		if (root.val > node.val) {
			root.left = insertNode1(root.left, node);
		} else {
			root.right = insertNode1(root.right, node);
		}
		
		return root;
	}
	
	/**
	 * Iteration.
	 * Time: O(log n); Space: O(1)
	 */
	public TreeNode insertNode2(TreeNode root, TreeNode node) {
		TreeNode temp = root;
		
		while (temp != null) {
			if (temp.val > node.val) {	// check left
				if (temp.left == null) {	// insert here
					temp.left = node;
					return root;
				} else {
					temp = temp.left;	// go left
				}
			} else if (temp.val < node.val) {	// check right
				if (temp.right == null) {	// insert here
					temp.right = node;
					return root;
				} else {
					temp = temp.right;// go right
				}
			} else {	// find an existing node with the same val of the parameter node 
				return root;
			}
		}
		
		return node;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		n2.left = n1; n2.right = n4; n4.left = n3;
		TreeNode.printBinaryTree(n2);
		/**
		 *    2
		 *  ┌─┴─┐
		 *  1   4
		 *     ┌┘
		 *     3
		 */
		
		InsertNodeInABinarySearchTree_I85E obj = new InsertNodeInABinarySearchTree_I85E();
		TreeNode head = obj.insertNode1(n2, n6);
		TreeNode.printBinaryTree(head);
		/**
		 *    2
		 *  ┌─┴─┐
		 *  1   4
		 *     ┌┴┐
		 *     3 6
		 */
		
		n4.right = null;
		head = obj.insertNode2(n2, n6);
		TreeNode.printBinaryTree(head);
		/**
		 *    2
		 *  ┌─┴─┐
		 *  1   4
		 *     ┌┴┐
		 *     3 6
		 */
	}
}

/**
 * LintCode #85
 * Given a binary search tree and a new tree node, insert the node into the tree. 
 * You should keep the tree still be a valid binary search tree.
 * Notice: You can assume there is no duplicate values in this tree + node.
 * Example: Given binary search tree as follow, after Insert node 6, the tree should be:
 *   2             2
 *  / \           / \
 * 1   4   -->   1   4
 *    /             / \ 
 *   3             3   6
 */
