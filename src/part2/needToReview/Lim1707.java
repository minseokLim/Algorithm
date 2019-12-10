package part2.needToReview;

// https://casterian.net/archives/78
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim1707 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int[] color = new int[v + 1];
			
			@SuppressWarnings("unchecked")
			List<Integer>[] lists = new ArrayList[v + 1];
			
			for(int j = 1; j <= v; j++) {
				lists[j] = new ArrayList<Integer>();
			}
			
			for(int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				lists[a].add(b);
				lists[b].add(a);
			}
			
			boolean possible = true;
			
			for(int j = 1; j <= v; j++) {
				if(color[j] == 0) {
					if(!bfs(lists, color, j)) {
						possible = false;
						break;
					};
				}			
			}
			
			if(possible) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
	}

	private static boolean bfs(List<Integer>[] lists, int[] color, int s) {
		boolean ret = true;
		color[s] = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(s);
		
		outer : while(!queue.isEmpty()) {
			int poll = queue.poll();
			
			for(int elem : lists[poll]) {
				if(color[elem] == 0) {
					color[elem] = color[poll] * -1;
					queue.add(elem);
				} else if(color[elem] == color[poll]) {
					ret = false;
					break outer;
				}
			}
		}
		
		return ret;
	}
}
