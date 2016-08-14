package regex;

import java.util.regex.*;

public class BalancedStrings_H100H {	
	/**
	 * Multiple counters.
	 */
	public boolean checker1(String str) {
		String[] regex = {"[a]", "[b]", "[c]", "[d]"};
		int[] counter = new int[regex.length];
		
		for (int i = 0; i < regex.length; i++) {
			Pattern p = Pattern.compile(regex[i]);
			Matcher m = p.matcher(str);
			while (m.find()) {
				counter[i]++;
			}
		}
		
		for (int i = 0; i < regex.length; i++) {
			System.out.print(regex[i] + ": " + counter[i] + "\t");
		}

		int sumac = counter[0] + counter[2];
		int sumbd = counter[1] + counter[3];
		if (sumac % 2 == 0 && sumbd % 2 == 0) {
			return true;
		}
		
		return false;
	}

	/**
	 * RegEx-only challenge.
	 */
	public boolean checker2(String str) {
		String regex = "(?:[^a]*a[^a]*a)";	// ??? don't know how to do this yet
		Pattern p = Pattern.compile(regex);
	   	Matcher m = p.matcher(str);
   		System.out.print(str + "\t\t");
   		
	   	return m.find();
	}
		
	public static void main(String[] args) {
		BalancedStrings_H100H obj = new BalancedStrings_H100H();
		System.out.println(obj.checker1("acdbddbbbbaaac"));	// true
		System.out.println(obj.checker1("cdba"));		// true
		System.out.println(obj.checker1("aaccb"));		// false
		System.out.println(obj.checker1("cdcdaabb"));	// true
		System.out.println(obj.checker1("ababddd"));	// false

		System.out.println(obj.checker2("acdbddbbbbaaac"));
		System.out.println(obj.checker2("cdba"));
		System.out.println(obj.checker2("aaccb"));
		System.out.println(obj.checker2("cdcdaabb"));
		System.out.println(obj.checker2("ababddd"));	
	}
}

/**
 * HackerRank #???
 * Julia has a string, S, composed of the letters a, b, c, and d. 
 * String s is said to be balanced if following conditions are satisfied:
 * - The summed number of a's and c's is even.
 * - The summed number of b's and d's is even.
 * Write a regular expression that matches balanced strings.
 * This is a RegEx-only challenge. Input is handled for you by the locked code in the editor, 
 * so you only need concern yourself with writing a RegEx that will match to a single string token.
 * Replace the blank in the stub code with your RegEx string.
 * public class Solution {	
 *     public static void main(String[] args) {
 *         Regex_Test tester = new Regex_Test();
 *         tester.checker("__________"); // Use \\ instead of using \ 
 *     }
 * }
 */
