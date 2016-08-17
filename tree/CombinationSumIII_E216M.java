package tree;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_E216M {
	/**
	 * DFS recursion, backtracking.
	 * Time: O(n!); Space: O(n)
	 */
	private List<List<Integer>> listList;
	private List<Integer> list;
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		listList = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>();
		
		if (k <= 0 || n <= 0) {
			return listList;	// invalid input
		}
		
		dfs(k, n, 1);
		
		return listList;
	}
	
	private void dfs(int k, int n, int from) {
		if (k < 0 || n < 0) {	// no combination sum
			return;
		} else if (k == 0 && n == 0) {
			listList.add(new ArrayList<Integer>(list));	// complete a combination sum
		} else {
			for (int i = from; i <= 9; i++) {	// only numbers from 1 to 9 can be used
				list.add(i);
				dfs(k - 1, n - i, i + 1);	// i + 1: each combination should be a unique set of numbers
				list.remove(list.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSumIII_E216M obj = new CombinationSumIII_E216M();
		System.out.println(obj.combinationSum3(-1, 7));	// []
		System.out.println(obj.combinationSum3(0, 7));	// []
		System.out.println(obj.combinationSum3(3, -1));	// []
		System.out.println(obj.combinationSum3(3, 0));	// []
		
		System.out.println(obj.combinationSum3(3, 7));	// [[1, 2, 4]]
		System.out.println(obj.combinationSum3(3, 9));	// [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
		System.out.println(obj.combinationSum3(3, 1));	// []
	}
}

/**
 * LeetCode #216
 * Find all possible combinations of k numbers that add up to a number n, 
 *   given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
 * Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
