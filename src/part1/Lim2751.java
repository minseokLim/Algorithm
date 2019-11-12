package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lim2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>(n);
		
		for(int i = 0; i < n; i++) { 
			list.add(Integer.parseInt(br.readLine()));
		}
		
		StringBuffer sb = new StringBuffer();
		
		list.stream().sorted().forEach(a -> sb.append(a + "\n"));
		
		System.out.println(sb);
	}
}
