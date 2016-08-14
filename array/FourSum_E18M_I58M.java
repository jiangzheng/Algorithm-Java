package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_E18M_I58M {
	/**
	 * Two pointers squeeze from two ends.
	 * Time: O(n^3); Space: O(1)
	 */
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		if (num == null || num.length < 4) {
			return listList;	// invalid input
		}
		
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 3; i = increment(num, i)) {
			for (int j = i + 1; j < num.length - 2; j = increment(num, j)) {	// two layers of for loops
				int low = j + 1, high = num.length - 1;
				
				while (low < high) {
					int sum = num[i] + num[j] + num[low] + num[high];
					if (sum == target) {
						listList.add(Arrays.asList(num[i], num[j], num[low], num[high]));
						low = increment(num, low);	// low++
						high = decrement(num, high);	// high--
					} else if (sum < target) {
						low = increment(num, low);	// low++
					} else {
						high = decrement(num, high);	// high--
					}
				}
			}
		}
		
		return listList;
	}
	
	private int increment(int[] num, int low) {
		while (low < num.length - 1 && num[low] == num[++low]) {
		}
		return low;
	}
		
	private int decrement(int[] num, int high) {
		while (high > 0 && num[high] == num[--high]) {
		}
		return high;
	}
	
	public static void main(String[] args) {
		FourSum_E18M_I58M obj = new FourSum_E18M_I58M();
		System.out.println(obj.fourSum(null, 0));	// []
		System.out.println(obj.fourSum(new int[]{}, 0));	// []
		
		int[] a = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> listList = obj.fourSum(a, 0);
		for (List<Integer> list : listList) {
			System.out.print(list + ", ");	// [-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1], 
		}
	}
}

/**
 * LeetCode #18
 * LintCode #58
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order. (i.e., a <= b <= c <= d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 */
