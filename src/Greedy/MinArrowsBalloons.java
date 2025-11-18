package Greedy;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n == 1) return 1;
        int ans = 0;
        Arrays.sort(points,(a,b) -> Integer.compare(a[1],b[1]));
        int i = 0;
        int j = 0;
        while(j < n){
            while(j < n && points[j][0] <= points[i][1]){
                j++;
            }
            ans += 1;
            i = j;
        }
        return ans;
    }
}