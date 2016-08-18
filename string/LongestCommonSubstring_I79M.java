package string;

public class LongestCommonSubstring_I79M {
	/**
	 * Time: O(mn); Space: O(1)
	 */
	public int longestCommonSubstring(String A, String B) {
		if (A == null || B == null) {
			return -1;	// invalid input
		}
		
		int maxLength = 0;
		int lengthA = A.length(), lengthB = B.length();
		
		for (int i = 0; i < lengthA; ++i) {
			for (int j = 0; j < lengthB; ++j) {
				int len = 0;
				
				while (i + len < lengthA && j + len < lengthB && A.charAt(i + len) == B.charAt(j + len)) {
						len ++;
				}
				
				if (len > maxLength) {
					maxLength = len;
				}
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		LongestCommonSubstring_I79M obj = new LongestCommonSubstring_I79M();
		System.out.println(obj.longestCommonSubstring(null, null));	// -1
		System.out.println(obj.longestCommonSubstring(null, "CBCE"));	// -1
		System.out.println(obj.longestCommonSubstring("ABCD", null));	// -1
		
		System.out.println(obj.longestCommonSubstring("ABCD", "CBCE"));	// 2
	}
}

/**
 * LintCode #79
 * Given two strings, find the longest common substring. Return the length of it.
 * Notice: The characters in substring should occur continuously in original string. 
 * This is different with subsequence.
 * Example: Given A = "ABCD", B = "CBCE", return 2. 
 * O(n x m) time and memory.
 */
