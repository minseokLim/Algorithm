package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim9466_2 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] selectedIdx = new int[n + 1];
			boolean[] chosen = new boolean[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= n; j++) {
				selectedIdx[j] = Integer.parseInt(st.nextToken());
				chosen[selectedIdx[j]] = true;
			}
			
			Test test = new Test(selectedIdx, chosen, n);		
			
			sb.append(test.solve() + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static class Test {
		private int[] selectedIdx;
		private boolean[] chosen;
		private int n;
		private int teamCnt = 0;
		
		public Test(int[] selectedIdx, boolean[] chosen, int n) {
			this.selectedIdx = selectedIdx;
			this.chosen = chosen;
			this.n = n;
		}

		public int solve() {
			boolean[] visited = new boolean[n + 1];
			boolean[] resolved = new boolean[n + 1];
			
			for(int j = 1; j <= n; j++) {
				if(!chosen[j] && !resolved[j]) {
					dfs(selectedIdx, j, visited, resolved);
				}
			}
						
			for(int j = 1; j <= n; j++) {
				if(!visited[j]) {
					teamCnt++;
				}
			}
			
			return n - teamCnt;
		}
		
		private void dfs(int[] selectedIdx, int j, boolean[] visited, boolean[] resolved) {
			visited[j] = true;		
			int next = selectedIdx[j];
			
			if(!visited[next]) {
				dfs(selectedIdx, next, visited, resolved);
			} else {
				
				if(!resolved[next]) {
					
					for(int i = next; i != j; i = selectedIdx[i]) {
						teamCnt++;
					}
					
					teamCnt++;
				}			
			}
			
			resolved[j] = true;
		}
	}	
}
