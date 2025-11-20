package Greedy;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g = 0;
        int c = 0;
        int n = gas.length;
        for(int i = 0;i < n;i++){
            g += gas[i];
            c += cost[i];
        }

        if(c > g) return -1;

        int ans = 0;
        int curr = 0;
        for(int i = 0;i < n;i++){
            curr = curr + gas[i] - cost[i];
            if(curr < 0){
                ans = i + 1;
                curr = 0;
            }
        }

        return ans;
    }
}