package array;

public class RotateString_I8E {
	/**
	 * Reverse 3 times.
	 * Time: O(n); Space: O(1)
	 */
	public void rotateString(char[] str, int offset) {
		if (str == null || str.length == 0) {
			return;
		}
		
		if ((offset %= str.length) == 0) {
			return;
		}
		
		reverseArray(str, 0, str.length - 1);	// reverse all
		reverseArray(str, 0, offset - 1);	// reverse the first part
		reverseArray(str, offset, str.length - 1);	// reverse the second part
	}
	
	private void reverseArray(char[] str, int from, int to) {
		while (from < to) {
			char temp = str[from];
			str[from++] = str[to];
			str[to--] = temp;
		}
	}
	
	public static void main(String[] args) {
		RotateString_I8E obj = new RotateString_I8E();
		char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		obj.rotateString(str, 2);
		for (char c : str) {
			System.out.print(c);	// fgabcde
		}
	}
}

/**
 * LintCode #8
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 * Given "abcdefg". offset=0 => "abcdefg", offset=1 => "gabcdef", offset=2 => "fgabcde", offset=3 => "efgabcd"
 * Rotate in-place with O(1) extra memory.
 */
