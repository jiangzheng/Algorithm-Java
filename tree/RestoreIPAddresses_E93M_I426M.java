package tree;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_E93M_I426M {
	/**
	 * DFS recursion.
	 * Time: O(n^4); Space: O(n)
	 */
	public List<String> restoreIpAddresses(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		
		List<String> list = new ArrayList<>();
		dfs(s, 0, new StringBuilder(), list);
		
		return list;
	}
	
	private void dfs(String s, int numPt, StringBuilder sb, List<String> list) {
		if (numPt == 3) {
			if (isValidIp(s)) {
				list.add(sb.toString() + s);
			}
		} else {
			int length = sb.length();
			for (int i = 1; i <= 3 && i <= s.length(); i++) {
				String num = s.substring(0, i);
				if (isValidIp(num)) {
					dfs(s.substring(i), numPt + 1, sb.append(num).append('.'), list);
				}
				sb.delete(length, sb.length());
			}
		}
	}

	private boolean isValidIp(String str) {
		if (str.length() == 1 || str.length() >= 1 && str.length() <= 3 && !str.startsWith("0")) {
			int num = Integer.parseInt(str);
			if (num >= 0 && num <= 255) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		RestoreIPAddresses_E93M_I426M obj = new RestoreIPAddresses_E93M_I426M();
		System.out.println(obj.restoreIpAddresses(null));	// null
		System.out.println(obj.restoreIpAddresses(""));	// null
		
		System.out.println(obj.restoreIpAddresses("25525511135"));	// [255.255.11.135, 255.255.111.35]
	}
}

/**
 * LeetCode #93
 * LintCode #426
 * Given a string containing only digits, 
 *   restore it by returning all possible valid IP address combinations.
 * For example: Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
