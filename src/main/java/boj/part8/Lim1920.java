package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Lim1920 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        final Set<String> set = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toSet());
        br.readLine();
        final String[] inputs = br.readLine().split(" ");
        final StringBuilder result = new StringBuilder();
        for (String input : inputs) {
            result.append(set.contains(input) ? 1 : 0).append("\n");
        }
        System.out.println(result);
    }
}
