package dp;

class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp = new Integer[s1.length()][s2.length()];
        return solve(0,s1,0,s2);
    }

    int solve(int i,String s1,int j,String s2){
        if(i == s1.length()){
            int sum = 0;
            for(int k = j;k < s2.length();k++){
                sum += s2.charAt(k);
            }
            return sum;
        }

        if(j == s2.length()){
            int sum = 0;
            for(int k = i;k < s1.length();k++){
                sum += s1.charAt(k);
            }
            return sum;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return solve(i+1,s1,j+1,s2);
        }

        int dfo = s1.charAt(i) + solve(i+1,s1,j,s2);
        int dft = s2.charAt(j) + solve(i,s1,j+1,s2);

        return dp[i][j] = Math.min(dfo,dft);
    }
}