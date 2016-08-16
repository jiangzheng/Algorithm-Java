package regex;

import java.util.*;
import java.util.regex.*;

public class DetectDomainName_H101M {
	/**
	 * Regular expression.
	 * @param arr
	 */
	public void detectDomainName(String[] arr) {
		ArrayList<String> results = new ArrayList<String>();	// store the matched domain names
		
		// http|https, ://, www|ww2|web, ., xxx, ., xxx, ., com|org|net|etc, /, ...
		String regex = "(http|https|)\\://(www.|ww2.|web.|)([A-Za-z0-9\\-\\.]+)(\\.[A-Za-z]+)(/\\S*)?";
		Pattern pattern = Pattern.compile(regex);
		for (int i = 0; i < arr.length; i++) {
			Matcher matcher = pattern.matcher(arr[i]);
			while(matcher.find()) {
				System.out.println(matcher.group(0) + " | " + matcher.group(1) + " | " + matcher.group(2) + " | " + matcher.group(3) + " | " + matcher.group(4));
				String str = matcher.group(3) + matcher.group(4);   // extract the substring for printing
				if (!results.contains(str)) {
					results.add(str);	
				}
			}
		}
		
		Collections.sort(results);  // has to be sorted by ascending alphabetical order
		for (int i = 0; i < results.size(); i++) {
			System.out.print(results.get(i));
			if (i != results.size() - 1) {
				System.out.print(";");   // semi-colon separated
			}
		}
	}
	
	public static void main(String[] args) {
		DetectDomainName_H101M obj = new DetectDomainName_H101M();
		String[] arr = {
			"[\"Train (noun)\"](http://www.askoxford.com/concise_oed/train?view=uk). (definition - Compact OED). Oxford University Press. Retrieved 2008-03-18.",
			"Hello",
			"World",
			"C is a programming language.",
			"",
			"Atchison, Topeka and Danta Fe Railway (1948). Rules: Operating Department. p. 7.",
			"[Hydrogen trains](http://www.hydrogencarsnow.com/blog2/index.php/hyrogen-vehicles/i-hear-the-hydrogen-train-a-comin-its-rolling-round-the-bend/)",
			"[Vehicle Projects Inc. Fuel cell locomotive](http://www.bnsf.com/media/news/articles/2008/01/2008-01-09a.html)",
			"Central Japan Railway (2006). Central Japan Railway Data Book 2006. p. 16.",
			"[\"Overview Of the existing Mumbai Suburban Railway\"](http://web.archive.org/web/20080620033027/http://www.mrvc.indianrail.gov.in/overview.htm). _Official webpage of Mumbai Railway Vikas Corporation_. Archived from [the original](http://www.mrvc.indianrail.gov.in/overview.htm) on 2008-06-20. Retrieved 2008-12-11."
		};
		obj.detectDomainName(arr);	// archive.org;askoxford.com;bnsf.com;hydrogencarsnow.com;mrvc.indianrail.gov.in
	}
}

/**
 * HackerRank #???
 * You will be provided with a fragment of HTML code. Your task is to identify unique potential domain names
 *   from the links or URLs which are present in that code fragment.
 * For example, if the link http://www.hackerrank.com/contest is present in the markup, 
 *   you should detect the domain: hackerrank.com.
 * If second-level or higher-level domains are present in the markup, all of them need to be treated as unique.
 * For instance if the links http://www.xyz.com/news, https://abc.xyz.com/jobs, http://abcd.xyz.com/jobs2
 *   are present in the markup then [xyz.com, abc.xyz.com, abcd.xyz.com] should all be identified as unique domains.
 * The generic prefixes "www.", "ww2." and "web." should be trimmed off if present.
 */
