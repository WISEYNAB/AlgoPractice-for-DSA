package Arrays;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i : nums){
            max = Math.max(i,max);
            min = Math.min(i,min);
            set.add(i);
        }

        for(int i = min;i <= max;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }
}