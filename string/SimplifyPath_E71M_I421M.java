package string;

import java.util.Stack;

public class SimplifyPath_E71M_I421M {
	/**
	 * Stack.
	 * Time: O(n); Space: O(n)
	 */
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return path;
		}
		
		String[] parts = path.split("/");	// cut path into pieces
		Stack<String> stack = new Stack<>();
		for (String s : parts) {
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (s.length() == 0 || s.equals(".")) {	// "//" and "/./"
				continue;
			} else {
				stack.add(s);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if (stack.isEmpty()) {
			stack.add("");
		}
		
		while (!stack.isEmpty()) {
			sb.append("/").append(stack.remove(0));
		}
		
		return sb.toString();
	}
	
	/**
	 * 此方法稍快，方法基本相同，只是这里不用 .split()，可以节省 Space。
	 * 但需要一位一位的读，并存入字串 seg 中；
	 * 如果遇到 "/" 或 path 的尾部（注意是 i == path.length() 不是 i == path.length() - 1），
	 * 则判断之前读到的字串，如果为 ".." 则弹栈，如果不为空也不为 "." 则入栈，然后删除字串的内容。
	 * Time: O(N), Space: O(N)
	 */
	/*
	public String simplifyPath2(String path) {
		Stack<String> stack = new Stack<>();
		StringBuilder seg = new StringBuilder();
		
		for (int i = 0; i <= path.length(); i++) {
			if (i == path.length() || path.charAt(i) == '/') {
				if (seg.toString().equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else if (seg.length() > 0 && !seg.toString().equals(".")) {
					stack.add(seg.toString());
				}
				seg.delete(0, seg.length());
			} else {
				seg.append(path.charAt(i));
			}
		}
		
		seg = new StringBuilder();
		if (stack.isEmpty())
			stack.add("");
		
		while (!stack.isEmpty())
			seg.append('/').append(stack.remove(0));
		
		return seg.toString();
	}
	*/
	public static void main(String[] args) {
		SimplifyPath_E71M_I421M obj = new SimplifyPath_E71M_I421M();
		System.out.println(obj.simplifyPath(null));	// null
		System.out.println(obj.simplifyPath(""));	// ""
		
		System.out.println(obj.simplifyPath("/home/"));	// /home
		System.out.println(obj.simplifyPath("/a/./b/../../c/"));	// /c
		System.out.println(obj.simplifyPath("/../"));	// /
		System.out.println(obj.simplifyPath("/home//foo/"));	// /home/foo
	}
}

/**
 * LeetCode #71
 * LintCode #421
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * Corner Cases:
 * - Did you consider the case where path = "/../"? In this case, you should return "/".
 * - Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * - In this case, you should ignore redundant slashes and return "/home/foo".
 */
