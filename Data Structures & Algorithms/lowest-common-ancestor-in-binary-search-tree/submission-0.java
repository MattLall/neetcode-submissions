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
// Binary search tree
// Everything left of a node is lower than it, everything right is higher than it
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();

            if ((p.val < node.val && q.val > node.val) || (q.val < node.val && p.val > node.val)) {
                return node;
            }
            if (p.val == node.val || q.val == node.val) {
                return node;
            }
            if (node.left != null && p.val < node.val) {
                stack.addFirst(node.left);
            } else {
                stack.addFirst(node.right);
            }
        }

        return root.right;
    }
}
