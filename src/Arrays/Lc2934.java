package Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int h = maxCount(hBars);
        int w = maxCount(vBars);

        int side = Math.min(h,w);

        return side * side;
    }

    int maxCount(int[] arr){
        Arrays.sort(arr);
        int max = 1;
        int prev = arr[0];

        int n = arr.length;
        if(n == 1) return 2;
        int count = 1;

        for(int i = 1;i < n;i++){
            if(arr[i] == prev + 1){
                count++;
            } else {
                count = 1;
            }
            prev = arr[i];
            max = Math.max(max,count);
        }

        return max + 1;
    }
}