package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The TreeNode class and binary tree utilities for LeetCode/LintCode code.
 */
public class TreeNode {
	// set val, left, right public just because classes in other packages need to access them. 
	public int val;
	public TreeNode left, right;
	
	public TreeNode (int x) {
		this.val = x;
	}
	
	/**
	 * Print a Binary Tree with automatically adjusted width scale based on the max size of the node values.
	 */
	public static void printBinaryTree(TreeNode root) {
		if (root == null) {
			System.out.println("NULL tree");
		}
		
		printBinaryTree(root, -1);	// default width scale
	}
	
	/**
	 * Print a Binary Tree with customized width scale.
	 */
	public static void printBinaryTree(TreeNode root, int widthScale) {
		int maxLevel = maxLevel(root);
		
		if (widthScale == -1) {	// automatically adjusted width scale
			widthScale = (int) (Math.log10(maxNodeValueSize(root)) / Math.log10(2));
		}
		
		printTree(Collections.singletonList(root), 1, maxLevel, widthScale);	// customized width scale
	}
	
	/**
	 * Print the binary tree from root to leaf in level order.
	 * @param nodes - nodes in the current level, null for missing nodes
	 * @param level - [1, maxLevel]
	 * @param maxLevel - max level
	 * @param widthScale - [0, 3] 3 can be max for int values
	 */
	private static void printTree(List<TreeNode> nodes, int level, int maxLevel, int widthScale) {
		if (nodes.isEmpty() || isAllElementsNull(nodes)) {
			return;
		}
		
		int floor = maxLevel - level;	// 3,2,1,0
		int endgeLines = (int) Math.pow(2, (Math.max(floor + widthScale - 1, 0)));	// # of lines to next level (4,2,1,1)
		int leadingSpaces = (int) Math.pow(2, (floor + widthScale)) - 1;	// leading spaces (7,3,1,0)
		int betweenSpaces = (int) Math.pow(2, (floor + widthScale + 1)) - 1;	// spaces between two nodes in this level (15,7,3,1)
		//System.out.println("floor = " + floor + "; endgeLines = " + endgeLines + "; leadingSpaces = " + leadingSpaces + "; betweenSpaces = " + betweenSpaces + "; "); 
		
		String nodeString = "";
		nodeString += generateChars(leadingSpaces, " ");	// print leading spaces before a node
		
		List<TreeNode> newNodes = new ArrayList<TreeNode>();	// next level's node list
		for (TreeNode node : nodes) {
			int nodeValueLength = getNodeValueLength(node);
			if (node != null) {
				nodeString = nodeString.substring(0, nodeString.length() - (nodeValueLength - 1) / 2); // truncate extra spaces
				nodeString += node.val;	// print a node
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {	// node == null
				nodeString += " ";	// place holder for a null node
				newNodes.add(null);
				newNodes.add(null);
			}
			nodeString += generateChars(betweenSpaces - nodeValueLength / 2, " ");	// print spaces between nodes in this level
		}
		
		// print the node line for the current level, without trailing spaces
		System.out.println(nodeString.replaceFirst("\\s+$", ""));
		if (floor == 0) {	// do not need to print the last line of edges
			return;
		}
				
		String edgeString = "";
		for (int j = 0; j < nodes.size(); j++) {
			edgeString += generateChars(leadingSpaces - endgeLines, " ");	// print spaces before a "┌"
			if (nodes.get(j) == null) {
				edgeString += generateChars(3 * endgeLines + 1, " ");	// place holder @ for a null node
				continue;
			}
			edgeString += (nodes.get(j).left == null) ? " " : "┌";	// print a "┌"
			edgeString += generateDashes(2 * endgeLines - 1, nodes.get(j));	// print "─┴─" between "┌" and "┐"
			edgeString += (nodes.get(j).right == null) ? " " : "┐";	// print a "┐"
			edgeString += generateChars(endgeLines, " ");	// place holder * for spaces after a "┐"
		}
		
		// print the edges between the current level and the next level, without trailing spaces
		System.out.println(edgeString.replaceFirst("\\s+$", ""));
		
		printTree(newNodes, level + 1, maxLevel, widthScale);
	}
	
	private static String generateChars(int count, String c) {
		String str = "";
		for (int i = 0; i < count; i++) {
			str += c;
		}
		return str;
	}
	
	private static String generateDashes(int count, TreeNode node) {
		String str = "";
		for (int i = 0; i < count; i++) {
			if (i < count / 2) {
				str += (node.left == null) ? " " : "─";
			} else if (i == count / 2) {
				if (node.left == null && node.right == null) {
					str += " ";
				} else if (node.left == null) {
					str += "└";
				} else if (node.right == null) {
					str += "┘";
				} else {
					str += "┴";
				}
			} else if (i > count / 2) {
				str += (node.right == null) ? " " : "─";
			}
		}
		return str;
	}
	
	private static int getNodeValueLength(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return String.valueOf(node.val).length();
	}
	
	private static int maxLevel(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
	}
	
	private static int maxNodeValueSize(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int max = String.valueOf(node.val).length();
		if(node.left != null) {
			max = Math.max(max, maxNodeValueSize(node.left));
		}
		if(node.right != null) {
			max = Math.max(max, maxNodeValueSize(node.right));
		}
		
		return max;
	}
	
	private static boolean isAllElementsNull(List<TreeNode> list) {
		for (TreeNode n : list) {
			if (n != null) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode.printBinaryTree(null);	// NULL tree
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(Integer.MIN_VALUE);
		TreeNode n8 = new TreeNode(Integer.MIN_VALUE);
		TreeNode n9 = new TreeNode(9);
		n1.left = n2; n1.right = n3;
		n2.left = n4; n3.left = n5; n3.right = n6;
		n4.left = n7; n4.right = n8; n6.right = n9;
		TreeNode.printBinaryTree(n1);	// with automatically adjusted width scale based on the max size of the node values
		/**
		 *                                                                1
		 *                                ┌───────────────────────────────┴───────────────────────────────┐
		 *                                2                                                               3
		 *                ┌───────────────┘                                               ┌───────────────┴───────────────┐
		 *                4                                                               5                               6
		 *        ┌───────┴───────┐                                                                                       └───────┐
		 *   -2147483648     -2147483648                                                                                          9
		 */
		TreeNode.printBinaryTree(n3);	// with automatically adjusted width scale based on the max size of the node values
		/**
		 *    3
		 *  ┌─┴─┐
		 *  5   6
		 *      └┐
		 *       9         
		 */
		TreeNode.printBinaryTree(n3, 0);	// with customized width scale
		/**
		 *    3
		 *  ┌─┴─┐
		 *  5   6
		 *      └┐
		 *       9         
		 */
		TreeNode.printBinaryTree(n3, 1);	// with customized width scale
		/**
		 *        3
		 *    ┌───┴───┐
		 *    5       6
		 *            └─┐
		 *              9
		 */
		TreeNode.printBinaryTree(n3, 2);	// with customized width scale
		/**
		 *                3
		 *        ┌───────┴───────┐
		 *        5               6
		 *                        └───┐
		 *                            9
		 */
		TreeNode.printBinaryTree(n3, 3);	// with customized width scale
		/**
		 *                                3
		 *                ┌───────────────┴───────────────┐
		 *                5                               6
		 *                                                └───────┐
		 *                                                        9
		 */
	}
}
