package programmers;

import java.util.Stack;

public class Lim12909 {
    boolean solution(String s) {
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '(') {
                stack.push(1);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
