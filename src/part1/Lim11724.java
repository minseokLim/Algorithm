package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim11724 {
	
	static boolean[] visitRec;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int lineN = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		
		@SuppressWarnings("unchecked")
		List<Integer>[] lists = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < lineN; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			lists[x - 1].add(y);
			lists[y - 1].add(x);
		}
		
		visitRec = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			if(visitRec[i] == false) {
				dfsMethod(lists, i);
				answer++;
			}
		}
		
		System.out.println(answer);
	}

	private static void dfsMethod(List<Integer>[] lists, int i) {
		visitRec[i] = true;
		
		for(int j = 0; j < lists[i].size(); j++) {		
			int next = lists[i].get(j);
			if(visitRec[next - 1] == false) {
				dfsMethod(lists, next - 1);
			}
		}
	}
}
