package programmers.part2;

import java.util.Arrays;
import java.util.HashMap;

public class Lim176963 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        final var scores = new HashMap<String, Integer>();
        for (int i = 0; i < name.length; i++) {
            scores.put(name[i], yearning[i]);
        }

        return Arrays.stream(photo)
            .mapToInt(p -> Arrays.stream(p).mapToInt(it -> scores.getOrDefault(it, 0)).sum())
            .toArray();
    }
}
