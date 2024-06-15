package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Lim18870 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        final int[] points = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        final int[] distinctSortedPoints = Arrays.stream(points)
            .distinct()
            .sorted()
            .toArray();
        final Map<Integer, Integer> xToIndex = new HashMap<>();
        for (int i = 0; i < distinctSortedPoints.length; i++) {
            xToIndex.put(distinctSortedPoints[i], i);
        }

        final String result = Arrays.stream(points)
            .mapToObj(it -> xToIndex.get(it).toString())
            .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
