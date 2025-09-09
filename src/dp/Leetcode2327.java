package dp;
import java.util.Arrays;
class Solution2327 {
    int[] dp;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int total = 0;
        int m = 1000000007;
        dp = new int[n + 1];
        Arrays.fill(dp,-1);
        for(int i = n - forget + 1;i <= n;i++){
            if(i > 0){
                total = (total + solve(i,delay,forget)) % m;
            }
        }

        return total;
    }

    int solve(int day,int delay,int forget){
        if(day == 1){
            return 1;
        }

        if(dp[day] != -1){
            return dp[day];
        }
        int result = 0;
        for(int i = day - forget + 1;i <= day - delay;i++){
            if(i > 0){
                result = result + solve(i,delay,forget);
            }
        }

        return dp[day] = result;
    }
}