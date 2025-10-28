package Arrays;

class Solution {
    int n;
    public int countValidSelections(int[] nums) {
        n = nums.length;
        int ans = 0;

        for(int i = 0;i < n;i++){
            if(nums[i] == 0){
                ans += simulate('l',nums,i);
                ans += simulate('r',nums,i);
            }
        }
        return ans;
    }

    int simulate(char dir,int[] nums,int i){
        int j = i;
        int[] num = nums.clone();
        while(j >= 0 && j < n){
            if(num[j] == 0){
                if(dir == 'l'){
                    j--;
                } else {
                    j++;
                }
            } else {
                num[j] -= 1;
                j = dir == 'l' ? j + 1 : j - 1;
                dir = dir == 'l' ? 'r' : 'l';
            }
        }

        for(int a : num){
            if(a != 0){
                return 0;
            }
        }

        return 1;
    }
}