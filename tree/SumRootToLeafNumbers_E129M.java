package tree;

public class SumRootToLeafNumbers_E129M {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(log n)
	 */
	public int sumNumbers(TreeNode root) {
		return getSum(root, 0);
	}
	
	private int getSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		
		sum = sum * 10 + root.val;	// calculate the sum
		if (root.left == null && root.right == null) {	// if reaching a leaf node, return the current sum
			return sum;
		}
		
		return getSum(root.left, sum) + getSum(root.right, sum);
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
		
		SumRootToLeafNumbers_E129M obj = new SumRootToLeafNumbers_E129M();
		System.out.println(obj.sumNumbers(n1));
	}
}

/**
 * LeetCode #129
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
