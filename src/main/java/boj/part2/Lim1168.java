package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lim1168 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
		
		int i = 0;
		StringBuffer sb = new StringBuffer("<");
		
		while(true) {		
			i += k - 1;
			
			if(i > list.size() - 1) {
				i %= list.size();
			}
			
			Integer tmp = list.remove(i);
			
			if(list.isEmpty()) {
				sb.append(tmp + ">");
				break;
			} else {
				sb.append(tmp + ", ");				
			}
		}
		
		System.out.println(sb);
	}
}
