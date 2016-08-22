package array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_E179M_I184M {
	/**
	 * Time: O(n log n); Space: O(n) 
	 */
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;	// invalid input
		}
		
		String[] numStr = new String[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			numStr[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(numStr, comparator);
		
		StringBuilder sb = new StringBuilder();
		
		// append sb from right to left
		for (int i = nums.length - 1; i >= 0; i--) {
			sb.append(numStr[i]);
		}
		
		// delete leading zeros
		int pointer = 0;
		while (pointer < sb.length() - 1 && sb.charAt(pointer) == '0') {
			pointer++;
		}
		
		return sb.substring(pointer);
	}
	
	public Comparator<String> comparator = new Comparator<String>() {
		public int compare(String a, String b) {
			String ab = a + b, ba = b + a;
			for (int i = 0; i < ab.length(); i++) {
				char c1 = ab.charAt(i), c2 = ba.charAt(i);
				if (c1 < c2) {
					return -1;
				} else if (c1 > c2) {
					return 1;
				}
			}
			
			return 0;
		}
	};
	
	public static void main(String[] args) {
		LargestNumber_E179M_I184M obj = new LargestNumber_E179M_I184M();
		System.out.println(obj.largestNumber(null));	// null
		System.out.println(obj.largestNumber(new int[]{}));	// null
		
		int[] a = {3, 30, 34, 5, 9};
		System.out.println(obj.largestNumber(a));	// 9534330
	}
}

/**
 * LeetCode #179
 * LintCode #184
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
