package Arrays;

class Solution1317 {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if(cz(i) || cz(n - i)){
                continue;
            } else {
                return new int[]{i,n-i};
            }
        }
        return new int[]{0,0};
    }

    boolean cz(int x) {
        while(x > 0){
            if(x % 10 == 0){
                return true;
            }
            x /= 10;
        }

        return false;
    }
}