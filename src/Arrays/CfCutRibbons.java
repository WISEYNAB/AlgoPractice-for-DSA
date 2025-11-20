import java.util.*;

public class Main {

    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        arr = new int[]{a, b, c};
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        System.out.println(solve(n));
    }

    static int solve(int n) {
        // base cases
        if (n == 0) return 0;
        if (n < 0) return Integer.MIN_VALUE; // invalid

        if (dp[n] != Integer.MIN_VALUE) return dp[n];

        int best = Integer.MIN_VALUE;

        for (int len : arr) {
            int res = solve(n - len);
            if (res != Integer.MIN_VALUE) {
                best = Math.max(best, res + 1);
            }
        }

        dp[n] = best;
        return dp[n];
    }
}
