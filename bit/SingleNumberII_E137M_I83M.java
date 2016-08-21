package bit;

import java.util.Arrays;

public class SingleNumberII_E137M_I83M {
	/**
	 * State Machine + Bit Manipulation.
	 * Time: O(n); Space: O(1)
	 */
	public int singleNumber1(int[] nums) {
		if (nums == null || nums.length < 4) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int x0 = ~0, x1 = 0, x2 = 0, temp;
		
		for (int i = 0; i < nums.length; i++) {
			temp = x2;
			x2 = (x1 & nums[i]) | (x2 & ~nums[i]);
			x1 = (x0 & nums[i]) | (x1 & ~nums[i]);
			x0 = (temp & nums[i]) | (x0 & ~nums[i]);
		}
		
		return x1;
	}
	
	/**
	 * Bit Manipulation.
	 * Time: O(32n); Space: O(1)
	 */
	public int singleNumber2(int[] nums) {
		if (nums == null || nums.length < 4) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int[] count = new int[32];	// 32-bit integer
		Arrays.fill(count, 0);
		
		int result = 0;
		for (int i = 0; i < 32; i++) {	// 1st loop must be bit: otherwise count % 3 will not be 0 or 1
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					count[i]++;
				}
			}
			result |= ((count[i] % 3) << i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		SingleNumberII_E137M_I83M obj = new SingleNumberII_E137M_I83M();
		System.out.println(obj.singleNumber1(null));	// -2147483648
		System.out.println(obj.singleNumber2(null));	// -2147483648
		System.out.println(obj.singleNumber1(new int[]{}));	// -2147483648
		System.out.println(obj.singleNumber2(new int[]{}));	// -2147483648
		
		int[] a = {7, 8, 8, 7, 9, 8, 7};
		System.out.println(obj.singleNumber1(a));	// 9
		System.out.println(obj.singleNumber2(a));	// 9
	}
}

/**
 * LeetCode #137
 * LintCode #83
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 */
