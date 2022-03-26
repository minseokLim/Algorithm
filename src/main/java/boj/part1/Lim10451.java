package boj.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lim10451 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n + 1];
			boolean[] visit = new boolean[n + 1];
			int cnt = 0;
			
			for(int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int idx;
			
			while((idx = findIdx(visit)) != -1) {
				search(idx, visit, arr);
				cnt++;
			}
			
			bw.write(cnt + "\n");
		}		
		
		bw.flush();
	}
	
	private static void search(int s, boolean[] visit, int[] arr) {
		visit[s] = true;
		
		if(!visit[arr[s]]) {
			search(arr[s], visit, arr);
		}
	}
	
	private static int findIdx(boolean[] visit) {
		int ret = -1;
		
		for(int i = 1; i < visit.length; i++) {
			if(!visit[i]) {
				ret = i;
				break;
			}
		}
		
		return ret;
	}
}
