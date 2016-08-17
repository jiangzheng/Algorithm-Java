package tree;

public class SameTree_E100E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(log n)
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
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
		n1.left = n2; n1.right = n3;
		TreeNode.printBinaryTree(n1);
		/**
		 *  1
		 * ┌┴┐
		 * 2 3
		 */
		
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(3);
		n4.left = n5; n4.right = n6;
		TreeNode.printBinaryTree(n4);
		/**
		 *  1
		 * ┌┴┐
		 * 2 3
		 */
		
		SameTree_E100E obj = new SameTree_E100E();
		System.out.println(obj.isSameTree(n1, n4));	// true
		System.out.println(obj.isSameTree(n2, n5));	// true
		
		System.out.println(obj.isSameTree(n1, n5));	// false
		System.out.println(obj.isSameTree(n2, n6));	// false
	}
}

/**
 * LeetCode #100
 * LintCode #469
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
