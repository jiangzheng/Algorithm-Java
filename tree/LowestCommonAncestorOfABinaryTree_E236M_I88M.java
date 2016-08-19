package tree;

public class LowestCommonAncestorOfABinaryTree_E236M_I88M {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(n)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		return left == null ? right : (right == null ? left : root);
	}
	
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		n3.left = n5; n3.right = n1;
		n5.left = n6; n5.right = n2;
		n1.left = n0; n1.right = n8;
		n2.left = n7; n2.right = n4;
		
		LowestCommonAncestorOfABinaryTree_E236M_I88M obj = new LowestCommonAncestorOfABinaryTree_E236M_I88M();
		System.out.println(obj.lowestCommonAncestor(n3, n5, n1).val);	// 3
		System.out.println(obj.lowestCommonAncestor(n3, n5, n4).val);	// 5
	}
}

/**
 * LeetCode #236
 * LintCode #88
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: 
 *   “The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
 *   that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
 * Another example is LCA of nodes 5 and 4 is 5, 
 *   since a node can be a descendant of itself according to the LCA definition.
 */
