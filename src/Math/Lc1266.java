package Math;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int path = 0;
        int n = points.length;
        if(n <= 1) return 0;
        int x = points[0][0];
        int y = points[0][1];
        for(int i = 1;i < n;i++){
            int x2 = points[i][0];
            int y2 = points[i][1];

            int dx = Math.abs(x2 - x);
            int dy = Math.abs(y2 - y);

            path += Math.max(dx,dy);

            x = x2;
            y = y2;
        }

        return path;
    }
}