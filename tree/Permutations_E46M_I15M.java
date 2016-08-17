package tree;

import java.util.ArrayList;
import java.util.List;

public class Permutations_E46M_I15M {
	/**
	 * DFS recursion, backtracking.
	 * Time: O(n!); Space: O(n)
	 */
	private List<List<Integer>> listList;
	private List<Integer> list;

	public List<List<Integer>> permute(int[] num) {
		listList = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>();
		
		if (num == null || num.length == 0) {
			return listList;	// invalid input
		}
		
		dfs(num);
		
		return listList;
	}

	private void dfs(int[] num) {
		if (list.size() == num.length) {
			listList.add(new ArrayList<Integer>(list));	// complete a permutation
		} else {
			for (int n : num) {
				if (!list.contains(n)) {	// if list contains n, just skip
					list.add(n);
					dfs(num);
					list.remove(list.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
				}
			}
		}
	}
	
	/**
	 * LintCode version.
	 */
	private ArrayList<ArrayList<Integer>> listList2;
	private ArrayList<Integer> list2;
	
	public ArrayList<ArrayList<Integer>> permute2(ArrayList<Integer> nums) {
		listList2 = new ArrayList<ArrayList<Integer>>();
		list2 = new ArrayList<Integer>();
		
		if (nums == null || nums.size() == 0) {
			return listList2;	// invalid input
		}
		
		dfs2(nums);
		
		return listList2;
	}
	
	private void dfs2(ArrayList<Integer> nums) {
		if (list2.size() == nums.size()) {
			listList2.add(new ArrayList<Integer>(list2));	// complete a permutation
		} else {
			for (int i = 0; i < nums.size(); i++) {
				if (!list2.contains(nums.get(i))) {	// if list contains n, just skip
					list2.add(nums.get(i));
					dfs2(nums);
					list2.remove(list2.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
				}
			}
		}
	}

	
	public static void main(String[] args) {
		Permutations_E46M_I15M obj = new Permutations_E46M_I15M();
		System.out.println(obj.permute(null));	// []
		System.out.println(obj.permute2(null));	// []
		System.out.println(obj.permute(new int[]{}));	// []
		System.out.println(obj.permute2(new ArrayList<Integer>()));	// []
		
		// LeetCode version
		int[] a = {1, 2, 3};
		System.out.println(obj.permute(a));	// [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
		
		// LintCode version
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(1); b.add(2); b.add(3); 
		System.out.println(obj.permute2(b));	// [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
	}
}

/**
 * LeetCode #46
 * LintCode #15
 * Given a collection of numbers, return all possible permutations.
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

/**
 * Call nextPermutation()
 * Time: O(N!*N), Extra Space: O(1)
 */
/*
public List<List<Integer>> permute1(int[] nums) {
	List<List<Integer>> listList = new ArrayList<List<Integer>>();  
	_31_NextPermutation obj = new _31_NextPermutation();
	
	// compute (num.length)!
	int factorial = 1;
	for (int i = 1; i <= nums.length; i++)
		factorial *= i;

	int[] perm = Arrays.copyOf(nums, nums.length);
	// generate all permutations
	for (int i = 0; i < factorial; i++) {
		obj.nextPermutation(perm);
		List<Integer> list = new ArrayList<>();
		for (int k : perm)  list.add(k);
		//// if (!listList.contains(list))	// No need to check duplicate lists!!	
			listList.add(list);
	}
	
	return listList;
}
*/
