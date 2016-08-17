package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_E257E_I480E {
    /**
     * DFS recursion.
     * Time: O(n); Space: O(log n)
     */
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        
        if (root != null) {
        	findPaths(root, String.valueOf(root.val), list);
        }
        
        return list;
    }
    
    private void findPaths(TreeNode node, String valStr, List<String> list) {
        if (node.left == null && node.right == null) {	// leaf
            list.add(valStr);
            return;
        }
        
        if (node.left != null) {
            findPaths(node.left, valStr + "->" + node.left.val, list);
        }
        
        if (node.right != null) {
            findPaths(node.right, valStr + "->" + node.right.val, list);
        }
    }
    	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2; n1.right = n3; n2.right = n5;
		TreeNode.printBinaryTree(n1);
		/**
		 *    1
		 *  ┌─┴─┐
		 *  2   3
		 *  └┐
		 *   5
		 */

		BinaryTreePaths_E257E_I480E obj = new BinaryTreePaths_E257E_I480E();
		System.out.println(obj.binaryTreePaths(n1));	// [1->2->5, 1->3]
	}
}

/**
 * LeetCode #257
 * LintCode #480
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *   1
 *  / \
 * 2   3
 *  \
 *   5
 * All root-to-leaf paths are: ["1->2->5", "1->3"]
 */
