package string;

public class CountAndSay_E38E_I420E {
	/**
	 * Time: O(n^2); Space: O(n)
	 */
	public String countAndSay(int n) {
		if (n <= 0) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder("1");		// current string
		for (int i = 1; i < n; i++) {
			StringBuilder next = new StringBuilder();	// next string
			int count = 1;
			for (int j = 1; j < sb.length(); j++) {
				if (sb.charAt(j) == sb.charAt(j - 1)) {	// if a char is the same as its previous one
					count++;	// count how many same chars
				} else {	// find a different char
					next.append(count);
					next.append(sb.charAt(j - 1));	// append "count" + "number" to the next string
					count = 1;	// reset counter
				}
			}
			next.append(count);
			next.append(sb.charAt(sb.length() - 1));	// append "count" + "number" of the last c/n pair to the next string
			sb = next;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		CountAndSay_E38E_I420E obj = new CountAndSay_E38E_I420E();
		for (int i = 0; i < 10; i++) {
			System.out.print(obj.countAndSay(i) + ", ");
			// null, 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, 31131211131221, 
		}
	}  
}

/**
 * LeetCode #38
 * LintCode #420
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
