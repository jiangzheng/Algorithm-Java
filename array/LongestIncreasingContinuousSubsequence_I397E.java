package array;

public class LongestIncreasingContinuousSubsequence_I397E {
	/**
	 * Two counters.
	 * Time: O(n); Space: O(1)
	 */
	public int longestIncreasingContinuousSubsequence(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		if (A.length == 1) {
			return 1;
		}
		
		int counter1 = 1, counter2 = 1, max = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i + 1] >= A[i]) {
				counter2 = 1;
				max = Math.max(max, ++counter1);
			} else {
				counter1 = 1;
				max = Math.max(max, ++counter2);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		LongestIncreasingContinuousSubsequence_I397E obj = new LongestIncreasingContinuousSubsequence_I397E();
		System.out.println(obj.longestIncreasingContinuousSubsequence(null));	// 0
		System.out.println(obj.longestIncreasingContinuousSubsequence(new int[]{}));	// 0
		
		int[] a = {5, 4, 2, 1, 3};
		int[] b = {5, 1, 2, 3, 4};
		System.out.println(obj.longestIncreasingContinuousSubsequence(a));	// 4
		System.out.println(obj.longestIncreasingContinuousSubsequence(b));	// 4
	}
}

/**
 * LintCode #397
 * Give an integer array, find the longest increasing continuous subsequence in this array.
 * An increasing continuous subsequence:
 * - Can be from right to left or from left to right.
 * - Indices of the integers in the subsequence should be continuous.
 * Notice: O(n) time and O(1) extra space.
 * Example: For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 */
