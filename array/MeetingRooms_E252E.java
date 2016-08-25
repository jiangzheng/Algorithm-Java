package array;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_E252E {
	/**
	 * Time: O(n log n); Space: O(1)
	 */
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length ==0) {
			return true;	// invalid input
		}
		
		Arrays.sort(intervals, new IntervalComparator());
		
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i - 1].end > intervals[i].start) {
				return false;
			}
		}
		
		return true;
	}
	
	public class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}
		
	// Definition for an interval.
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void main(String[] args) {
		MeetingRooms_E252E obj = new MeetingRooms_E252E();
		System.out.println(obj.canAttendMeetings(null));	// true
		System.out.println(obj.canAttendMeetings(new Interval[]{}));	// true
		
		Interval[] i = new Interval[3];
		i[0] = obj.new Interval(0, 30);
		i[1] = obj.new Interval(5, 10);
		i[2] = obj.new Interval(15, 20);
		System.out.println(obj.canAttendMeetings(i));	// false
		
		i[0] = obj.new Interval(0, 5);
		i[1] = obj.new Interval(5, 10);
		i[2] = obj.new Interval(15, 20);
		System.out.println(obj.canAttendMeetings(i));	// true
	}
}

/**
 * LeetCode #252
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 *   determine if a person could attend all meetings.
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 */
