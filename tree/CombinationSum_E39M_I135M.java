package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_E39M_I135M {
	/**
	 * DFS recursion, backtracking.
	 * Time: O(n!); Space: O(n)
	 */
	private List<List<Integer>> listList;
	private List<Integer> list;
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		listList = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>();
		
		if (candidates == null || candidates.length == 0) {
			return listList;	// invalid input
		}
				
		Arrays.sort(candidates);	// sort the array first
		dfs(candidates, target, 0);
		
		return listList;
	}
	
	private void dfs(int[] candidates, int target, int from) {
		if (target < 0) {	// no combination sum
			return;
		} else if (target == 0) {
			listList.add(new ArrayList<Integer>(list));	// complete a combination sum
		} else {
			for (int i = from; i < candidates.length && candidates[i] <= target; i++) {	// skip if candidates[i] > target
				if (i > from && candidates[i] == candidates[i - 1]) {
					continue;	// skip the duplicated elements, avoid duplicated list
				}
				list.add(candidates[i]);
				dfs(candidates, target - candidates[i], i);	// i: a number may be used any times
				list.remove(list.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSum_E39M_I135M obj = new CombinationSum_E39M_I135M();
		System.out.println(obj.combinationSum(null, 7));	// []
		System.out.println(obj.combinationSum(new int[]{}, 7));	// []
		
		int[] a = {2, 3, 6, 7};
		System.out.println(obj.combinationSum(a, 7));	// [[2, 2, 3], [7]]
		System.out.println(obj.combinationSum(a, 8));	// [[2, 2, 2, 2], [2, 3, 3], [2, 6]]
		System.out.println(obj.combinationSum(a, 1));	// []
	}
}

/**
 * LeetCode #39
 * LintCode #135
 * Given a set of candidate numbers (C) and a target number (T), 
 *   find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note: All numbers (including target) will be positive integers.
 *       Elements in a combination (a1, a2, … , ak) must be in non-descending order. (i.e., a1 <= a2 <= ... <= ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, a solution set is: [7], [2, 2, 3] 
 */

/**
 * 1. Sort the candidate array first so as to generate non-descending order results.
 * 2. If target > 0, recursively call:
 *	addUp(candidate, i, target - candidate[i]), i = start ... N - 1
 *	If target == 0, a combination is found, and add list to listList.
 *	If target < 0, a combination is not found, just return and remove previous added element.
 * 3. Avoid duplicated combinations (two ways):
 *	skip candidate[i] if candidate[i] == candidate[i - 1], i > start; (Backtracking)
 *	don't add the list if listList.contains(list). (DFS)
 */

