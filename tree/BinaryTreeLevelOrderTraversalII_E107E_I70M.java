package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII_E107E_I70M {
	/**
	 * BFS.
	 * Time: O(n); Space: O(n)
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		if (root == null) {
			return listList;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);	// enqueue root node
		queue.add(null);	// enqueue a flag of end-of-level
		
		// first run top-down level-order traversal
		while (!queue.isEmpty()) {	// until the queue is empty
			List<Integer> list = new ArrayList<>();
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
		
		// then reverse the top-down level-order traversal
		Collections.reverse(listList);
		
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
		 *		3
		 *	┌───┴───┐
		 *	9	   20
		 *		  ┌─┴─┐
		 *		  15  7
		 */
		
		BinaryTreeLevelOrderTraversalII_E107E_I70M obj = new BinaryTreeLevelOrderTraversalII_E107E_I70M();
		List<List<Integer>> list = obj.levelOrderBottom(n1);
		for (List<Integer> l : list) {
			System.out.print(l + ", ");	// [15, 7], [9, 20], [3], 
		}
	}
}

/**
 * LeetCode #107
 * LintCode #70
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (i.e., from left to right, level by level from leaf to root).
 * For example: Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
