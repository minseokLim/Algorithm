package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11652 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] cards = new long[n];
		
		for(int i = 0; i < n; i++) {
			cards[i] = Long.parseLong(br.readLine());
		}
		
//		Arrays.sort(cards);
		mergeSort(cards, 0, n - 1);
		
		long answer = cards[0];
		int cnt = 1;
		int max = 0;
		
		for(int i = 1; i < n; i++) {
			if(cards[i - 1] == cards[i]) {
				cnt++;
			} else {
				if(max < cnt) {
					max = cnt;
					answer = cards[i - 1];
				}
				
				cnt = 1;
			}
		}
		
		if(max < cnt) {
			answer = cards[n - 1];
		}
		
		System.out.println(answer);
	}

	private static void mergeSort(long[] cards, int s, int e) {
		if(s < e) {
			int m = (s + e) / 2;
			
			mergeSort(cards, s, m);
			mergeSort(cards, m + 1, e);
			
			merge(cards, s, e, m);
		}
	}

	private static void merge(long[] cards, int s, int e, int m) {
		long[] tmp = new long[e - s + 1];
		
		int i = s;
		int j = m + 1;
		int k = 0;
		
		while(i <= m && j <= e) {
			if(cards[i] < cards[j]) {
				tmp[k++] = cards[i++];
			} else {
				tmp[k++] = cards[j++];
			}
		}
		
		while(i <= m) {
			tmp[k++] = cards[i++];
		}
		
		while(j <= e) {
			tmp[k++] = cards[j++];
		}
		
		System.arraycopy(tmp, 0, cards, s, tmp.length);
	}
}
