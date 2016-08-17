package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_E102E_I69M {
	/**
	 * BFS.
	 * Time: O(n); Space: O(n)
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		if (root == null) {
			return listList;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);	// enqueue root node
		queue.add(null);	// enqueue a flag of end-of-level
		
		while (!queue.isEmpty()) {	// until the queue is empty
			List<Integer> list = new ArrayList<Integer>();
			TreeNode node = queue.poll();	// retrieves and removes the head of this queue
			
			while (node != null) {	// until end-of-level
				list.add(node.val);	// for each node, add val into list
				if (node.left != null) {
					queue.add(node.left);	// enqueue left child
				}
				if (node.right != null) {
					queue.add(node.right);	// enqueue right child
				}
				node = queue.poll();
			}
			
			listList.add(list);	// add nodes in current level into listList
			
			if (!queue.isEmpty()) {
				queue.add(null);	// enqueue a flag of end-of-level
			}
		}
		
		return listList;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2; n1.right = n3; n3.left = n4; n3.right = n5;
		TreeNode.printBinaryTree(n1);
		/**
		 *        3
		 *    ┌───┴───┐
		 *    9       20
		 *          ┌─┴─┐
		 *          15  7
		 */
		
		BinaryTreeLevelOrderTraversal_E102E_I69M obj = new BinaryTreeLevelOrderTraversal_E102E_I69M();
		List<List<Integer>> list = obj.levelOrder(n1);
		for (List<Integer> l : list) {
			System.out.print(l + ", ");	// [3], [9, 20], [15, 7], 
		}
	}
}

/**
 * LeetCode #102
 * LintCode #69
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (i.e., from left to right, level by level).
 * For example: Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
