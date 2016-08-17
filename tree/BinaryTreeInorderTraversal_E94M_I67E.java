package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_E94M_I67E {
	/**
	 * DFS recursion.
	 * Time: O(n); Space: O(n)
	 */
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		return list;
	}
	
	private void inorder(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		
		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}
	
	/**
	 * Iteration with a Stack.
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pointer = root;
		
		while (!stack.isEmpty() || pointer != null) {
			if (pointer != null) {
				stack.push(pointer);
				pointer = pointer.left;
			} else {
				TreeNode node = stack.pop();
				list.add(node.val);
				pointer = node.right;
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
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		n6.left = n2; n6.right = n7; n2.left = n1; n2.right = n4; n7.right = n9;
		n4.left = n3; n4.right = n5; n9.left = n8;
		TreeNode.printBinaryTree(n6);
		/**
		 *		6
		 *	┌───┴───┐
		 *	2	   7
		 *  ┌─┴─┐	 └─┐
		 *  1   4	   9
		 *	 ┌┴┐	 ┌┘
		 *	 3 5	 8
		 */
		
		BinaryTreeInorderTraversal_E94M_I67E obj = new BinaryTreeInorderTraversal_E94M_I67E();
		System.out.println(obj.inorderTraversal1(n6));	// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println(obj.inorderTraversal2(n6));	// [1, 2, 3, 4, 5, 6, 7, 8, 9]

		System.out.println(obj.inorderTraversal1(n2));	// [1, 2, 3, 4, 5]
		System.out.println(obj.inorderTraversal2(n2));	// [1, 2, 3, 4, 5]
	}
}

/**
 * LeetCode #94
 * LintCode #67
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example: Given binary tree {1,#,2,3}, return [1,3,2].
 * 1
 *  \
 *   2
 *  /
 * 3
 * Note: Recursive solution is trivial, could you do it iteratively?
 */


/**
 * Use a Stack: 
 * 先找最左节点，然后一层层往上返回，每返回一层节点，要进入其右子树遍历（重复该过程）。
 * 注意：程序结构和pre-order几乎是一致的，仅是 list.add(curr.val) 的位置不同。
 * left-root-right
 * Time: O(n); Space: O(n) 
 */
/*
public List<Integer> inorderTraversal3(TreeNode root) {
	List<Integer> list = new ArrayList<>();
	if (root == null)
		return list;
	
	Stack<TreeNode> stack = new Stack<>();
	TreeNode curr = root;	// pointer
	
	while (curr != null) {	// find leftmost node
		stack.push(curr);		// push all nodes in the path into the stack
		curr = curr.left;		// move pointer to the left child
	}
	
	while (!stack.isEmpty()) {	// until the stack is empty
		curr = stack.pop();			// pop out nodes in the path in reversed order
		list.add(curr.val);			// left-root-right
		curr = curr.right;			// move pointer to the right child
		while (curr != null) {	// find leftmost node
			stack.push(curr);		// push all nodes in the path into the stack
			curr = curr.left;		// move pointer to the left child
		}
	}
	
	return list;
}
*/

/**
 * Morris Inorder Traversal: 
 * 改变Tree的结构，将node下最右节点连接node的parent，这样可以自动返回上层。
 * https://en.wikipedia.org/wiki/Threaded_binary_tree
 * Time: O(n); Space: O(1)
 */
/*
public List<Integer> inorderTraversal4(TreeNode root) {
	List<Integer> list = new ArrayList<>();
	TreeNode curr = root;
	
	while (curr != null) {
		if (curr.left != null) {		// if curr has left children
			TreeNode prev = curr.left;
			while (prev.right != null && prev.right != curr) {
				prev = prev.right;		// find the rightmost node in curr's left subtree
			}
			if (prev.right == null) {	// set right to successor, and go to left
				prev.right = curr;
				curr = curr.left;
			} else {					// visit and revert the change, and go to right
				prev.right = null;
				list.add(curr.val);
				curr = curr.right;
			}
		} else {						// if curr doesn't have left child, go to right
			list.add(curr.val);
			curr = curr.right;
		}
	}
	return list;
}
*/
