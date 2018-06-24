package coderust.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

class Interval {
	public int start;
	public int end;
	Interval(int s, int e) {
		start = s;
		end = e;
	}
	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}
public class MergeOverlappingIntervals {
	private ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.compare(o1.start, o2.start);
			}});
		Stack<Interval> s = new Stack<>();
		for(Interval i : intervals) {
			if(s.isEmpty()) {
				s.push(i);
				continue;
			}
			if(s.peek().end >=i.start){
				if(s.peek().end < i.end) {
					Interval i1 = s.pop();
					Interval mergedInterval = new Interval(i1.start, i.end);
					s.push(mergedInterval);
				}
				continue;
			}
			s.push(i);
		}
		return new ArrayList<Interval>(s);
	}

	//  [[1,3],[2,6],[8,10],[15,18]]
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));

//		intervals.add(new Interval(1,4));
//		intervals.add(new Interval(4,5));
		
		ArrayList<Interval> mergedIntervals = new MergeOverlappingIntervals().mergeIntervals(intervals);
		System.out.println(mergedIntervals);
	}
}
