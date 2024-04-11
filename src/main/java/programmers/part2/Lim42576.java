package programmers.part2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lim42576 {
    public String solution(String[] participant, String[] completion) {
        final List<String> paticipants = Arrays.stream(participant)
            .sorted()
            .collect(Collectors.toList());
        final List<String> completions = Arrays.stream(completion)
            .sorted()
            .collect(Collectors.toList());

        for (int i = 0; i < completions.size(); i++) {
            final String x = paticipants.get(i);
            if (!x.equals(completions.get(i))) {
                return x;
            }
        }

        return paticipants.get(paticipants.size() - 1);
    }
}
