package Arrays;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n < 3) return -1;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            map.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        }
        int dist = Integer.MAX_VALUE;

        for(int i : map.keySet()){
            List<Integer> list = map.get(i);

            int m = list.size();
            if(m >= 3){
                int j = 0;
                while(j <= m - 3){
                    int a = list.get(j);
                    int b = list.get(j + 1);
                    int c = list.get(j + 2);

                    int d = Math.abs(a - b) + Math.abs(b - c) + Math.abs(a - c);

                    dist = Math.min(d,dist);
                    j++;
                }
            }
        }

        return dist == Integer.MAX_VALUE ? -1 : dist;
    }
}