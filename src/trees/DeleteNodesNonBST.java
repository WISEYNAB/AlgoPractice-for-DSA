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
    Set<Integer> set;
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        ans = new ArrayList<>();
        for(int i : to_delete){
            set.add(i);
        }
        helper(root);
        if(!set.contains(root.val)){
            ans.add(root);
        }

        return ans;
    }

    TreeNode helper(TreeNode root){
        if(root == null){
            return root;
        }

        root.left = helper(root.left);
        root.right = helper(root.right);

        if(set.contains(root.val)){
            if(root.left != null){
                ans.add(root.left);
            }

            if(root.right != null){
                ans.add(root.right);
            }

            return null;
        } else {
            return root;
        }
    }


}