package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_E40M_I153M {
	/**
	 * DFS recursion, backtracking.
	 * Time: O(n!); Space: O(n)
	 */
	private List<List<Integer>> listList;
	private List<Integer> list;
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
				dfs(candidates, target - candidates[i], i + 1);   // i + 1: avoid pick used number again
				list.remove(list.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSumII_E40M_I153M obj = new CombinationSumII_E40M_I153M();
		System.out.println(obj.combinationSum2(null, 8));	// []
		System.out.println(obj.combinationSum2(new int[]{}, 8));	// []
		
		int[] a = {10, 1, 2, 7, 6, 1, 5};
		System.out.println(obj.combinationSum2(a, 8));	// [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
		System.out.println(obj.combinationSum2(a, 17));	// [[1, 1, 2, 6, 7], [1, 1, 5, 10], [1, 6, 10], [2, 5, 10], [7, 10]]
		System.out.println(obj.combinationSum2(a, 0));	// [[]]
	}
}

/**
 * LeetCode #40
 * LintCode #153
 * Given a collection of candidate numbers (C) and a target number (T), 
 *   find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note: All numbers (including target) will be positive integers.
 *       Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (i.e., a1 <= a2 <= ... <= ak).
 *       The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, a solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */
