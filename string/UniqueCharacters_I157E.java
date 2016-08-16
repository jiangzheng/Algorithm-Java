package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters_I157E {
	/**
	 * Do not use additional data structures.
	 * Time: O(n^2); Space: O(1)
	 */
	public boolean isUnique1(String str) {
		if (str == null || str.length() == 0) {
			return false;	// invalid input
		}
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Utilize HashSet which does not allow duplication.
	 * Time: O(n); Space: O(n)
	 */
	public boolean isUnique2(String str) {
		if (str == null || str.length() == 0) {
			return false;	// invalid input
		}
		
		Set<Character> set = new HashSet<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i))){
				return false;
			} else {
				set.add(str.charAt(i));
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		UniqueCharacters_I157E obj = new UniqueCharacters_I157E();
		System.out.println(obj.isUnique1(null));	// false
		System.out.println(obj.isUnique2(null));	// false
		System.out.println(obj.isUnique1(""));	// false
		System.out.println(obj.isUnique2(""));	// false

		System.out.println(obj.isUnique1("aab"));	// false
		System.out.println(obj.isUnique2("aab"));	// false
		System.out.println(obj.isUnique1("abcda"));	// false
		System.out.println(obj.isUnique2("abcda"));	// false
		
		System.out.println(obj.isUnique1("a"));	// true
		System.out.println(obj.isUnique2("a"));	// true		
		System.out.println(obj.isUnique1("abc"));	// true
		System.out.println(obj.isUnique2("abc"));	// true
	}
}

/**
 * LintCode #157
 * Implement an algorithm to determine if a string has all unique characters.
 * Example: Given "abc", return true. Given "aab", return false.
 * What if you can not use additional data structures?
 */
