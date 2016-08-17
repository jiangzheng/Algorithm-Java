package tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_E22M_I427M {
	/**
	 * DFS recursion.
	 * Time: O(n!); Space: O(n)
	 */
	private List<String> list;
	
	public List<String> generateParenthesis(int n) {
		list = new ArrayList<String>();
		
		if (n < 1) {
			return null;
		}
		
		dfs("", n, n);	// n ( and ) should be added
		
		return list;
	}
	
	/**
	 * @param str - parenthesis string
	 * @param left - remaining # of ( should be added
	 * @param right - remaining # of ) should be added
	 */
	public void dfs(String str, int left, int right) {
		if (left > right) {
			return;
		}
		
		if (left == 0 && right == 0) {
			list.add(str);
			return;
		}
		
		if (left > 0) {
			dfs(str + "(", left - 1, right);
		}
		
		if (right > 0) {
			dfs(str + ")", left, right - 1);
		}
	}
	
	public static void main(String[] args) {
		GenerateParentheses_E22M_I427M obj = new GenerateParentheses_E22M_I427M();
		System.out.println(obj.generateParenthesis(-1));	// null
		System.out.println(obj.generateParenthesis(0));	// null
		
		System.out.println(obj.generateParenthesis(1));	// [()]
		System.out.println(obj.generateParenthesis(2));	// [(()), ()()]
		System.out.println(obj.generateParenthesis(3));	// [((())), (()()), (())(), ()(()), ()()()]
		System.out.println(obj.generateParenthesis(4));	// [(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]
	}
}

/**
 * LeetCode #22
 * LintCode #427
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
