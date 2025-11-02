package Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if(nums1[i] > nums2[j]){
                list.add(nums2[j]);
                j++;
            } else {
                list.add(nums1[i]);
                i++;
            }
        }

        while(i < n){
            list.add(nums1[i]);
            i++;
        }

        while(j < m){
            list.add(nums2[j]);
            j++;
        }
        double median = 0;
        int size = list.size();
        if(size % 2 == 1){
            median = (double) list.get(size/2);
        } else {
            median = (double) ((list.get(size/2) + list.get(size/2 - 1))/2.0);
        }

        return median;
    }
}