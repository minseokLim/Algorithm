package boj.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lim1463_2 {
	
	public static int[] arr;
	
	public void solution() {   	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int input = Integer.parseInt(br.readLine());
			
			arr = new int[input + 1];
			arr[1] = 0;
			
			System.out.println(cal(input));
			
			br.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}		
    }
	
	public static int cal(int n) {
		if(n == 1) {
			return 0;
		} else if(arr[n] != 0) {
			return arr[n];
		} else {
			arr[n] = cal(n - 1) + 1;
			
			if(n % 3 == 0 && arr[n] > cal(n / 3) + 1) {
				arr[n] = cal(n / 3) + 1;
			}
			
			if(n % 2 == 0 && arr[n] > cal(n / 2) + 1) {
				arr[n] = cal(n / 2) + 1;
			}
		}

		return arr[n];
	}
}
