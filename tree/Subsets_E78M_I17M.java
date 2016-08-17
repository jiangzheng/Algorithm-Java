package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_E78M_I17M {
	/**
	 * DFS recursion, backtracking.
	 * Time: O(n!); Space: O(n)
	 */
	private List<List<Integer>> listList;
	private List<Integer> list;
	
	public List<List<Integer>> subsets(int[] nums) {
		listList = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>();
		
		if (nums == null) {
			return null;	// invalid input
		}
		
		Arrays.sort(nums);	// sort the array first
		dfs(nums, 0);
		
		return listList;
	}
	
	private void dfs(int[] nums, int from) {
		listList.add(new ArrayList<Integer>(list));	// each call completes a subset
		for (int i = from; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(nums, i + 1);
			list.remove(list.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
		}
	}
	
	public static void main(String[] args) {
		Subsets_E78M_I17M obj = new Subsets_E78M_I17M();
		System.out.println(obj.subsets(null));	// null
		System.out.println(obj.subsets(new int[]{}));	// [[]]
		
		int[] a = {1, 2, 3};
		System.out.println(obj.subsets(a));	// [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
	}
}

/**
 * LeetCode #78
 * LintCode #17
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example, if nums = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
