package Greedy;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            if(a[1] != b[1]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int p1 = -1,p2 = -1;
        int res = 0;
        for(int[] i : intervals){
            int left = i[0];
            int right = i[1];
            //nothing coincides
            if(left > p2){
                res += 2;
                p1 = right - 1;
                p2 = right;
            }

            //one point coincides
            if(left > p1){
                res += 1;
                p1 = p2;
                p2 = right;
            }
        }

        return res;
    }
}