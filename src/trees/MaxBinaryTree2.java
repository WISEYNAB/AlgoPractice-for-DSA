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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> list = new ArrayList<>();
        bda(root,list);
        list.add(val);
        int n = list.size();
        return build(list,0,n - 1);
    }

    void bda(TreeNode root,List<Integer> list){
        if(root == null) return;
        bda(root.left,list);
        list.add(root.val);
        bda(root.right,list);
    }

    TreeNode build(List<Integer> list,int start,int end){
        if(start > end) return null;
        int max = -1;
        for(int i = start;i <= end;i++){
            if(max == -1 || list.get(i) > list.get(max)){
                max = i;
            }
        }
        TreeNode root = new TreeNode(list.get(max));
        root.left = build(list,start,max - 1);
        root.right = build(list,max + 1,end);
        return root;
    }
}