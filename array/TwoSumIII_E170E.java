package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII_E170E {
	/**
	 * Use HashMap to store <number, count>.
	 * Time: add: O(1), find: O(n); Space: O(n)
	 */
	private Map<Integer, Integer> map = new HashMap<>();
	
	public void add(int number) {
		int count = map.containsKey(number) ? map.get(number) : 0;
		map.put(number, count + 1);	// Add/update the corresponding count in the HashMap
	}

	public boolean find(int value) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();	// get the number
			int diff = value - num;
			if (diff == num) {
				if (entry.getValue() >= 2) {	// count >= 2, can square
					return true;
				}
			} else if (map.containsKey(diff)) {	// has solution
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		TwoSumIII_E170E obj = new TwoSumIII_E170E();
		obj.add(1); obj.add(3); obj.add(5);
		System.out.println(obj.find(4));	// true
		System.out.println(obj.find(7));	// false
	}
}

/**
 * LeetCode #170
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * - add - Add the number to an internal data structure.
 * - find - Find if there exists any pair of numbers which sum is equal to the value.
 * For example, add(1); add(3); add(5); find(4) -> true; find(7) -> false
 */
