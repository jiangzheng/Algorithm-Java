package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal_E103M_I71M {
	/**
	 * BFS.
	 * Use two stacks. stack - nodes in current level, stackTmp - nodes in next level
	 * Use a boolean value to record odd/even level, determining the order of pushing left/right node
	 * - if oddLevel = true, right node then left node
	 * - if oddLevel = false, left node then right node
	 * Time: O(n); Space: O(n)
	 */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if (root == null) {
        	return listList;
        }
        
        Stack<TreeNode> currentLevelStack = new Stack<>();
        currentLevelStack.push(root);
        boolean oddLevel = false; // default: even levels
        
        while (!currentLevelStack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> nextLevelStack = new Stack<>();
            
            while (!currentLevelStack.isEmpty()) {
                TreeNode node = currentLevelStack.pop();
                list.add(node.val);
                if (oddLevel) {
                    if (node.right != null) {
                    	nextLevelStack.push(node.right);
                    }
                    if (node.left != null) {
                    	nextLevelStack.push(node.left);
                    }
                } else {
                    if (node.left != null) {
                    	nextLevelStack.push(node.left);
                    }
                    if (node.right != null) {
                    	nextLevelStack.push(node.right);
                    }
                }
            }
            
            listList.add(list);
            currentLevelStack = nextLevelStack;
            oddLevel = !oddLevel;
        }
        
        return listList;
    }
    
    public static void main(String[] args) {
    	BinaryTreeZigzagLevelOrderTraversal_E103M_I71M obj = new BinaryTreeZigzagLevelOrderTraversal_E103M_I71M();
    	System.out.println(obj.zigzagLevelOrder(null));	// []
    	
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
		
		List<List<Integer>> listList = obj.zigzagLevelOrder(n1);
		for (List<Integer> list : listList) {
			System.out.println(list);
		}
		/**
		 * [3]
		 * [20, 9]
		 * [15, 7]
		 */
    }
}

/**
 * LeetCode #103
 * LintCode #71
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * For example: Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
