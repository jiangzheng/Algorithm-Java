package string;

public class ValidPalindrome_E125E_I415E {
	/**
	 * Use two pointers to compare characters from two ends to middle.
	 * Time: O(n); Space: O(1)
	 */
	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return true;	// invalid input or shortcut
		}
		
		int left = 0, right = s.length() - 1;	// two pointers, starting from two ends
		s = s.toLowerCase();	// Ignore cases
		
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {	// Ignore non-alphanumeric characters
				left++;
			}
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {	// Ignore non-alphanumeric characters
				right--;
			}
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ValidPalindrome_E125E_I415E obj = new ValidPalindrome_E125E_I415E();
		System.out.println(obj.isPalindrome(null));	// true
		System.out.println(obj.isPalindrome(""));	// true
		System.out.println(obj.isPalindrome("v"));	// true
		
		System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));	// true
		
		System.out.println(obj.isPalindrome("race a car"));	// false
	}
}

/**
 * LeetCode #125
 * LintCode #415
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
 * Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
