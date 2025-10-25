package Math;

class Solution {
    public int totalMoney(int n) {
        int ct = (int) n / 7;
        int mon = 1;
        int sum = 0;
        while(ct > 0){
            sum += (int)(7 * (mon + (mon + 6))/2);
            mon++;
            ct--;
        }

        int rem = n % 7;
        if(rem > 0){
            sum += (int)(rem * (mon + (mon + (rem - 1)))/2);
        }
        return sum;
    }
}