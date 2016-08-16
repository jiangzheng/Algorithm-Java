package regex;

import java.util.regex.*;

public class ValidIPAddress_H102M {
	public static String pattern = 
			"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public boolean isMatches(String ip){
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(ip);
		return m.matches();
	}

	public static void main(String[] args) {
		ValidIPAddress_H102M obj = new ValidIPAddress_H102M();
		System.out.println(obj.isMatches("000.12.12.034"));	// true
		System.out.println(obj.isMatches("121.234.12.12"));	// true
		System.out.println(obj.isMatches("23.45.12.56"));	// true
		System.out.println(obj.isMatches("00.12.123.123123.123"));	// false
		System.out.println(obj.isMatches("122.23"));	// false
		System.out.println(obj.isMatches("Hello.IP"));	// false
	}
}

/**
 * HackerRank #???
 * Write a regular expression solution to check if an IP address is valid.
 * An IP address is a String in the form "A.B.C.D", where the values A, B, C, and D range from 0 to 255.
 * Leading zeros are allowed, but the lengths of A, B, C, and D cannot be larger than 3.
 * Sample valid IP addresses: 000.12.12.034, 121.234.12.12, 23.45.12.56
 * Sample invalid IP addresses: 000.12.234.23.23, 666.666.23.23, .213.123.23.32, 23.45.22.32., I.Am.not.an.ip
 * Typical HackerRank code stub:
 * Scanner in = new Scanner(System.in);
 * while(in.hasNext()) {
 *     MyRegex mr = new MyRegex(in.next());
 *     System.out.println(mr.isMatches());
 * }
 */
