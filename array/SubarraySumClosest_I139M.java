package array;

import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest_I139M {
	/**
	 * Time: O(n log n); Space: O(1)
	 */
	public int[] subarraySumClosest(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;	// invalid input
		} 
		
		int[] result = new int[2];
		if (nums.length == 1) {
			result[0] = result[1] = 0;
			return result;
		}
		
		Pair[] sums = new Pair[nums.length + 1];
		int prev = 0;
		sums[0] = new Pair(0, 0);
		for (int i = 1; i <= nums.length; i++) {
			sums[i] = new Pair(prev + nums[i - 1], i);
			prev = sums[i].sum;
		}
		
		Arrays.sort(sums, new Comparator<Pair>() {
		   public int compare(Pair a, Pair b) {
			   return a.sum - b.sum;
		   } 
		});
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= nums.length; i++) {
			if (ans > sums[i].sum - sums[i - 1].sum) {
				ans = sums[i].sum - sums[i - 1].sum;
				int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
				Arrays.sort(temp);
				result[0] = temp[0] + 1;
				result[1] = temp[1];
			}
		}
		
		return result;
	}
	
	class Pair {
		int sum;
		int index;
		public Pair(int s, int i) {
			sum = s;
			index = i;
		}
	}
	
	public static void main(String[] args) {
		SubarraySumClosest_I139M obj = new SubarraySumClosest_I139M();
		System.out.println(obj.subarraySumClosest(null));	// null
		System.out.println(obj.subarraySumClosest(new int[]{}));	// null
		
		int[] a = {-3, 1, 1, -3, 5};
		int[] result = obj.subarraySumClosest(a);
		for (int x : result) {
			System.out.print(x + ", ");	// 1, 3, 
		}
	}
}

/**
 * LintCode #139
 * Given an integer array, find a subarray with sum closest to zero. 
 * Return the indexes of the first number and last number.
 * Example: Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
 * O(nlogn) time
 */
