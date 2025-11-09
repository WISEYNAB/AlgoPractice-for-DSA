package dp;
class Solution {
    int[][] gridy;
    int n;
    int m;
    int K;
    Integer[][][] memo;
    public int maxPathScore(int[][] grid, int k) {
        K = k;
        gridy = grid;
        m = gridy.length;
        n = gridy[0].length;
        memo = new Integer[m + 1][n + 1][k + 1];

        int res = dfs(0,0,0);
        return res;
    }

    int dfs(int i, int j,int cost){
        if(i >= m || j >= n) return -1;

        int cell = gridy[i][j];
        int addScore = cell == 0 ? 0 : cell == 2 ? 2 : 1;
        int addCost = cell == 0 ? 0 : 1;
        cost += addCost;

        if(cost > K) return -1;

        if(i == m - 1 && j == n - 1) return addScore;

        if(memo[i][j][cost] != null) return memo[i][j][cost];

        int right = dfs(i,j+1,cost);
        int down = dfs(i + 1,j,cost);
        if(Math.max(right,down) == -1) return memo[i][j][cost] = -1;

        return memo[i][j][cost] =  Math.max(right,down) + addScore;
    }
}