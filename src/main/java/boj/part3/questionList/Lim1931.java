package boj.part3.questionList;

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
		List<Meet> list = new ArrayList<Meet>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new Meet(start, end));
		}
		
		Collections.sort(list);
		
		int cursor = 0;
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			Meet meet = list.get(i);
			int start = meet.getStart();
			int end = meet.getEnd();
			
			if(start >= cursor) {
				cnt++;
				cursor = end;
			}
		}
		
		System.out.println(cnt);
	}
	
	private static class Meet implements Comparable<Meet> {
		private int start;
		private int end;

		public Meet(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meet meet) {
			int ret = end - meet.getEnd();
			
			if(ret == 0) {
				ret = start - meet.getStart();
//				ret = meet.getStart() - start;
//				처음에 이와 같이 생각하기 쉬우나 이 경우 회의 시간이 0인, 시작 시간과 종료 시간이 같은 회의에 대한 대응이 이루어질 수 없다.
//				[12, 14], [14, 14] 중에 [14, 14]를 앞에 정렬하게 되면 cursor가 14로 옮겨지는데, 그렇게 되면 [12, 14] 회의도 배정할 수 있음에도 불구하고 배정할 수 없다는 결과값이 도출된다.
			}
			
			return ret;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

//		@Override
//		public String toString() {
//			return "[start=" + start + ", end=" + end + "]";
//		}
	}
}
