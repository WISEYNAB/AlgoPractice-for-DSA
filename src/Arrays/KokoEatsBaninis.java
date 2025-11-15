package Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = piles[0];
        int low = 1;
        int sum = 0;
        for(int i : piles){
            high = Math.max(i,high);
            sum += i;
        }

        int k = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(can(mid,piles,h)){
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return k;
    }

    boolean can(int k,int[] piles,int h){
        int hours = 0;

        for(int i : piles){
            hours += i % k > 0 ? i/k + 1 : i/k;
            if(hours > h) return false;
        }

        return hours <= h;
    }
}