package boj.part3.questionList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2579 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] scores = new int[300];
		
		for(int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		int[] max = new int[300];
		
		max[0] = scores[0];
		max[1] = scores[0] + scores[1];
		max[2] = Math.max(scores[0], scores[1]) + scores[2];
		
		for(int i = 3; i < n; i++) {
			max[i] = Math.max(scores[i - 1] + max[i - 3], max[i - 2]) + scores[i];
		}
		
		System.out.println(max[n - 1]);
	}
}
