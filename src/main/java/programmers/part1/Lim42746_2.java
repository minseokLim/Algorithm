package programmers.part1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Lim42746_2 {
    public String solution(int[] numbers) {
        final String answer = Arrays.stream(numbers)
            .boxed()
            .sorted((a, b) -> Integer.parseInt(b.toString() + a) - Integer.parseInt(a.toString() + b))
            .map(Object::toString)
            .collect(Collectors.joining());

        if (answer.startsWith("0")) {
            return "0";
        }

        return answer;
    }
}
