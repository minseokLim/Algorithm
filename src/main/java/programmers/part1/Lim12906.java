package programmers.part1;

import java.util.ArrayList;

public class Lim12906 {
    public int[] solution(int[] arr) {
        final var answer = new ArrayList<Integer>();
        var before = -1;
        for (int elem : arr) {
            if (elem != before) {
                answer.add(elem);
                before = elem;
            }
        }

        return answer.stream()
            .mapToInt(it -> it)
            .toArray();
    }
}
