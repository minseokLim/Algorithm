package part3.questionList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 혹시 더 효율적이고 쉬운 방법이 있는지 구글링 필요
public class Lim9466 {
	private static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] choices = new int[n + 1];
			boolean[] chosen = new boolean[n + 1];
			boolean[] visited = new boolean[n + 1];
			
			for(int j = 1; j <= n; j++) {
				choices[j] = Integer.parseInt(st.nextToken());
				chosen[choices[j]] = true;
			}
			
			cnt = 0;
			
			for(int j = 1; j <= n; j++) {
				// 일단 핵심은 chosen이 false인 값, 즉, 가장 끝단에서부터 시작을 함으로써 쓸데없는 반복적 연산횟수를 줄이는 것이다.
				if(!chosen[j]) {
					boolean[] localVisited = new boolean[n + 1];
					dfs(choices, visited, localVisited, j);
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int[] choices, boolean[] visited, boolean[] localVisited, int idx) {		
		visited[idx] = true;
		localVisited[idx] = true;
		cnt++;
		
		int next = choices[idx];
		
		// 			\/ 
		//			 \
		//           /\
		//			 \/
		// 반드시 visited와 localVisited를 분리하여 visited가 true인 곳에는 진입해선 안된다. 효율성만의 문제가 아니다.
		// 위 그림과 같은 경우 발생 시, 중복 카운트 되버림
		if(!visited[next]) { 
			dfs(choices, visited, localVisited, next);
		} else if(localVisited[next]) {
			substractCycleNo(choices, next);
		}		
	}

	private static void substractCycleNo(int[] choices, int idx) {
		cnt--;
		int next = choices[idx];
		
		while(next != idx) {
			cnt--;
			next = choices[next];
		}	
	}
}
