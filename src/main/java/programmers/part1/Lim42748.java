package programmers.part1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lim42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            final List<Integer> subList = Arrays.stream(array).boxed().collect(Collectors.toList())
                .subList(commands[i][0] - 1, commands[i][1]);
            subList.sort(Comparator.naturalOrder());

            answer[i] = subList.get(commands[i][2] - 1);
        }

        return answer;
    }
}
