package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim1967 {
	private static int start = 1;
	private static int diameter = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		@SuppressWarnings("unchecked")
		List<Integer>[] lists = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int childIdx = Integer.parseInt(st.nextToken());
			int distanceInfo = Integer.parseInt(st.nextToken());
			lists[idx].add(childIdx);	
			lists[idx].add(distanceInfo);
			lists[childIdx].add(idx);
			lists[childIdx].add(distanceInfo);
		}
		
		bfsMethod(lists, start, n);
		bfsMethod(lists, start, n);
		System.out.println(diameter);
	}

	private static void bfsMethod(List<Integer>[] lists, int i, int n) {
		boolean[] visit = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> distances = new LinkedList<Integer>();
		visit[i] = true;
		queue.add(i);
		distances.add(0);
		
		while(!queue.isEmpty()) {
			
			int idx = queue.poll();
			List<Integer> list = lists[idx];
			int initDistance = distances.poll();
			
			if(initDistance > diameter) {
				start = idx;
				diameter = initDistance;
			}
			
			for(int j = 0; j < list.size() / 2; j++) {
				
				int k = list.get(2 * j);
				
				if(!visit[k]) {
					visit[k] = true;
					queue.add(k);
					distances.add(initDistance + list.get(2 * j + 1));
				}
			}
		}
	}
}
