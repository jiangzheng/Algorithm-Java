package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII_E90M_I18M {
	/**
	 * DFS recursion, backtracking.
	 * Time: O(n!); Space: O(n)
	 */
	private List<List<Integer>> listList;
	private List<Integer> list;
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
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
			if (i > from && nums[i - 1] == nums[i]) {
				continue;	// skip the duplicated elements
			}
			list.add(nums[i]);
			dfs(nums, i + 1);
			list.remove(list.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
		}
	}
	
	/**
	 * LintCode version.
	 */
    private ArrayList<ArrayList<Integer>> listList2;
    private ArrayList<Integer> list2;
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup2(ArrayList<Integer> nums) {
        listList2 = new ArrayList<ArrayList<Integer>>();
        list2 = new ArrayList<Integer>();
        
        if (nums == null) {
            return null;	// invalid input
        }
        
        Collections.sort(nums);	// sort the array list first
        dfs(nums, 0);
        
        return listList2;
    }
    
    private void dfs(ArrayList<Integer> S, int from) {
        listList2.add(new ArrayList<Integer>(list2));	// each call completes a subset
        for (int i = from; i < S.size(); i++) {
            if (i > from && S.get(i - 1) == S.get(i)) {
                continue;	// skip the duplicated elements
            }
            list2.add(S.get(i));
            dfs(S, i + 1);
            list2.remove(list2.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
        }
    }
	
	
	public static void main(String[] args) {
		SubsetsII_E90M_I18M obj = new SubsetsII_E90M_I18M();
		System.out.println(obj.subsetsWithDup(null));	// null
		System.out.println(obj.subsetsWithDup2(null));	// null
		System.out.println(obj.subsetsWithDup(new int[]{}));	// [[]]
		System.out.println(obj.subsetsWithDup2(new ArrayList<Integer>()));	// [[]]
		
		// LeetCode version
		int[] a = {1, 2, 2};
		System.out.println(obj.subsetsWithDup(a));	// [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
		
		// LintCode version
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(1); b.add(2); b.add(2); 
		System.out.println(obj.subsetsWithDup2(b));	// [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]

	}
}

/**
 * LeetCode #90
 * LintCode #18
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.
 * For example, if nums = [1,2,2], a solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
