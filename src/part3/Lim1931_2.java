package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim1931_2 {
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
		
		int cnt = 1;
		int cursor = meetings[0].getEnd();
		
		for(int i = 1; i < n; i++) {
			Meeting meeting = meetings[i];
			
			if(meeting.getStart() >= cursor) {
				cnt++;
				cursor = meeting.getEnd();
			}
		}
		
		System.out.println(cnt);
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
			int ret = this.end - obj.getEnd();
			
			if(ret == 0) {
				ret = this.start - obj.getStart();
			}
			
			return ret;
		}
	}
}
