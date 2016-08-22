package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MajorityNumberIII_I48M {
	/**
	 * Time: O(n); Space: O(k)
	 */
	public int majorityNumber(ArrayList<Integer> nums, int k) {
		if (nums == null || nums.size() == 0 || k < 1) {
			return Integer.MIN_VALUE;	// invalid input
		}
				
		// count at most k keys.
		HashMap<Integer, Integer> counters = new HashMap<Integer, Integer>();
		for (Integer i : nums) {
			if (!counters.containsKey(i)) {
				counters.put(i, 1);
			} else {
				counters.put(i, counters.get(i) + 1);
			}
			
			if (counters.size() >= k) {
				removeKey(counters);
			}
		}
		
		// corner case
		if (counters.size() == 0) {
			return Integer.MIN_VALUE;
		}
		
		// recalculate counters
		for (Integer i : counters.keySet()) {
			counters.put(i, 0);
		}
		for (Integer i : nums) {
			if (counters.containsKey(i)) {
				counters.put(i, counters.get(i) + 1);
			}
		}
		
		// find the max key
		int maxCounter = 0, maxKey = 0;
		for (Integer i : counters.keySet()) {
			if (counters.get(i) > maxCounter) {
				maxCounter = counters.get(i);
				maxKey = i;
			}
		}
		
		return maxKey;
	}
	
	private void removeKey(HashMap<Integer, Integer> counters) {
		Set<Integer> keySet = counters.keySet();
		List<Integer> removeList = new ArrayList<>();
		for (Integer key : keySet) {
			counters.put(key, counters.get(key) - 1);
			if (counters.get(key) == 0) {
				removeList.add(key);
			}
		}
		for (Integer key : removeList) {
			counters.remove(key);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {3, 1, 2, 3, 2, 3, 3, 4, 4, 4};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int x : a) {
			list.add(x);
		}
		
		MajorityNumberIII_I48M obj = new MajorityNumberIII_I48M();
		System.out.println(obj.majorityNumber(null, 3));	// -2147483648
		System.out.println(obj.majorityNumber(new ArrayList<Integer>(), 3));	// -2147483648
		System.out.println(obj.majorityNumber(list, 0));	// -2147483648
						
		System.out.println(obj.majorityNumber(list, 3));	// 3
	}
}

/**
 * LintCode #48
 * Given an array of integers and a number k, 
 *   the majority number is the number that occurs more than 1/k of the size of the array.
 * Find it.
 * There is only one majority number in the array.
 * Example, Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
 * O(n) time and O(k) extra space
 */
