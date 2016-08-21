package bit;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII_E260M_I84M {
	/**
	 * Bit manipulation.
	 * Time: O(n); Space: O(1)
	 */
	public List<Integer> singleNumber(int[] nums) {
		if (nums == null || nums.length < 4) {
			return null;	// invalid input
		}
		
		int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        
        int lastBit = xor - (xor & (xor - 1));
        int group0 = 0, group1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((lastBit & nums[i]) == 0) {
                group0 ^= nums[i];
            } else {
                group1 ^= nums[i];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(group0);
        result.add(group1);
        
        return result;
	}
	
	public static void main(String[] args) {
		SingleNumberIII_E260M_I84M obj = new SingleNumberIII_E260M_I84M();
		System.out.println(obj.singleNumber(null));	// null
		System.out.println(obj.singleNumber(new int[]{}));	// null
		
		int[] nums = {1, 2, 1, 3, 2, 5};
		System.out.println(obj.singleNumber(nums));	// [5, 3]
	}
}

/**
 * LeetCode #260
 * LintCode #84
 * Given an array of numbers nums, 
 *   in which exactly two elements appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.
 * For example: Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * - The order of the result is not important. So in the above example, [5, 3] is also correct.
 * - Your algorithm should run in linear runtime complexity. 
 *   Could you implement it using only constant space complexity?
 */
