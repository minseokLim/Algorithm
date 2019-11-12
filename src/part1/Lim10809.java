package part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lim10809 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int len = s.length();
		int[] pos = new int['z' - 'a' + 1];
		
		for(int i = 0; i < pos.length; i++) {
			pos[i] = -1;
		}
		
		for(int i = 0; i < len; i++) {
			
			if(pos[s.charAt(i) - 97] == -1) {
				pos[s.charAt(i) - 97] = i;
			}
		}
		
		for(int i = 0; i < pos.length; i++) {
			bw.write(pos[i] + " ");
		}
		
		bw.flush();
		br.close();
	}
}
