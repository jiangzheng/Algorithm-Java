package bit;

public class APlusBProblem_I1E {
	/**
	 * a + b = (a ^ b) + (a & b << 1)
	 * Time: O(n); Space: O(1)
	 */
	public int aplusb(int a, int b) {
		while (b != 0) {
			int carry = a & b;	// the bits need to have carry are 1
			a ^= b;	// ^ equals to addition without any carry
			b = carry << 1;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		APlusBProblem_I1E obj = new APlusBProblem_I1E();
		System.out.println(obj.aplusb(1, 2));	// 3
		System.out.println(obj.aplusb(2, 2));	// 4
		System.out.println(obj.aplusb(-1, 2));	// 1
		System.out.println(obj.aplusb(-10, -5));	// -15
	}
}

/**
 * LintCode #1
 * Write a function that add two numbers A and B. You should not use + or any arithmetic operators.
 * Notice: There is no need to read data from standard input stream. 
 * Both parameters are given in function aplusb, you job is to calculate the sum and return it.
 * Are a and b both 32-bit integers? Yes.
 * Can I use bit operation? Sure you can.
 * Example: Given a=1 and b=2 return 3
 * Of course you can just return a + b to get accepted. But Can you challenge not do it like that?
 */
