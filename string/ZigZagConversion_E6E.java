package string;

public class ZigZagConversion_E6E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public String convert(String s, int nRows) {
		if (s == null || nRows <= 0) {
			return null;	// invalid input
		}
		
		if (nRows == 1) {
			return s;
		}
		
		StringBuilder sb = new StringBuilder();
		int skip1 = nRows + (nRows - 2);	// distance b/w major chars
		int skip2 = skip1;	// distance b/w major and minor chars
		
		for (int i = 0; i < nRows; i++) {
			if (i != 0 && i != nRows - 1) {
				skip2 -= 2;		// if not the 1st row or last row, distance b/w major and minor chars decreases by 2.
			}
			
			int index = i;
			while (index < s.length()) {
				sb.append(s.charAt(index));	// append major chars
				if (i != 0 && i != nRows - 1 && index + skip2 < s.length()) {
					sb.append(s.charAt(index + skip2));	// append minor chars
				}
				index += skip1;	// next major char
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ZigZagConversion_E6E obj = new ZigZagConversion_E6E();
		System.out.println(obj.convert(null, 3));	// null
		System.out.println(obj.convert("PAYPALISHIRING", 0));	// null
		
		System.out.println(obj.convert("PAYPALISHIRING", 1));	// PAYPALISHIRING
		System.out.println(obj.convert("PAYPALISHIRING", 2));	// PYAIHRNAPLSIIG
		System.out.println(obj.convert("PAYPALISHIRING", 3));	// PAHNAPLSIIGYIR
	}
}

/**
 * LeetCode #6
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 *   (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *   string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
