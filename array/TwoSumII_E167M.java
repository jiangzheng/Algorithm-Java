package array;

public class TwoSumII_E167M {
	/**
	 * Two pointers squeeze from two ends.
	 * Time: O(n); Space: O(1)
	 */
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;	// invalid input
		}
		
		int low = 0, high = numbers.length - 1;
		while (low < high) {
			int sum = numbers[low] + numbers[high];
			if (sum > target) {
				high--;
			} else if (sum < target) {
				low++;
			} else {
				return new int[] {low + 1, high + 1};	// not zero-based
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		TwoSumII_E167M obj = new TwoSumII_E167M();
		System.out.println(obj.twoSum(null, 312));	// null
		System.out.println(obj.twoSum(new int[]{}, 312));	// null
		
		int[] a = {1, 2, 12, 50, 300};
		int[] result = obj.twoSum(a, 312);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");	// 3, 5, 
		}
	}
}

/**
 * LeetCode #167
 * Given an array of integers that is already sorted in ascending order, 
 *   find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 *   where index1 must be less than index2. 
 *   Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 */
