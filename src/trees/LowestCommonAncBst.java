package trees;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcs(root,p,q);
    }

    TreeNode lcs(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lcs(root.left,p,q);
        TreeNode right = lcs(root.right,p,q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }
}