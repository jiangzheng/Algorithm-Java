package string;

public class CompareStrings_I55E {
	/**
	 * Cancel number of occurrences.
	 * Time: O(n); Space: O(1)
	 */
	public boolean compareStrings(String A, String B) {
		if (A == null || B == null) {
			return false;	// invalid input
		}
		
		if (A.length() < B.length()) {
			return false;	// shortcut
		}
		
		int[] letterSet = new int[26];
		for (int i = 0; i < A.length(); i++) {
			letterSet[A.charAt(i) - 'A']++;	// increase number of occurrences
		}
		
		for (int i = 0; i < B.length(); i++) {
			letterSet[B.charAt(i) - 'A']--;	// cancel number of occurrences
			if (letterSet[B.charAt(i) - 'A'] < 0) {	// once there is a negative one, return false
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		CompareStrings_I55E obj = new CompareStrings_I55E();
		System.out.println(obj.compareStrings(null, null));	// false
		System.out.println(obj.compareStrings(null, "ACD"));	// false
		System.out.println(obj.compareStrings("ABCD", null));	// false
		System.out.println(obj.compareStrings("", "ACD"));	// false
		System.out.println(obj.compareStrings("ABCD", "ABCDA"));	// false
		System.out.println(obj.compareStrings("ABCD", "AABC"));	// false

		System.out.println(obj.compareStrings("", ""));	// true
		System.out.println(obj.compareStrings("ABCD", ""));	// true
		System.out.println(obj.compareStrings("ABCD", "ACD"));	// true
		System.out.println(obj.compareStrings("ABCD", "DCBA"));	// true
	}
}

/**
 * LintCode #55
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 * The characters in string A and B are all Upper Case letters.
 * Notice: The characters of B in A are not necessary continuous or ordered.
 * Example For A = "ABCD", B = "ACD", return true. For A = "ABCD", B = "AABC", return false.
 */
