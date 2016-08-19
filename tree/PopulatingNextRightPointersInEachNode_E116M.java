package tree;

public class PopulatingNextRightPointersInEachNode_E116M {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		TreeLinkNode dummy = new TreeLinkNode(0);	// dummy is the node above curr. dummy.next stores the leftmost node in the next level
		TreeLinkNode prev = dummy, curr = root;
		
		while (curr != null) {
			// when curr has any child:
			// if it's the leftmost node, connect dummy.next to it 
			// otherwise. connect previous left node to it
			if (curr.left != null) {
				prev.next = curr.left;
				prev = prev.next;
			}
			if (curr.right != null) {
				prev.next = curr.right;
				prev = prev.next;
			}
			curr = curr.next;
		}
		
		connect(dummy.next);	// go down to the next level
	}
	
	//Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		
	}
}

/**
 * LeetCode #116
 * Given a binary tree
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree 
 *   (i.e., all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 */
