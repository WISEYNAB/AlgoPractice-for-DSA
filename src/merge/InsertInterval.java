package merge;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        while(i < n){
            int[] interval = intervals[i];
            if(interval[1] < newInterval[0]){
                list.add(interval);
                i++;
            } else if(interval[0] > newInterval[1]){
                break;
            } else {
                newInterval[0] = Math.min(interval[0],newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
                i++;
            }
        }

        list.add(newInterval);

        while(i < n){
            int[] interval = intervals[i];
            list.add(interval);
            i++;
        }


        int m = list.size();
        int[][] ans = new int[m][2];
        for(int j = 0;j < m;j++){
            ans[j] = list.get(j);
        }

        return ans;
    }
}