package dp;
class Solution {
    Map<Integer, Integer> map;
    int[] arr;
    int m;
    Long[] memo;

    public long maximumTotalDamage(int[] power) {
        map = new HashMap<>();
        for (int num : power) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        arr = map.keySet().stream().mapToInt(x -> x).toArray();
        Arrays.sort(arr);
        m = arr.length;


        memo = new Long[m];
        return solve(0);
    }

    private long solve(int i) {
        if (i >= m) return 0;

        if (memo[i] != null) return memo[i];


        long skip = solve(i + 1);


        long take = (long) arr[i] * map.get(arr[i]);
        int left = i + 1;
        int right = m;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= arr[i] + 2){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        take += solve(left);


        memo[i] = Math.max(take, skip);
        return memo[i];
    }
}
