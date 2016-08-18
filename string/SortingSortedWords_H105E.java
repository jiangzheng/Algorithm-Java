package string;

import java.util.*;

public class SortingSortedWords_H105E {
	
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner stdin = new Scanner(System.in);
		String[] input = stdin.nextLine().split(" ");	// get the input string
		
		String[] cleaned = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			String str = input[i].replaceAll("[^a-zA-Z]", "").toLowerCase();	// remove non-alphabetic characters and convert to lowercase
			char[] c = str.toCharArray();
			Arrays.sort(c);	// sort all of the letters within each word 
			cleaned[i] = new String(c);
		}
		
		// remove duplicated words
		Set<String> set = new HashSet<>();
		for (String x : cleaned) {
			set.add(x);
		}
		
		// sort words
		String[] sorted = set.toArray(new String[set.size()]);
		Arrays.sort(sorted);
	
		// print the output
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i]);
			if (i != sorted.length - 1) {
				System.out.print(" ");
			}
		}
		
		// close the stdin
		stdin.close();
	}
}

/**
 * Hackerrank #105
 * Given a sentence on STDIN:
 * 1) Strip all non-alphabetic characters
 * 2) Convert all letters to lowercase
 * 3) Sort all of the letters within each word
 * 4) Sort the sorted words within the sentence and eliminate duplicates
 * 5) Output to STDOUT the list from Step 4 with words separated by spaces
 * For example, given the input: I may opt for a top yam for Amy, May, and Tommy.
 * Your program should print: a adn amy for i mmoty opt
 */
