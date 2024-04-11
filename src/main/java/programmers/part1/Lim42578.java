package programmers.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lim42578 {
    int answer = 0;

    public int solution(String[][] clothes) {
        final var countMap = new HashMap<String, Integer>();
        for (String[] clothe : clothes) {
            countMap.merge(clothe[1], 1, Integer::sum);
        }

        final List<Integer> counts = new ArrayList<>(countMap.values());
        for (int i = 0; i < counts.size(); i++) {
            solve(i, 1, counts);
        }

        return answer;
    }

    private void solve(int idx, int value, List<Integer> counts) {
        final int temp = value * counts.get(idx);
        answer += temp;

        for (int i = idx + 1; i < counts.size(); i++) {
            solve(i, temp, counts);
        }
    }
}
