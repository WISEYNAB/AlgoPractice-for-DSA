package heap;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        List<Integer> res = new ArrayList<>();
        int l = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });

        while(l <= n - k){
            pq.clear();
            int sum = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            int r = l;

            while(r < n && r <= l + k - 1){
                map.put(nums[r],map.getOrDefault(nums[r],0) + 1);
                r++;
            }

            for(int i : map.keySet()){
                pq.offer(new int[]{i,map.get(i)});
            }

            for(int i = 0; i < x && !pq.isEmpty();i++){
                sum += pq.peek()[0] * pq.poll()[1];
            }

            res.add(sum);
            l++;
        }

        for(int i = 0;i < n - k + 1;i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}