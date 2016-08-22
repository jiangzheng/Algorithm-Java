package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII_E229M_I47M {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return list;	// invalid input
		}
		
		int num1 = 0, num2 = 0; 
		int count1 = 0, count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count1 == 0) {
				num1 = nums[i];
				count1 = 1;
			} else if (count2 == 0 && num1 != nums[i]) {
				num2 = nums[i];
				count2 = 1;
			} else if (num1 == nums[i]) {
				count1++;
			} else if (num2 == nums[i]) {
				count2++;
			} else {	// if (num1 != nums[i] && num2 != nums[i])
				count1--;
				count2--;
			}
		}
		
		if (isOneThirdMajority(num1, nums)) {
			list.add(num1);
		}
		
		if (num1 != num2 && isOneThirdMajority(num2, nums)) {
			list.add(num2);
		}
		
		return list;
	}
	
	private boolean isOneThirdMajority(int val, int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				count++;
			}
		}
		
		if (count > nums.length / 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		MajorityElementII_E229M_I47M obj = new MajorityElementII_E229M_I47M();
		System.out.println(obj.majorityElement(null));	// []
		System.out.println(obj.majorityElement(new int[]{}));	// []
		
		int[] a = {1, 2, 3, 1, 1, 2, 4, 3};
		System.out.println(obj.majorityElement(a));	// [1]
	}
}

/**
 * LeetCode #229
 * LintCode #47
 * Given an integer array of size n, find all elements that appear more than floor(n/3) times. 
 * The algorithm should run in linear time and in O(1) space.
 * Hint: How many majority elements could it possibly have?
 */
