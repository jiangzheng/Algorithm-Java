package string;

public class LongestCommonPrefix_E14E_I78M {
	/**
	 * Compare each string with the updated common prefix.
	 * Time: O(n); Space: O(1)
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";	// invalid input
		}
		
		if (strs.length == 1) {
			return strs[0];	// shortcut
		}
		
		String commonPrefix = strs[0];
		for (int i = 1; i < strs.length; i++) {	// compare each string with the common prefix
			int pointer = 0;
			while (pointer < strs[i].length() && pointer < commonPrefix.length() 
					&& strs[i].charAt(pointer) == commonPrefix.charAt(pointer)) {
				pointer++;
			}
			if (pointer == 0) {
				return "";	// no any common prefix
			}
			commonPrefix = commonPrefix.substring(0, pointer);
		}
		
		return commonPrefix;
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix_E14E_I78M obj = new LongestCommonPrefix_E14E_I78M();
		System.out.println(obj.longestCommonPrefix(null));	// ""
		System.out.println(obj.longestCommonPrefix(new String[]{}));	// ""

		String[] strs = {"Hello World", "Hello Weee", "Hola World", "Hola Word", "Hell o World"};
		System.out.println(obj.longestCommonPrefix(strs));	// H
	}
}

/**
 * LeetCode #14
 * LintCode #78
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
