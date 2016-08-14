package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_E15M_I57M {
	/**
	 * Two pointers squeeze from two ends.
	 * Time: O(n^2); Space: O(1)
	 */
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();		
		if (num == null || num.length < 3) {
			return listList;	// invalid input
		}		
		
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 2; i = increment(num, i)) {
			int low = i + 1, high = num.length - 1;
			
			while (low < high) {
				int sum = num[i] + num[low] + num[high];
				if (sum == 0) {
					List<Integer> list = Arrays.asList(num[i], num[low], num[high]);
					listList.add(list);				 
					low = increment(num, low);	// low++
					high = decrement(num, high);	// high--
				} else if (sum > 0) {
					high = decrement(num, high);	// high--
				} else if (sum < 0) {
					low = increment(num, low);	// low++
				}
			}
		}
		
		return listList;
	}
	
	private int increment(int[] num, int low) {
		while (low < num.length - 1 && num[low] == num[++low]) {	// find next low position
		}
		return low;
	}
		
	private int decrement(int[] num, int high) {
		while (high > 0 && num[high] == num[--high]) {	// find previous high position
		}
		return high;
	}
	
	public static void main(String[] args) {
		ThreeSum_E15M_I57M obj = new ThreeSum_E15M_I57M();
		System.out.println(obj.threeSum(null));	// []
		System.out.println(obj.threeSum(new int[]{}));	// []
		
		int[] a = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> listList = obj.threeSum(a);
		for (List<Integer> list : listList) {
			System.out.print(list + ", ");	// [-1, -1, 2], [-1, 0, 1], 
		}
	}
}

/**
 * LeetCode #15
 * LintCode #57
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (i.e., a <= b <= c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is: (-1, 0, 1) (-1, -1, 2)
 */
