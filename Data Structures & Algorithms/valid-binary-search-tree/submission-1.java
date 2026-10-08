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
//BFS
class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<Pair<TreeNode, int[]>> queue = new ArrayDeque<>();
        queue.addLast(new Pair<>(root, new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));

        while (!queue.isEmpty()) {
            Pair<TreeNode, int[]> pair = queue.removeFirst();
            TreeNode node = pair.getKey();
            int[] bounds = pair.getValue();
            if (node.val > bounds[0] && node.val < bounds[1]) {
                if (node.left != null)
                    queue.addLast(new Pair<>(node.left, new int[] {bounds[0], node.val}));
                if (node.right != null)
                    queue.addLast(new Pair<>(node.right, new int[] {node.val, bounds[1]}));
            } else {
                return false;
            }
        }
        return true;
    }
}