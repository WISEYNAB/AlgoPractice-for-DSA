package Arrays;

class Solution {
    public int countCollisions(String dir) {
        int stationary = 0;
        int right = 0;
        int left = 0;

        int count = 0;

        for(char i : dir.toCharArray()){
            if(i == 'R'){
                right++;
            } else if(i == 'L'){
                if(right > 0){
                    count += right + 1;
                    right = 0;
                    stationary = 1;
                } else if(stationary > 0){
                    count += 1;
                    stationary = 1;
                }
            } else {
                if(right > 0){
                    count += right;
                    right = 0;
                }
                stationary = 1;
            }
        }

        return count;
    }
}