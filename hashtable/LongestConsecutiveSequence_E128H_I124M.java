package hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_E128H_I124M {
	/**
	 * Time: O(n); Space: O(n) 
	 */
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;	// invalid input
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		
		int maxLength = 0;
		for (int i : nums) {
			int len = 1;
			for (int j = i + 1; set.contains(j); j++) {
				len++;
				set.remove(j);
			}
			for (int j = i - 1; set.contains(j); j--) {
				len++;
				set.remove(j);
			}
			set.remove(i);
			maxLength = Math.max(maxLength, len);
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		LongestConsecutiveSequence_E128H_I124M obj = new LongestConsecutiveSequence_E128H_I124M();
		System.out.println(obj.longestConsecutive(null));	// -1
		System.out.println(obj.longestConsecutive(new int[]{}));	// -1
		
		int[] a = {100, 4, 200, 1, 3, 2};
		System.out.println(obj.longestConsecutive(a));
	}
}

/**
 * LeetCode #128
 * LintCode #124
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, Given [100, 4, 200, 1, 3, 2], 
 *   the longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */
