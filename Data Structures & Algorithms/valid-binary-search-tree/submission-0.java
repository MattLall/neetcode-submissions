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
    public boolean isValidBST(TreeNode root) {
        Deque<Pair<TreeNode, int[]>> stack = new ArrayDeque<>();
        stack.addLast(new Pair<>(root, new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));

        while (!stack.isEmpty()) {
            Pair<TreeNode, int[]> pair = stack.removeLast();
            TreeNode node = pair.getKey();
            int[] bounds = pair.getValue();
            if (node.val > bounds[0] && node.val < bounds[1]) {
                if (node.left != null)
                    stack.addLast(new Pair<>(node.left, new int[] {bounds[0], node.val}));
                if (node.right != null)
                    stack.addLast(new Pair<>(node.right, new int[] {node.val, bounds[1]}));
            } else {
                return false;
            }
        }
        return true;
    }
}