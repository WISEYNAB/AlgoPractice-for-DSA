package Arrays.prefixsum;

class Solution {
    public int bestClosingTime(String cus) {
        int n = cus.length();
        int[] penalty = new int[n+1];
        penalty[n] = 0;
        for(int i = n - 1;i >= 0;i--){
            if(cus.charAt(i) == 'Y'){
                penalty[i] = penalty[i+1] + 1;
            } else {
                penalty[i] = penalty[i+1];
            }
        }
        int countn = 0;
        int min = n;
        for(int i = 0;i < n;i++){
            penalty[i] = penalty[i] + countn;
            if(cus.charAt(i) == 'N'){
                countn++;
            }
            min = Math.min(min,penalty[i]);
        }

        penalty[n] = penalty[n] + countn;
        if(penalty[n] < min || countn == 0) return n;
        for(int i = 0;i <= n;i++){
            if(penalty[i] == min){
                return i;
            }
        }

        return 0;
    }
}