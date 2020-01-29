package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Lim1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
		
		Arrays.sort(meetings);
		
	}
	
	private static class Meeting implements Comparable<Meeting> {
		private int start;
		private int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		@Override
		public int compareTo(Meeting obj) {
			return this.end - obj.getEnd();
		}
		
		public boolean intersect(Meeting obj) {
			return obj.getStart() < this.end && obj.getStart() > this.start
					|| obj.getEnd() > this.start && obj.getEnd() < this.end;
		}
	}
}
