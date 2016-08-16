package string;

public class SortLettersByCase_I49M {
	/**
	 * Two pointers squeeze from two ends.
	 * Time: O(n); Space: O(1)
	 */
	public void sortLetters(char[] chars) {
		if (chars == null || chars.length < 2) {
			return;
		}
		
		int l = 0, r = chars.length - 1;	// two pointers
		while (l < r) {
			while (l < r && chars[l] >= 'a') {	// keep lower-case letters in the left side
				l++;
			}
			while (l < r && chars[r] < 'a') {	// keep upper-case letters in the right side
				r--;
			}
			if (l < r) {
				char temp = chars[l];	// swap a pair of lower-case/upper-case letters
				chars[l] = chars[r];
				chars[r] = temp;
				l++;
				r--;
			}
		}
		
		return;
	}
	
	public static void main(String[] args) {
		SortLettersByCase_I49M obj = new SortLettersByCase_I49M();
		obj.sortLetters(null);	// nothing
		obj.sortLetters(new char[]{});	// nothing
		
		char[] c = "abAcD".toCharArray();
		obj.sortLetters(c);
		System.out.println(String.valueOf(c));	// abcAD
	}
}

/**
 * LintCode #49
 * Given a string which contains only letters. Sort it by lower case first and upper case second.
 * Notice: It's NOT necessary to keep the original order of lower-case letters and upper case letters.
 * Example: For "abAcD", a reasonable answer is "acbAD"
 * Do it in one-pass and in-place.
 */
