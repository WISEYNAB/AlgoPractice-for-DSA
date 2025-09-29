package dp;
import java.util.List;

class Solution {
    int n;
    int m;
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        m = triangle.get(n - 1).size();
        memo = new Integer[n + 1][m + 1];
        return solve(triangle, 0, 0);
    }

    int solve(List<List<Integer>> tri, int i, int j) {
        if (i == n -1) {
            return tri.get(i).get(j);
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        int same = solve(tri, i + 1, j);
        int next = solve(tri, i + 1, j + 1);

        return memo[i][j] = tri.get(i).get(j) + Math.min(same, next);
    }
}
