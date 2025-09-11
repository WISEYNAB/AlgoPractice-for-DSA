package trees;



  public class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
     TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
       this.right = right;
    }
 }

class Solution {
    int maxi;
    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;

        int s = solve(root);
        return maxi;
    }

    int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = solve(root.left);
        int r = solve(root.right);

        int only_root = root.val;
        int only_one_path = Math.max(l,r) + root.val;
        int full_path = l + r + root.val;

        maxi = Math.max(Math.max(maxi,only_root),Math.max(only_one_path,full_path));

        return Math.max(only_root,only_one_path);
    }
}