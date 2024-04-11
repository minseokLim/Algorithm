package programmers.part2;

import java.util.ArrayList;
import java.util.List;

public class Lim12906 {
    public int[] solution(int[] arr) {
        final List<Integer> list = new ArrayList<>();
        int a = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (a != arr[i + 1]) {
                list.add(a);
            }
            a = arr[i + 1];
        }

        list.add(arr[arr.length - 1]);

        return list.stream()
            .mapToInt(it -> it)
            .toArray();
    }
}
