package Arrays;

class Solution1304 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int j = 1;
        if(n % 2 == 1){
            ans[n/2] = 0;
            for(int i = n/2 + 1;i < n;i++){
                ans[i] = j++;
            }
            j -= 1;
            for(int i = 0;i < n/2;i++){
                ans[i] = -(j--);
            }
        } else {
            for(int i = n/2;i < n;i++){
                ans[i] = j++;
            }
            j -= 1;
            for(int i = 0;i < n/2;i++){
                ans[i] = -(j--);
            }
        }

        return ans;
    }
}