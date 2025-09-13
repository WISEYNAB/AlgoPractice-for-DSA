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

//optimal
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
    int m;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        m = k;
        ans = 0;

        traverse(root);
        return ans;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        m--;
        if (m == 0) {
            ans = root.val;
            return;
        }

        traverse(root.right);
    }
}
