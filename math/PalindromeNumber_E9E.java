package math;

public class PalindromeNumber_E9E {
	/**
	 * Reverse the integer and compare.
	 * Time: O(n); Space: O(1)
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		
		int temp = x;
		int reversed = 0;
		while (temp != 0) {		// reverse the integer, same as ReverseInteger_E7E_I413E
			reversed = reversed * 10 + temp % 10;
			temp /= 10;
		}
		
		return (reversed == x) ? true : false;	// compare if the reversed integer is equal to the original one
	}
	
	public static void main(String[] args) {
		PalindromeNumber_E9E obj = new PalindromeNumber_E9E();
		System.out.println(obj.isPalindrome(12321));	// true
		System.out.println(obj.isPalindrome(12331));	// false
	}
}

/**
 * LeetCode #9
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (i.e., -1) No
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 */
