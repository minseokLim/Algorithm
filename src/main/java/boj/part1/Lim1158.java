package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Lim1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		
		List<Integer> list = new LinkedList<>();
		IntStream.rangeClosed(1, n).forEach(list::add);
		int i = k - 1;
		
		while(true) {
			sb.append(list.remove(i) + ", ");	
			
			if(list.isEmpty()) break;
			
			i += k - 1;
			while(i > list.size() - 1) {
				i -= list.size();
			}
		}
		
		sb.delete(sb.length() - 2, sb.length());
		System.out.println(sb.append(">"));
	}
}
