package dp;

class Solution {
    public int maxProfit(int[] nums) {
        int profit = 0;
        int price = Integer.MAX_VALUE;
        int n = nums.length;
        for (int num : nums) {
            price = Math.min(price, num);
            profit = Math.max(profit, num - price);
        }
        return profit;
    }
}