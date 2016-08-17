package tree;

public class LowestCommonAncestorOfBST_E235E {
	/**
	 * DFS recursion.
	 * Time: O(log n); Space: O(log n)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		
		return dfs(root, p, q);
	}
	
	private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
		if (node.val < p.val && node.val < q.val) {
			return lowestCommonAncestor(node.right, p, q);	// if root.val < both p.val and q.val, go right
		} else if (node.val > p.val && node.val > q.val) {
			return lowestCommonAncestor(node.left, p, q);	// if root.val > both p.val and q.val, go left
		} else {
			return node;	// right here
		}
	}
	
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(0);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		n6.left = n2; n6.right = n8;
		n2.left = n0; n2.right = n4;
		n8.left = n7; n8.right = n9;
		n4.left = n3; n4.right = n5;
		TreeNode.printBinaryTree(n6);
		/**
		 *        6
		 *    ┌───┴───┐
		 *    2       8
		 *  ┌─┴─┐   ┌─┴─┐
		 *  0   4   7   9
		 *     ┌┴┐
		 *     3 5
		 */
		
		LowestCommonAncestorOfBST_E235E obj = new LowestCommonAncestorOfBST_E235E();
		System.out.println(obj.lowestCommonAncestor(null, n2, n8));	// null
		System.out.println(obj.lowestCommonAncestor(n6, null, n8));	// null
		System.out.println(obj.lowestCommonAncestor(n6, n2, null));	// null
		
		System.out.println(obj.lowestCommonAncestor(n6, n2, n8).val);	// 6
		System.out.println(obj.lowestCommonAncestor(n6, n2, n4).val);	// 2
	}
}

/**
 * LeetCode #235
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
 *  that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *        _______6______
 *       /              \
 *    ___2__          ___8__
 *   /      \        /      \
 *   0      _4       7       9
 *         /  \
 *         3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
 * Another example is LCA of nodes 2 and 4 is 2, 
 *   since a node can be a descendant of itself according to the LCA definition.
 */
