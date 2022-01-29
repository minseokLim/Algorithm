package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim1158_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		StringBuffer sb = new StringBuffer("<");
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		int i = k - 1;
		
		while(true) {
			sb.append(list.remove(i));	
			
			if(list.isEmpty()) {
				sb.append(">");
				break;
			} else {
				sb.append(", ");
			}
			
			i += k - 1;
			
			if (i > list.size() - 1) {
				i %= list.size();
			}
		}

		System.out.println(sb);
	}
}
