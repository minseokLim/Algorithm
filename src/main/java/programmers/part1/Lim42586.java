package programmers.part1;

import java.util.ArrayList;
import java.util.List;

public class Lim42586 {
    private int progressIdx = 0;
    private int[] realProgresses;
    private List<Integer> answer = new ArrayList<>();

    public int[] solution(int[] progresses, int[] speeds) {
        realProgresses = new int[progresses.length];
        System.arraycopy(progresses, 0, realProgresses, 0, progresses.length);
        while (progressIdx < progresses.length) {
            progress(speeds);
        }
        return answer.stream().mapToInt(it -> it).toArray();
    }

    private void progress(int[] speeds) {
        do {
            for (int i = progressIdx; i < speeds.length; i++) {
                realProgresses[i] += speeds[i];
            }
        } while (realProgresses[progressIdx] < 100);

        var temp = 0;
        while (progressIdx < speeds.length && realProgresses[progressIdx] >= 100) {
            progressIdx++;
            temp++;
        }
        answer.add(temp);
    }
}
