package Arrays;

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int moves = 0;
        for(int i : nums){
            min = Math.min(min,i);
        }
        for(int i : nums){
            moves += i - min;
        }
        return moves;
    }
}