package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_E199M {
	/**
	 * BFS Level-order Traversal, add the last node in each level to the list.
	 * Time: O(n); Space: O(n) 
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);	// enqueue root node
		queue.add(null);	// enqueue a flag of end-of-level

		while (!queue.isEmpty()) {	// until the queue is empty
			TreeNode node = queue.poll();	// retrieves and removes the head of this queue
			while (node != null) {	// until end-of-level
				if (queue.peek() == null) {	// if node is the last node in a level
					list.add(node.val);	// add the last node in each level to the list
				}
				if (node.left != null) {
					queue.add(node.left);	// enqueue left child
				}
				if (node.right != null) {
					queue.add(node.right);	// enqueue right child
				}
				node = queue.poll();
			}
			if (!queue.isEmpty()) {
				queue.add(null);	// enqueue a flag of end-of-level
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2; n1.right = n3; n2.right = n5; n3.right = n4;
		TreeNode.printBinaryTree(n1);
		/**
		 *    1
		 *  ┌─┴─┐
		 *  2   3
		 *  └┐  └┐
		 *   5   4
		 */
		
		BinaryTreeRightSideView_E199M obj = new BinaryTreeRightSideView_E199M();
		System.out.println(obj.rightSideView(n1));	// [1, 3, 4]
	}
}

/**
 * LeetCode #199
 * Given a binary tree, imagine yourself standing on the right side of it, 
 *   return the values of the nodes you can see ordered from top to bottom.
 * For example: Given the following binary tree,
 *    1      <---
 *  /   \
 * 2     3   <---
 *  \     \
 *   5     4 <---
 * You should return [1, 3, 4].
 */
