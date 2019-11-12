package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim1707 {
	private static Queue<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < tCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			byte[] check = new byte[v + 1];
			@SuppressWarnings("unchecked")
			List<Integer>[] lists = new ArrayList[v + 1];
			
			for(int j = 1; j < lists.length; j++) {
				lists[j] = new ArrayList<Integer>(); 
			}
			
			for(int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				lists[a].add(b);
				lists[b].add(a);
			}
			
			int idx;
			boolean result = false;
			
			while((idx = findRemainIdx(check)) != -1) {
				result = bfsMethod(lists, check, idx);
				
				if(!result) break;
			}
			
			if(result) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
	}
	
	private static boolean bfsMethod(List<Integer>[] lists, byte[] check, int idx) {
		boolean ret = true;				
		check[idx] = 1;
		queue = new LinkedList<Integer>();
		queue.add(idx);
		
		outer : while(!queue.isEmpty()) {
			
			Integer elem = queue.poll();
			List<Integer> list = lists[elem];
			byte color = (byte) (check[elem] * (-1));
			
			for(int x : list) {
				
				if(check[x] == 0) {
					check[x] = color;
					queue.add(x);
				} else if(check[x] != color) {
					ret = false;
					break outer;
				}
			}
		}
		
		return ret;
	}
	
	private static int findRemainIdx(byte[] check) {
		int ret = -1;
		
		for(int i = 1; i < check.length; i++) {
			
			if(check[i] == 0) {
				ret = i;
				break;
			}
		}
		
		return ret;
	}
}
