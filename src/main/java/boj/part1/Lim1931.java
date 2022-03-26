package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Lim1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Schedule> list = new ArrayList<Schedule>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new Schedule(start, end));
		}
		
		Collections.sort(list);
				
		int cnt = 1;
		int max = list.get(0).getEnd();
		
		for(int i = 1; i < list.size(); i++) {
			
			Schedule nowElem = list.get(i);
			
			if(nowElem.getStart() >= max) {
				max = nowElem.getEnd();
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static class Schedule implements Comparable<Schedule> {
		private int start;
		private int end;
		
		public Schedule(int start, int end) {
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
		public int compareTo(Schedule o) {
			int ret = this.end - o.getEnd();
			
			// 이 조건을 생각해내는 게 쉽지 않다.
			// 반례 : [2, 2] [0, 2]에서 이 조건이 없다면 [2, 2]가 먼저 들어갈 수 있다
			if(ret == 0) {
				ret = this.start - o.getStart();
			}
			
			return ret;
		}
	}
}
