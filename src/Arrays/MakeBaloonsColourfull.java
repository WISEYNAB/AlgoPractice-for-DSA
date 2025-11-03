package Arrays;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        char[] arr = colors.toCharArray();
        int n = arr.length;
        int l = 0;

        if(n == 1) return 0;
        while(l < n){
            int r = l;
            int sum = 0;
            int max = 0;
            while(r < n && arr[l] == arr[r]){
                sum += neededTime[r];
                max = Math.max(max,neededTime[r]);
                r++;
            }

            ans += sum - max;
            l = r;
        }

        return ans;
    }
}