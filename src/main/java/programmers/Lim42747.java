package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lim42747 {
    public int solution(int[] citations) {
        final List<Integer> list = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        int answer = 0;

        for (Integer elem : list) {
            if (answer < elem) {
                answer++;
            } else {
                return answer;
            }
        }

        return answer;
    }
}
