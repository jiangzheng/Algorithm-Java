package tree;

public class Subtree_I245E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(log n)
	 */
	public boolean isSubtree(TreeNode T1, TreeNode T2) {
		if (T2 == null) {
			return true;
		}
		
		if (T1 == null) {
			return false;
		}
		
		if (isSameTree(T1, T2)) {
			return true;
		}
		
		return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
	}
	
	private boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {	// If both reaching leaves' children
			return true;
		}
		
		if (p == null || q == null || p.val != q.val) {	// If there's any difference b/w p and q
			return false;
		}
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);	// Check left children && right children
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(4);
		n1.left = n2; n1.right = n3; n3.left = n4;
		n5.left = n6;
		n7.right = n8;
		TreeNode.printBinaryTree(n1);
		/**
		 *    1
		 *  ┌─┴─┐
		 *  2   3
		 *     ┌┘
		 *     4
		 */
		TreeNode.printBinaryTree(n5);
		/**
		 *  3
		 * ┌┘
		 * 4
		 */
		TreeNode.printBinaryTree(n7);
		/**
		 *  3
		 *  └┐
		 *   4
		 */
		
		Subtree_I245E obj = new Subtree_I245E();
		System.out.println(obj.isSubtree(n1, n1));	// true
		System.out.println(obj.isSubtree(n1, n5));	// true
		
		System.out.println(obj.isSubtree(n1, n7));	// false
		System.out.println(obj.isSubtree(n5, n7));	// false
	}
}

/**
 * LintCode #245
 * You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
 * Create an algorithm to decide if T2 is a subtree of T1.
 * Notice: A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. 
 * That is, if you cut off the tree at node n, the two trees would be identical.
 * Example: T2 is a subtree of T1 in the following case:
 *        1                3
 *       / \              / 
 * T1 = 2   3      T2 =  4
 *         /
 *        4
 * T2 isn't a subtree of T1 in the following case:
 *        1               3
 *       / \               \
 * T1 = 2   3       T2 =    4
 *         /
 *        4
 */
