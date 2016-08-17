package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_E113M {
	/**
	 * DFS Recursion.
	 * Time: O(n); Space: O(log n)
	 */
	private List<List<Integer>> pathList = new ArrayList<List<Integer>>();
	private List<Integer> path = new ArrayList<Integer>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		getPathSum(root, sum);
		return pathList;
	}

	private void getPathSum(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		
		path.add(root.val);
		
		if (root.left == null && root.right == null) {	// if reach a leaf node
			if (root.val == sum) {
				pathList.add(new ArrayList<Integer>(path));	// add current path to path list, need to create a new ArratList
			}
		}
		
		getPathSum(root.left, sum - root.val);
		getPathSum(root.right, sum - root.val);
				
		path.remove(path.size() - 1);	// remove the last element
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(1);
		TreeNode n10 = new TreeNode(5);
		n1.left = n2; n1.right = n3;
		n2.left = n4; n3.left = n5; n3.right = n6;
		n4.left = n7; n4.right = n8; n6.left = n10; n6.right = n9;
		TreeNode.printBinaryTree(n1);
		/**
		 *                5
		 *        ┌───────┴───────┐
		 *        4               8
		 *    ┌───┘           ┌───┴───┐
		 *    11              13      4
		 *  ┌─┴─┐                   ┌─┴─┐
		 *  7   2                   5   1
		 */
		
		PathSumII_E113M obj = new PathSumII_E113M();
		System.out.println(obj.pathSum(n1, 22));	// [[5, 4, 11, 2], [5, 8, 4, 5]]
	}
}

/**
 * LeetCode #113
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example: Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \	/ \
 * 7	2  5   1
 * return
 * [
 *   [5,4,11,2],
 *   [5,8,4,5]
 * ]
 */
