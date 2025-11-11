package dp;

class Solution {
    int l;
    Integer[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        l = strs.length;
        dp = new Integer[l+1][m+1][n+1];
        return solve(0,strs,m,n);
    }

    public int solve(int i,String[] str,int m,int n){
        if(i >= l) return 0;
        if(dp[i][m][n] != null) return dp[i][m][n];
        int ones = 0;
        int zeros = 0;

        String temp = str[i];
        for(char j : temp.toCharArray()){
            if(j == '0'){
                zeros++;
            } else {
                ones++;
            }
        }
        int take = 0,skip = 0;
        if(zeros <= m && ones <= n){
            take = 1 + solve(i + 1,str,m - zeros,n - ones);
        }

        skip = solve(i + 1,str,m,n);

        return dp[i][m][n] = Math.max(skip,take);
    }
}