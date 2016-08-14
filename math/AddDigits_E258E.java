package math;

public class AddDigits_E258E {
	/**
	 * Straightforward.
	 * Time: O(?); Space: O(1)
	 */
	public int addDigits1(int num) {
		if (num <= 0) {
			return 0;	// invalid input
		}
		
		while (num >= 10) {
			int updatedNum = 0;
			while (num > 0) {
				updatedNum += num % 10;
				num /= 10;
			}
			num = updatedNum;
		}
		
		return num;
	}
	
	/**
	 * Pattern.
	 * Time: O(1); Space: O(1)
	 */
	public int addDigits2(int num) {
		return (num <= 0) ? 0 : (num - 1) % 9 + 1;
	}
	
	public static void main(String[] args) {
		AddDigits_E258E obj = new AddDigits_E258E();
		System.out.println(obj.addDigits1(-1));	// 0
		
		System.out.println(obj.addDigits1(6));	// 6
		System.out.println(obj.addDigits2(6));	// 6
		System.out.println(obj.addDigits1(38));	// 2
		System.out.println(obj.addDigits2(38));	// 2
	}
}

/**
 * LeetCode #258
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example: Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */
