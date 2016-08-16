package string;

public class SpaceReplacement_I212E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public int replaceBlank(char[] string, int length) {
		if (string == null || string.length == 0) {
			return -1;	// invalid input
		}
		
		int newLength = length;
		for (char c : string) {
			if (c == ' ') {
				newLength += 2;
			}
		}
		
		int pointer = newLength - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (string[i] != ' ') {
				string[pointer--] = string[i];
			} else {
				string[pointer--] = '0';
				string[pointer--] = '2';
				string[pointer--] = '%';
			}
		}
		
		return newLength;
	}
	
	public static void main(String[] args) {
		SpaceReplacement_I212E obj = new SpaceReplacement_I212E();
		System.out.println(obj.replaceBlank(null, 13));	// -1
		System.out.println(obj.replaceBlank(new char[]{}, 13));	// -1
		
		char[] s = new char[17];
		s[0] = 'M'; s[1] = 'r'; s[2] = ' '; s[3] = 'J'; s[4] = 'o'; s[5] = 'h'; s[6] = 'n'; s[7] = ' ';
		s[8] = 'S'; s[9] = 'm'; s[10] = 'i'; s[11] = 't'; s[12] = 'h';
		System.out.println(obj.replaceBlank(s, 13));	// 17 ("Mr%20John%20Smith")
	}
}

/**
 * LintCode #212
 * Write a method to replace all spaces in a string with %20. 
 * The string is given in a characters array, 
 *   you can assume it has enough space for replacement and you are given the true length of the string.
 * You code should also return the new length of the string after replacement.
 * Notice: If you are using Java or Python, please use characters array instead of string.
 * Example: Given "Mr John Smith", length = 13. The string after replacement should be "Mr%20John%20Smith".
 * Do it in-place.
 */
