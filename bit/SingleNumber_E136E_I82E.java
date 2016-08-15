package bit;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber_E136E_I82E {
	/**
	 * Use XOR, same numbers would be cancelled to 0, only the single one would not be cancelled.
	 * Time: O(n); Space: O(1)
	 */
	public int singleNumber1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int result = 0;
		
		for (int number : nums) {
			result ^= number;
		}
		
		return result;
	}

	/**
	 * Use HashSet.
	 * Time: O(n); Space: O(n)
	 */
	public int singleNumber2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (int number : nums) {
			if (set.contains(number)) {
				set.remove(number);	// cancel the duplicated numbers
			} else {
				set.add(number);
			}
		}
		
		return set.iterator().next();
	}
	
	public static void main(String[] args) {
		SingleNumber_E136E_I82E obj = new SingleNumber_E136E_I82E();
		System.out.println(obj.singleNumber1(null));	// -2147483648
		System.out.println(obj.singleNumber2(null));	// -2147483648
		System.out.println(obj.singleNumber1(new int[]{}));	// -2147483648
		System.out.println(obj.singleNumber2(new int[]{}));	// -2147483648
		
		int[] a = {1, 4, 5, 1, 3, 2, 5, 3, 4};
		int[] b = {1, 2, 2, 1, 3, 4, 3};
		System.out.println(obj.singleNumber1(a));	// 2
		System.out.println(obj.singleNumber2(a));	// 2
		System.out.println(obj.singleNumber1(b));	// 4
		System.out.println(obj.singleNumber2(b));	// 4
	}
}

/**
 * LeetCode #136
 * LintCode #82
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it. e.g., Given [1,2,2,1,3,4,3], return 4
 */
