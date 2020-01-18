package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim6603 {
	private static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String input = br.readLine();
			
			if("0".equals(input)) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(input);
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[k];
			
			for(int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] selected = new int[6];
			
			combination(arr, selected, k, 0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void combination(int[] arr, int[] selected, int k, int target, int depth) {
		if(depth == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(arr[selected[i]] + " ");
			}
			
			sb.append("\n");
		} else if(target < k) {
			selected[depth] = target;
			combination(arr, selected, k, target + 1, depth + 1);
			combination(arr, selected, k, target + 1, depth);
		}		
	}
}
