package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Overlapping_Intervals {

	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {

//		Creating intervals
		Interval interval1 = new Interval(1, 3);
		Interval interval2 = new Interval(2, 6);
		Interval interval3 = new Interval(8, 10);
		Interval interval4 = new Interval(15, 18);
		
		Interval[] intervals = {interval1, interval2, interval3, interval4};
		
//		Invoking method
		List<Interval> result = findOverlappingIntervals(intervals);
		
//		Printing new overlapping intervals
		for( int i = 0 ; i < result.size(); i++) {
			System.out.print("[" + result.get(i).start);
			System.out.print(", ");
			System.out.print(result.get(i).end + "]");
			System.out.print(", ");
		}
		
	}

//	Responsible method for finding overlapping intervals
//	(Edge case, Array sorting, comparing start and end, adding intervals to new List)
	private static List<Interval> findOverlappingIntervals(Interval[] intervals) {
		List<Interval> result = new ArrayList<>();
		Interval sample = intervals[0];
		if(intervals.length == 1 ) {
			result.add(sample);
			return result;
		}
		
//		Sorting array with Item's start point stored in Interval type objects
		Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start - i2.start;
            }
        });
		
//		Looking for intervals which can be overlapped
		for( int i = 1 ; i < intervals.length; i++) {
			Interval next = intervals[i];
			if(sample.end >= next.start) {
				sample.end = Math.max(sample.end, next.end);
			}
			else {
				result.add(sample);
				sample = next;
			}
		}
//		Adding last sample which was not added during last run
		result.add(sample);
		return result;
	}
}
