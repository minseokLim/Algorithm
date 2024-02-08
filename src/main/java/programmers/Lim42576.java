package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lim42576 {
    public String solution(String[] participant, String[] completion) {
        final List<String> sortedParticipants = Arrays.stream(participant)
            .sorted()
            .collect(Collectors.toList());
        final List<String> sortedCompletions = Arrays.stream(completion)
            .sorted()
            .collect(Collectors.toList());

        for (int i = 0; i < sortedCompletions.size(); i++) {
            if (!sortedParticipants.get(i).equals(sortedCompletions.get(i))) {
                return sortedParticipants.get(i);
            }
        }
        return sortedParticipants.get(participant.length - 1);
    }
}
