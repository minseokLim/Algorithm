package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim9466 {
	private static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int[] arr = new int[n + 1];
			boolean[] visit = new boolean[n + 1];
			boolean[] chosen = new boolean[n + 1];
			
			for(int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				chosen[arr[j]] = true;
			}
			
			cnt = 0;
			
			for(int j = 1; j <= n; j++) {
				
				if(!chosen[j]) {
					boolean[] localVisit = new boolean[n + 1];
					search(arr, j, visit, localVisit);
				}
			}
		
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
	}
	
    private static void search(int[] arr, int idx, boolean[] visit, boolean[] localVisit) {
		visit[idx] = true;
		localVisit[idx] = true;
		cnt++;
		
		if(!visit[arr[idx]]) {
			search(arr, arr[idx], visit, localVisit);
		} else if(localVisit[arr[idx]]) {
			subtractCycle(arr, arr[idx]);
		}
	}

	private static void subtractCycle(int[] arr, int idx) {
		cnt--;
		int i = arr[idx];
		
		while(i != idx) {
			cnt--;
			i = arr[i];
		}
	}
}
