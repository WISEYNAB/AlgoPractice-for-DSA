package dp;
import java.util.Arrays;
class Solution91 {
    int n;
    int[] dp;
    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n + 1];
        Arrays.fill(dp,-1);
        char[] st = s.toCharArray();
        return solve(0,st);
    }

    int solve(int i,char[] st){
        if(i == n){
            return 1;
        }

        if(st[i] == '0'){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int result = solve(i+1,st);
        if(i < n - 1){
            if(st[i] == '1' || st[i] == '2' && st[i + 1] < '7'){
                result += solve(i + 2,st);
            }
        }

        return dp[i] = result;
    }
}