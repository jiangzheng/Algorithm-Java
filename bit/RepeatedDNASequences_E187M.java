package bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences_E187M {
	/**
	 * Hash Table + Bit Manipulation.
	 * Time: O(n); Space(2n)
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		if (s == null || s.length() == 0) {
			return null;	// invalid input
		}
		
		List<String> list = new ArrayList<String>();
		Map<Integer, Integer> visited = new HashMap<Integer, Integer>(); // <sequence, count>
		char[] map = new char[26];
		map['A' - 'A'] = 0;
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;

		int length = 10, v = 0;
		for (int i = 0; i < s.length(); i++) {
			v <<= 2;
			v |= map[s.charAt(i) - 'A'];	// add 2 bits at the end
			if (i == length - 1) {
				visited.put(v, 1);
			} else if (i > length - 1) {
				v &= ~(3 << 2*length);	// drop 2 bits at the highest place
				if (!visited.containsKey(v)) {
					visited.put(v, 1);
				} else {
					visited.put(v, visited.get(v) + 1);
				}
				if (visited.get(v) == 2) {
					list.add(s.substring(i - length + 1, i + 1));
				}
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		RepeatedDNASequences_E187M obj = new RepeatedDNASequences_E187M();
		System.out.println(obj.findRepeatedDnaSequences(null));	// null
		System.out.println(obj.findRepeatedDnaSequences(""));	// null
		
	  	System.out.println(obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	  	// [AAAAACCCCC, CCCCCAAAAA]
   	}
}

/**
 * LeetCode #187
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) 
 *   that occur more than once in a DNA molecule.
 * For example, Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 */
