package Arrays;

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long l = batteries[0];
        long r = 0;
        for(int i : batteries){
            l = Math.min(i,l);
            r += i;
        }

        r /= n;
        //bs
        long result = 0;
        while(l <= r){
            long mid = l + (r - l)/2;

            if(possible(mid,batteries,n)){
                l = mid + 1;
                result = mid;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }

    boolean possible(long mid,int[] bat,int n){
        long minu = n * mid;

        for(int i = 0;i < bat.length;i++){
            minu -= Math.min(bat[i],mid);

            if(minu <= 0){
                return true;
            }
        }

        return false;
    }
}