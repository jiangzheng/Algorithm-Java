package dp;

import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

public class UniqueBinarySearchTreesII_E95M_I164M {
	/**
	 * DFS. 
	 * Time: O(?); Space: O(?) 
	 */
	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) {
			return new ArrayList<TreeNode>();	// for LeetCode
			/**
			 * LintCode requires returning [{}] instead of [], so need to change to:
			 * List<TreeNode> list = new ArrayList<TreeNode>();
			 * list.add(null);
			 * return list;
			 */
		}
		
		return dfs(1, n);
	}
	
	/**
	 * Recursive method that returns all the unique BST's from start to end.
	 */
	private List<TreeNode> dfs(int start, int end) {
		List<TreeNode> subTree = new ArrayList<TreeNode>();

		if (start > end) {
			subTree.add(null);
			return subTree;
		}

		for (int i = start; i <= end; i++) {	// given a node i (from start to end)
			List<TreeNode> leftSubs = dfs(start, i - 1);	// generate left subtrees
			List<TreeNode> rightSubs = dfs(i + 1, end);		// generate right subtrees
			
			for (TreeNode left : leftSubs) {
				for (TreeNode right : rightSubs) {
					TreeNode node = new TreeNode(i);	// create the tree node
					node.left = left;
					node.right = right;
					subTree.add(node);	// add to list
				}
			}
		}
		
		return subTree;
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTreesII_E95M_I164M obj = new UniqueBinarySearchTreesII_E95M_I164M();
		System.out.println(obj.generateTrees(-1));	// []
		System.out.println(obj.generateTrees(0));	// []
		
		List<TreeNode> list = obj.generateTrees(2);
		for (TreeNode n : list) {
			TreeNode.printBinaryTree(n);
		}
		/**
		 *  1
		 *  └┐
		 *   2
		 *  2
		 * ┌┘
		 * 1
		 */
		
		list = obj.generateTrees(3);
		for (TreeNode n : list) {
			TreeNode.printBinaryTree(n);
		}
		/**
		 *    1
		 *    └─┐
		 *      2
		 *      └┐
		 *       3
		 *    1
		 *    └─┐
		 *      3
		 *     ┌┘
		 *     2
		 *  2
		 * ┌┴┐
		 * 1 3
		 *    3
		 *  ┌─┘
		 *  1
		 *  └┐
		 *   2
		 *    3
		 *  ┌─┘
		 *  2
		 * ┌┘
		 * 1
		 */
	}
}

/**
 * LeetCode #95
 * LintCode #164
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example, Given n = 3, your program should return all 5 unique BST's shown below.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
