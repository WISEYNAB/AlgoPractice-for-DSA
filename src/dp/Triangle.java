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
//bottom up

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> ans = triangle;
        int n = triangle.size();
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                ans.get(row).set(col,ans.get(row).get(col) + Math.min(
                        ans.get(row + 1).get(col), ans.get(row + 1).get(col + 1)));
            }
        }

        return ans.get(0).get(0);
    }
}