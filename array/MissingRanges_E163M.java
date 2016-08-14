package array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_E163M {
	/**
	 * Use two pointers.
	 * Time: O(n); Space: O(1) 
	 */
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> list = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		
		int from = lower - 1;
		
		for (int i = 0; i <= nums.length; i++) {
			int to = (i == nums.length) ? upper + 1 : nums[i];
			if (to - from > 1) {	// gap > 1
				list.add(printRange(from + 1, to - 1));	// add range in between
			}
			from = to;
		}
		
		return list;
	}
	
	private String printRange(int from, int to) {
		return (from == to) ? from + "" : from + "->" + to;
	}

	public static void main(String[] args) {
		MissingRanges_E163M obj = new MissingRanges_E163M();
		System.out.println(obj.findMissingRanges(null, 0, 99));	// []
		System.out.println(obj.findMissingRanges(new int[]{}, 0, 99));	// []
		
		int a[] = {0, 1, 3, 50, 75};
		System.out.println(obj.findMissingRanges(a, 0, 99));	// [2, 4->49, 51->74, 76->99]
	}
}

/**
 * LeetCode #163
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
