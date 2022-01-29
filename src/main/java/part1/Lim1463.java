package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;


public class Lim1463 {

    public Lim1463() {}
    public void solution() {   	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int input = Integer.parseInt(br.readLine());
			
			int[] arr = new int[input + 1];
			arr[1] = 0;
			
			IntStream.rangeClosed(2, input).forEach(i -> {
				arr[i] = arr[i - 1] + 1;
				if(i % 3 == 0 && arr[i] > arr[i / 3] + 1) {
					arr[i] = arr[i / 3] + 1;
				}
				
				if(i % 2 == 0 && arr[i] > arr[i / 2] + 1) {
					arr[i] = arr[i / 2] + 1;
				}
			});
			
			System.out.println(arr[input]);
			
			br.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}		
    }
}



