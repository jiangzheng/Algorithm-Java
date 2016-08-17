package tree;

import java.util.ArrayList;
import java.util.List;

public class Combinations_E77M_I152M {
	/**
	 * DFS recursion, backtracking.
	 * Time: O(n!); Space: O(n)
	 */
	private List<List<Integer>> listList;
	private List<Integer> list;
	
	public List<List<Integer>> combine(int n, int k) {
		listList = new ArrayList<List<Integer>>();
		list = new ArrayList<>();
		
		if (n < 0 || k < 0 || n < k) {
			return null;	// invalid input
		}
		
		dfs(n, k, 1);
		
		return listList;
	}
	
	private void dfs(int n, int k, int from) {
		if (list.size() == k) {
			listList.add(new ArrayList<Integer>(list));	// complete a combination
		} else {
			for (int i = from; i <= n; i++) {
				list.add(i);
				dfs(n, k, i + 1);
				list.remove(list.size() - 1);	// backtrack: remove the last element, then probe another branch of the tree
			}
		}
	}
	
	public static void main(String[] args) {
		Combinations_E77M_I152M obj = new Combinations_E77M_I152M();
		System.out.println(obj.combine(-1, -1));	// null
		System.out.println(obj.combine(-1, 2));	// null
		System.out.println(obj.combine(4, -1));	// null
		System.out.println(obj.combine(2, 3));	// null

		System.out.println(obj.combine(0, 0));	// [[]]
		System.out.println(obj.combine(2, 0));	// [[]]
		
		System.out.println(obj.combine(3, 1));	// [[1], [2], [3]]
		System.out.println(obj.combine(4, 2));	// [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
		System.out.println(obj.combine(5, 4));	// [[1, 2, 3, 4], [1, 2, 3, 5], [1, 2, 4, 5], [1, 3, 4, 5], [2, 3, 4, 5]]
	}
}

/**
 * LeetCode #77
 * LintCode #152
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example, if n = 4 and k = 2, a solution is: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4] ]
 */
