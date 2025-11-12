package stack;
import java.util.*;


class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (char i : s.toCharArray()) {
            if (!stack.isEmpty() && i == stack.peek().getKey()) {
                if (stack.peek().getValue() == k - 1) {
                    for (int j = 1; j < k && !stack.isEmpty(); j++) { // renamed inner loop variable
                        stack.pop();
                    }
                } else {
                    stack.push(new Pair<>(i, stack.peek().getValue() + 1));
                }
            } else {
                stack.push(new Pair<>(i, 1));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop().getKey());
        }

        return sb.reverse().toString();
    }
}
