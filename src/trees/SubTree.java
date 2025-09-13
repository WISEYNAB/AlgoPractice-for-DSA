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
class SolutionSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return find(root,subRoot);
    }

    boolean sameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }

        return sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }

    boolean find(TreeNode root,TreeNode subRoot){
        if(root == null){
            return false;
        }

        if(root.val == subRoot.val && sameTree(root,subRoot)){
            return true;
        }

        return find(root.left,subRoot) || find(root.right,subRoot);
    }
}