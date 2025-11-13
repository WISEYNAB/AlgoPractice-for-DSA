package Arrays;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftm = new int[n];
        int[] rightm = new int[n];
        leftm[0] = height[0];
        rightm[n - 1] = height[n - 1];
        for(int i = 1;i < n;i++){
            leftm[i] = Math.max(leftm[i -1],height[i-1]);
        }

        for(int i = n - 2;i >= 0;i--){
            rightm[i] = Math.max(rightm[i + 1],height[i+1]) ;
        }

        int trapped = 0;

        for(int i = 0;i < n;i++){
            int tp = Math.min(leftm[i],rightm[i]) - height[i];

            if(tp > 0) trapped += tp;
        }

        return trapped;
    }
}