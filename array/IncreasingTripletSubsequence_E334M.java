package array;

public class IncreasingTripletSubsequence_E334M {
	/**
	 * Use two variables to mark two smaller numbers.
	 * Time: O(n); Space: O(1)
	 */
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;	// invalid input
		}
		
		int smallNumber1 = Integer.MAX_VALUE;
		int smallNumber2 = Integer.MAX_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			if (smallNumber1 >= nums[i]) {
				smallNumber1 = nums[i];
			} else if (smallNumber2 >= nums[i]) {
				smallNumber2 = nums[i];
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		IncreasingTripletSubsequence_E334M obj = new IncreasingTripletSubsequence_E334M();
		System.out.println(obj.increasingTriplet(null));	// false
		System.out.println(obj.increasingTriplet(new int[]{}));	// false
		
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {5, 4, 3, 2, 1};
		int[] c = {1, 4, 3, 2, 3};
		System.out.println(obj.increasingTriplet(a));	// true
		System.out.println(obj.increasingTriplet(b));	// false
		System.out.println(obj.increasingTriplet(c));	// true
	}
}

/**
 * LeetCode #334
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 *   Return true if there exists i, j, k 
 *   such that arr[i] < arr[j] < arr[k] given 0 <= i < j < k <= n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Examples: Given [1, 2, 3, 4, 5], return true. Given [5, 4, 3, 2, 1], return false.
 */
