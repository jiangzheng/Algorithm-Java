package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_E347M {
	/**
	 * Bucket Sort.
	 * Time: O(n); Space: O(n)
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
			return null;	// invalid input
		}
		
		// save the frequency for each distinct number
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();	// <number, frequency>
		int max = 0;
		for (int n : nums) {
			if (!map.containsKey(n)) {
				map.put(n, 1);
			} else {
				map.put(n, map.get(n) + 1);
			}
			max = Math.max(max, map.get(n));	// get max frequency
		}
	 
		// index - frequency, value - list of numbers with this frequency 
		List<Integer>[] array = (ArrayList<Integer>[]) new ArrayList[max + 1];	// from 1 to max
		for(int i = 1; i <= max; i++){
			array[i] = new ArrayList<Integer>();
		}
	 
		for (Map.Entry<Integer, Integer> entry : map.entrySet()){
			array[entry.getValue()].add(entry.getKey());
		}
	 
		// add most frequent numbers to result list, stop when the size of list reaches k
		List<Integer> list = new ArrayList<Integer>();
		for (int i = max; i >= 1; i--){
			if (array[i].size() > 0) {
				for (int n: array[i]) {
					list.add(n);
				}
			}
			if (list.size() == k) {
				break;
			}
		}
	 
		return list;
	}
	
	public static void main(String[] args) {
		TopKFrequentElements_E347M obj = new TopKFrequentElements_E347M();
		int[] a = {1, 2, 1, 3, 2, 1};
		System.out.println(obj.topKFrequent(null, 2));	// null
		System.out.println(obj.topKFrequent(new int[]{}, 2));	// null
		System.out.println(obj.topKFrequent(a, 0));	// null
		System.out.println(obj.topKFrequent(a, 7));	// null
		
		System.out.println(obj.topKFrequent(a, 2));	// [1, 2]
	}
}

/**
 * LeetCode #347
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note: You may assume k is always valid, 1 <= k <= number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
