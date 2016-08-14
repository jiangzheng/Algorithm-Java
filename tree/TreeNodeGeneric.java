package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The generic TreeNode class and binary tree utilities.
 */
public class TreeNodeGeneric<T extends Comparable<?>> {
	T val;
	TreeNodeGeneric<T> left;
	TreeNodeGeneric<T> right;
	
	private static final int MAX_NODE_VALUE_SIZE = 15;	// max node value size for print
	
	public TreeNodeGeneric (T val) {
		this.val = val;
	}
	
	/**
	 * Print a Binary Tree with automatically adjusted width scale based on the max size of the node values.
	 */
	public static <T extends Comparable<?>> void printBinaryTree(TreeNodeGeneric<T> root) {
		if (root == null) {
			System.out.println("NULL tree");
		}
		
		printBinaryTree(root, -1);	// default - automatically adjusted width scale
	}
	
	/**
	 * Print a Binary Tree with width scale.
	 */
	public static <T extends Comparable<?>> void printBinaryTree(TreeNodeGeneric<T> root, int widthScale) {
		int maxLevel = maxLevel(root);
		
		if (widthScale == -1) {	// automatically adjusted width scale
			int maxNodeValueSize = Math.min(maxNodeValueSize(root), MAX_NODE_VALUE_SIZE);	// to print at most MAX_NODE_VALUE_SIZE chars for a node value
			widthScale = (int) (Math.log10(maxNodeValueSize) / Math.log10(2));	// [0, 3] if MAX_NODE_VALUE_SIZE = 15
		}
		
		printTree(Collections.singletonList(root), 1, maxLevel, widthScale);	// customized width scale
	}
	
	/**
	 * Print the binary tree from root to leaf in level order.
	 * @param nodes - nodes in the current level, null for missing nodes
	 * @param level - [1, maxLevel]
	 * @param maxLevel - max level
	 * @param widthScale - [0, 3]
	 */
	private static <T extends Comparable<?>> void printTree(List<TreeNodeGeneric<T>> nodes, int level, int maxLevel, int widthScale) {
		if (nodes.isEmpty() || isAllNodesNull(nodes)) {
			return;
		}
		
		int floor = maxLevel - level;	// 3,2,1,0
		int levelGap = (int) Math.pow(2, (Math.max(floor + widthScale - 1, 0)));	// level gaps (4,2,1,1)
		int leadingSpaces = (int) Math.pow(2, (floor + widthScale)) - 1;	// leading spaces (7,3,1,0)
		int betweenSpaces = (int) Math.pow(2, (floor + widthScale + 1)) - 1;	// spaces between two nodes in this level (15,7,3,1)
		
		// populate the node line string in the current level
		String nodeString = generateChars(leadingSpaces, " ");	// leading spaces before a node
		List<TreeNodeGeneric<T>> newNodes = new ArrayList<TreeNodeGeneric<T>>();	// next level's node list
		for (TreeNodeGeneric<T> node : nodes) {
			int nodeValueLength = getNodeValueLength(node);	// original node value length
			// truncate node value strings based on MAX_NODE_VALUE_SIZE and width scale (0->1, 1->3, 2->7 3->15)
			int nodeStringLength = Math.min(MAX_NODE_VALUE_SIZE, Math.min(nodeValueLength, betweenSpaces));	// at most MAX_NODE_VALUE_SIZE chars
			if (node != null && nodeValueLength > 0) {
				nodeString = nodeString.substring(0, nodeString.length() - (nodeStringLength - 1) / 2); // backspace extra spaces
				nodeString += String.valueOf(node.val).substring(0, nodeStringLength);	// a node
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {	// node is null or node value is ""
				nodeString += " ";	// place holder for a null node
				newNodes.add(null);
				newNodes.add(null);
			}
			nodeString += generateChars(betweenSpaces - nodeStringLength / 2, " ");	// spaces between nodes in this level
		}
		
		// print the node line for the current level, without trailing spaces
		System.out.println(nodeString.replaceFirst("\\s+$", ""));
		if (floor == 0) {	// do not need to print the last line of edges
			return;
		}
		
		// populate the edge line string between the current level and the next level
		String edgeString = "";
		for (int j = 0; j < nodes.size(); j++) {
			edgeString += generateChars(leadingSpaces - levelGap, " ");	// spaces before a "┌"
			if (nodes.get(j) == null) {
				edgeString += generateChars(3 * levelGap + 1, " ");	// spaces as place holder for a null node
				continue;
			}
			edgeString += (nodes.get(j).left == null) ? " " : "┌";	// a "┌" or " "
			edgeString += generateEdges(2 * levelGap - 1, nodes.get(j));	// the edge between "┌" and "┐"
			edgeString += (nodes.get(j).right == null) ? " " : "┐";	// a "┐" or " "
			edgeString += generateChars(levelGap, " ");	// spaces after a "┐"
		}
		
		// print the edge line between the current level and the next level, without trailing spaces
		System.out.println(edgeString.replaceFirst("\\s+$", ""));
		
		// go to the next level
		printTree(newNodes, level + 1, maxLevel, widthScale);
	}
	
	private static String generateChars(int count, String c) {
		String str = "";
		for (int i = 0; i < count; i++) {
			str += c;
		}
		return str;
	}
	
	private static <T extends Comparable<?>> String generateEdges(int count, TreeNodeGeneric<T> node) {
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
	
	private static <T extends Comparable<?>> int getNodeValueLength(TreeNodeGeneric<T> node) {
		if (node == null) {
			return 0;
		}
		return String.valueOf(node.val).length();
	}
	
	private static <T extends Comparable<?>> int maxLevel(TreeNodeGeneric<T> node) {
		if (node == null) {
			return 0;
		}
		return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
	}
	
	private static <T extends Comparable<?>> int maxNodeValueSize(TreeNodeGeneric<T> node) {
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
	
	private static <T> boolean isAllNodesNull(List<T> list) {
		for (Object n : list) {
			if (n != null) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNodeGeneric.printBinaryTree(null);	// NULL tree
		
		TreeNodeGeneric<String> n1 = new TreeNodeGeneric<String>("Earth");
		TreeNodeGeneric<String> n2 = new TreeNodeGeneric<String>("U.S.A");
		TreeNodeGeneric<String> n3 = new TreeNodeGeneric<String>("China");
		TreeNodeGeneric<String> n4 = new TreeNodeGeneric<String>("North Carolina");
		TreeNodeGeneric<String> n5 = new TreeNodeGeneric<String>("Shanghai");
		TreeNodeGeneric<String> n6 = new TreeNodeGeneric<String>("Jiangsu");
		TreeNodeGeneric<String> n7 = new TreeNodeGeneric<String>("Cary");
		TreeNodeGeneric<String> n8 = new TreeNodeGeneric<String>("Raleigh");
		TreeNodeGeneric<String> n9 = new TreeNodeGeneric<String>("Kunshan-Wuxi-Suzhou");
		n1.left = n2; n1.right = n3;
		n2.left = n4; n3.left = n5; n3.right = n6;
		n4.left = n7; n4.right = n8; n6.right = n9;
		TreeNodeGeneric.printBinaryTree(n1);	// with automatically adjusted width scale based on the max size of the node values
		/**
		 *                                                              Earth
		 *                                ┌───────────────────────────────┴───────────────────────────────┐
		 *                              U.S.A                                                           China
		 *                ┌───────────────┘                                               ┌───────────────┴───────────────┐
		 *          North Carolina                                                     Shanghai                        Jiangsu
		 *        ┌───────┴───────┐                                                                                       └───────┐
		 *       Cary          Raleigh                                                                                     Kunshan-Wuxi-Su
		 */
		TreeNodeGeneric.printBinaryTree(n3);	// with automatically adjusted width scale based on the max size of the node values
		/**
		 *                              China
		 *                ┌───────────────┴───────────────┐
		 *             Shanghai                        Jiangsu
		 *                                                └───────┐
		 *                                                 Kunshan-Wuxi-Su         
		 */
		TreeNodeGeneric.printBinaryTree(n3, 2);	// with customized width scale
		/**
		 *              China
		 *        ┌───────┴───────┐
		 *     Shanghai        Jiangsu
		 *                        └───┐
		 *                         Kunshan
		 */
		TreeNodeGeneric.printBinaryTree(n3, 1);	// with customized width scale
		/**
		 *      China
		 *    ┌───┴───┐
		 * Shangha Jiangsu
		 *            └─┐
		 *             Kun
		 */
		TreeNodeGeneric.printBinaryTree(n3, 0);	// with customized width scale
		/**
		 *  China
		 *  ┌─┴─┐
		 * Sha Jia
		 *      └┐
		 *       K
		 */
	}
}
