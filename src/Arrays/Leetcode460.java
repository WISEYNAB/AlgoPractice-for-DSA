package Arrays;
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] candidates = new int[n+1];
        for(int i = 1;i <= n;i++){
            candidates[i] = i;
        }
        return bs(candidates,nums);
    }

    boolean solve(List<Integer> nums, int k) {
        int curr = 1;
        int prev = 0;
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                curr++;
            } else {
                prev = curr;
                curr = 1;
            }

            if (curr >= 2 * k) {
                return true;
            }

            if (Math.min(curr, prev) >= k) {
                return true;
            }
        }

        return false;
    }

    int bs(int[] candidates, List<Integer> nums) {
        int low = 0, high = candidates.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (solve(nums, candidates[mid])) {
                ans = candidates[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}