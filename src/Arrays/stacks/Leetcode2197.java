package Arrays.stacks;
import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Long> stack = new ArrayList<>();

        for (int v : nums) {
            long cur = v;
            while (!stack.isEmpty()) {
                long top = stack.get(stack.size() - 1);
                long g = gcd(top, cur);
                if (g == 1) break;
                stack.remove(stack.size() - 1);
                // correct LCM formula: (top / g) * cur
                cur = (top / g) * cur;
            }
            stack.add(cur);
        }

        // convert to List<Integer> if problem requires integers
        List<Integer> result = new ArrayList<>(stack.size());
        for (long x : stack) result.add((int) x);
        return result;
    }

    private long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
