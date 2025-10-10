package Arrays.prefixsum;

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] pre = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            int j = i;
            while(j < n){
                pre[i] = pre[i] + energy[j];
                j += k;
            }
            max = Math.max(max,pre[i]);
        }

        return max;
    }
}