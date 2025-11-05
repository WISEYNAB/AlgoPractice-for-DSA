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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0L));
        int width = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> curr = q.poll();
                TreeNode node = curr.getKey();
                long index = curr.getValue();

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null)
                    q.offer(new Pair<>(node.left, 2 * index + 1));
                if (node.right != null)
                    q.offer(new Pair<>(node.right, 2 * index + 2));
            }

            width = Math.max(width, (int)(last - first + 1));
        }

        return width;
    }
}
