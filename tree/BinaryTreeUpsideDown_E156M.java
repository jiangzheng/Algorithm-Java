package tree;

public class BinaryTreeUpsideDown_E156M {
	/**
	 * Iteration.
	 * Time: O(n); Space: O(1)
	 */
	public TreeNode UpsideDownBinaryTree1(TreeNode root) {
		TreeNode p = root, parent = null, parentRight = null;
		
		while (p != null) {
			TreeNode left = p.left;
			TreeNode right = p.right;
			p.left = parentRight;
			p.right = parent;
			parent = p;
			parentRight = right;
			p = left;
		}
		
		return parent;
	}
	
	/**
	 * DFS recursion.
	 * Bottom-up
	 * Time: O(n); Space: O(log n)
	 */
	public TreeNode UpsideDownBinaryTree2(TreeNode root) {
		return dfsBottomUp(root, null);
	}

	private TreeNode dfsBottomUp(TreeNode p, TreeNode parent) {
		if (p == null) {
			return parent;
		}
		
		TreeNode root = dfsBottomUp(p.left, p);
		p.left = (parent == null) ? null : parent.right;
		p.right = parent;
		
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2; n1.right = n3; n2.left = n4; n2.right = n5;
		TreeNode.printBinaryTree(n1);
		/**
		 *    1
		 *  ┌─┴─┐
		 *  2   3
		 * ┌┴┐
		 * 4 5
		 */
		
		BinaryTreeUpsideDown_E156M obj = new BinaryTreeUpsideDown_E156M();
		TreeNode node = obj.UpsideDownBinaryTree1(n1);
		TreeNode.printBinaryTree(node);
		/**
		 *    4
		 *  ┌─┴─┐
		 *  5   2
		 *     ┌┴┐
		 *     3 1
		 */
		
		n1.left = n2; n1.right = n3; n2.left = n4; n2.right = n5; n4.left = null; n4.right = null;
		node = obj.UpsideDownBinaryTree2(n1);
		TreeNode.printBinaryTree(node);
		/**
		 *    4
		 *  ┌─┴─┐
		 *  5   2
		 *     ┌┴┐
		 *     3 1
		 */
	}
}

/**
 * LeetCode #156
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 *   (a left node that shares the same parent node) or empty, 
 *   flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. 
 *   Return the new root.
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1 
 */
