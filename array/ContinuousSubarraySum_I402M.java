package array;

import java.util.ArrayList;

public class ContinuousSubarraySum_I402M {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public ArrayList<Integer> continuousSubarraySum(int[] A) {
		if (A == null || A.length == 0) {
			return null;	// invalid input
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(0);
		
		int start = 0, end = 0;
		int sum = 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; ++i) {
			if (sum < 0) {
				sum = A[i];
				start = end = i;
			} else {
				sum += A[i];
				end = i;
			}
			if (sum >= ans) {
				ans = sum;
				list.set(0, start);
				list.set(1, end);
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		ContinuousSubarraySum_I402M obj = new ContinuousSubarraySum_I402M();
		System.out.println(obj.continuousSubarraySum(null));	// null
		System.out.println(obj.continuousSubarraySum(new int[]{}));	// null
		
		int[] a = {-3, 1, 3, -3, 4};
		System.out.println(obj.continuousSubarraySum(a));	// [1, 4]
	}
}

/**
 * LintCode #402
 * Given an integer array, find a continuous subarray where the sum of numbers is the biggest. 
 * Your code should return the index of the first number and the index of the last number. 
 * (If their are duplicate answer, return anyone)
 * Example, Give [-3, 1, 3, -3, 4], return [1,4].
 */
