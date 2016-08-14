package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_E228E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public List<String> summaryRanges(int[] nums) {
		List<String> ranges = new ArrayList<String>();
		
		for (int i = 0; i < nums.length; i++) {
			int from = nums[i];
			while ((i < nums.length - 1) && (nums[i + 1] == nums[i] + 1)) {
				i++;
			}
			ranges.add((from == nums[i]) ? from + "" : from + "->" + nums[i]);
		}

		return ranges;
	}
	
	public static void main(String[] args) {
		SummaryRanges_E228E obj = new SummaryRanges_E228E();
		int[] nums = {0, 1, 2, 4, 5, 7};
		System.out.println(obj.summaryRanges(nums));	// [0->2, 4->5, 7]
	}
}

/**
 * LeetCode #228
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
