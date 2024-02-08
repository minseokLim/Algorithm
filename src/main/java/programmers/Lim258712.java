package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lim258712 {
    public int solution(String[] friends, String[] gifts) {
        final Map<String, Integer> friendsMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendsMap.put(friends[i], i);
        }

        final int[][] giftRecords = new int[friends.length][friends.length];
        for (String gift : gifts) {
            final String[] info = gift.split(" ");
            giftRecords[friendsMap.get(info[0])][friendsMap.get(info[1])]++;
        }

        final int[] giftScores = new int[friends.length];
        for (int i = 0; i < giftScores.length; i++) {
            giftScores[i] = computeGiftScore(i, giftRecords);
        }

        final int[] giftCount = new int[friends.length];
        for (int i = 0; i < giftCount.length; i++) {
            giftCount[i] = computeGiftCount(i, giftRecords, giftScores);
        }

        return Arrays.stream(giftCount).max().getAsInt();
    }

    private int computeGiftScore(int targetIndex, int[][] giftRecords) {
        final var given = Arrays.stream(giftRecords[targetIndex]).sum();

        var received = 0;
        for (int i = 0; i < giftRecords.length; i++) {
            received += giftRecords[i][targetIndex];
        }

        return given - received;
    }

    private int computeGiftCount(int targetIndex, int[][] giftRecords, int[] giftScores) {
        var answer = 0;

        for (int i = 0; i < giftScores.length; i++) {
            if (giftRecords[targetIndex][i] > giftRecords[i][targetIndex]) {
                answer++;
            } else if (giftRecords[targetIndex][i] == giftRecords[i][targetIndex]) {
                if (giftScores[targetIndex] > giftScores[i]) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
