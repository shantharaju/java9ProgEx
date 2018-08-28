package coderust.dynamicprog;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.ics.uci.edu/~goodrich/teach/cs161/notes/dynamicp.pdf, Page-11
 * Similar to https://www.geeksforgeeks.org/weighted-job-scheduling/
 * Given list of jobs with startTime, endTime, Benefit
 * Find the best possible schedule to maximize the overall benefit
 *
 */
public class TelescopeScheduling {

	static class Job {
		int start;
		int end;
		int weight;
		Job(int s, int e, int w) {
			start = s;
			end = e;
			weight = w;
		}
		
		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
	}
	
	private long findOptSchedule(Job[] a) {
		List<Job> arr = Arrays.asList(a);
		Collections.sort(arr, new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				return Integer.compare(j1.end, j2.end);
			}});
		long[] B = new long[arr.size()];
		B[0] = arr.get(0).weight;
		
		for(int i = 1; i < arr.size(); i++) {
			int predIndex = findPred(arr, i);
			long B_prev = predIndex >= 0 ? B[predIndex] : 0;
			B[i] = Math.max(B[i-1], arr.get(i).weight + B_prev);
		}
		return B[a.length - 1];
	}

	private int findPred(List<Job> arr, int index) {
		int currStart = arr.get(index).start;
		for(int i = index - 1; i > -1; i--) {
			if(arr.get(i).end <= currStart) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Job[] arr = { new Job(1,2,50), new Job(3,5,20), new Job(6, 19, 100), new Job(2, 100, 200) };
		long totalWeight = new TelescopeScheduling().findOptSchedule(arr);
		System.out.println(totalWeight);
	}
}