package string;

public class ValidAnagram_E242E {
	/**
	 * Cancel letters in two strings.
	 * Time: O(n); Space: O(1)
	 */
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;	// invalid input or shortcut
		}
		
		int[] letters = new int[26];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i) - 'a']++;
			letters[t.charAt(i) - 'a']--;
		}
		
		for (int x : letters) {
			if (x != 0) {	// if there is any non-zero, return false
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ValidAnagram_E242E obj = new ValidAnagram_E242E();
		System.out.println(obj.isAnagram(null, null));	// false
		System.out.println(obj.isAnagram("", null));	// false
		System.out.println(obj.isAnagram(null, ""));	// false
		
		System.out.println(obj.isAnagram("rat", "tart"));	// false
		System.out.println(obj.isAnagram("rat", "car"));	// false

		System.out.println(obj.isAnagram("abcd", "dcab"));	// true
		System.out.println(obj.isAnagram("anagram", "nagaram"));	// true
	}
}

/**
 * LeetCode #242
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car", return false.
 * Given s="abcd", t="dcab", return true.
 * Note: You may assume the string contains only lowercase alphabets.
 * Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
