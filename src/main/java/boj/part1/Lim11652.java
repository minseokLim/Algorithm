package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Lim11652 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		for(int i = 0; i < n; i++) {
			Long x = Long.parseLong(br.readLine());
			
			if(map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		}
		
		Iterator<Entry<Long, Integer>> it = map.entrySet().iterator();
		Entry<Long, Integer> max = it.next();
		
		while(it.hasNext()) {
			Entry<Long, Integer> tmp = it.next();
			
			if(max.getValue() < tmp.getValue() || (max.getValue().equals(tmp.getValue()) && max.getKey() > tmp.getKey())) {
				max = tmp;
			} 
		}
		
		System.out.println(max.getKey());
	}
}
