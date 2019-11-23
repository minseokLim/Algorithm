package part2.needToReview;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _Lim2579 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] scores = new int[n];
		
		for(int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
	}
}