package string;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber_E246E {
	/**
	 * Use Map and two pointers to compare characters from two ends to middle.
	 * Time: O(n); Space: O(1)
	 */
	public boolean isStrobogrammatic(String num) {
		if (num == null || num.length() == 0) {
			return true;	// invalid input
		}
		
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		
		int left = 0, right = num.length() - 1;
		
		while (left <= right) {
			if (!map.containsKey(num.charAt(left)) || map.get(num.charAt(left)) != num.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		StrobogrammaticNumber_E246E obj = new StrobogrammaticNumber_E246E();
		System.out.println(obj.isStrobogrammatic(null));	// true
		System.out.println(obj.isStrobogrammatic(""));	// true
		
		System.out.println(obj.isStrobogrammatic("69"));	// true
		System.out.println(obj.isStrobogrammatic("88"));	// true
		System.out.println(obj.isStrobogrammatic("818"));	// true
		System.out.println(obj.isStrobogrammatic("6969"));	// true
		System.out.println(obj.isStrobogrammatic("6600099"));	// true
		
		System.out.println(obj.isStrobogrammatic("6996"));	// false
		System.out.println(obj.isStrobogrammatic("68289"));	// false
	}
}

/**
 * LeetCode #246
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
