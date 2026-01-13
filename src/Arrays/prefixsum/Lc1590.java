package Arrays.prefixsum;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int i : nums){
            sum = (sum + i) % p;
        }

        if(sum == 0) return 0;

        int req = sum % p;

        int curr = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int minl = nums.length;
        for(int i = 0;i < nums.length;i++){
            curr = (curr + nums[i]) % p;
            int target = (curr - req + p) % p;
            if(map.containsKey(target)){
                minl = Math.min(minl,i - map.get(target));
            }
            map.put(curr,i);
        }
        return minl == nums.length ? -1 : minl;
    }
}