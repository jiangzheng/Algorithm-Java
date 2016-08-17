package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII_E47H_I16M {
	/**
	 * DFS recursion, backtracking.
	 * Time: O(n!); Space: O(n)
	 */
	private List<List<Integer>> listList;
	private List<Integer> list;
	private Set<Integer> visited = new HashSet<>();	// store visited index

	public List<List<Integer>> permuteUnique(int[] num) {
		listList = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>();
		
		if (num == null || num.length == 0) {
			return listList;
		}
		
		Arrays.sort(num);	// sort the array first
		dfs(num);
		
		return listList;
	}

	private void dfs(int[] num) {
		if (list.size() == num.length) {
			listList.add(new ArrayList<Integer>(list));	// complete a permutation
		} else {
			for (int i = 0; i < num.length; i++) {
				if (i > 0 && !visited.contains(i - 1) && num[i - 1] == num[i]) {	// see if adjacent elements are the same
					continue;	// skip the duplicated elements
				}
				if (!visited.contains(i)) {	// if visited contains i, just skip
					list.add(num[i]);
					visited.add(i);
					dfs(num);
					list.remove(list.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
					visited.remove(i);
				}
			}
		}
	}
	
	/**
	 * LintCode version.
	 */
	private ArrayList<ArrayList<Integer>> listList2;
	private ArrayList<Integer> list2;
	private Set<Integer> visited2;
	
	public ArrayList<ArrayList<Integer>> permuteUnique2(ArrayList<Integer> nums) {
		listList2 = new ArrayList<ArrayList<Integer>>();
		list2 = new ArrayList<Integer>();
		visited2 = new HashSet<Integer>();	// store visited index
		
		if (nums == null || nums.size() == 0) {
			return listList2;
		}
		
		Collections.sort(nums);	// sort the array list first
		dfs(nums);
		
		return listList2;
	}
	
	private void dfs(ArrayList<Integer> nums) {
		if (nums.size() == list2.size()) {
			listList2.add(new ArrayList<Integer>(list2));	// complete a permutation
		} else {
			for (int i = 0; i < nums.size(); i++) {
				if (i > 0 && !visited2.contains(i - 1) && nums.get(i - 1) == nums.get(i)) {	// see if adjacent elements are the same
					continue;
				}
				if (!visited2.contains(i)){	// if visited contains i, just skip
					list2.add(nums.get(i));
					visited2.add(i);
					dfs(nums);
					list2.remove(list2.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
					visited2.remove(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PermutationsII_E47H_I16M obj = new PermutationsII_E47H_I16M();
		System.out.println(obj.permuteUnique(null));	// []
		System.out.println(obj.permuteUnique2(null));	// []
		System.out.println(obj.permuteUnique(new int[]{}));	// []
		System.out.println(obj.permuteUnique2(new ArrayList<Integer>()));	// []
		
		// LeetCode version
		int[] a = {1, 1, 2};
		System.out.println(obj.permuteUnique(a));	// [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
		
		// LintCode version
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(1); b.add(1); b.add(2); 
		System.out.println(obj.permuteUnique2(b));	// [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
	}
}

/**
 * LeetCode #47
 * LintCode #16
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example, [1,1,2] have the following unique permutations: [1,1,2], [1,2,1], and [2,1,1].
 */
