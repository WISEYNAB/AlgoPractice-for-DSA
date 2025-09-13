package trees;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    PriorityQueue<Integer> pq;
    public int kthSmallest(TreeNode root, int k) {
        pq = new PriorityQueue();
        traverse(root);
        int ans = 0;
        while(k > 0){
            ans = pq.poll();
            k--;
        }

        return ans;
    }

    void traverse(TreeNode root){
        if(root == null){
            return;
        }
        pq.offer(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}