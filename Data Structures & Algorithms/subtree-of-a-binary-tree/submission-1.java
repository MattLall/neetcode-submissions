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
// Serialisation
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String root_s = serialise(root);
        String subRoot_s = serialise(subRoot);
        return root_s.contains(subRoot_s);
    }

    public void serialise(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("#$");
            return;
        }

        res.append(root.val + "$");

        serialise(root.left, res);
        serialise(root.right, res);
    }
    public String serialise(TreeNode root){
        StringBuilder res = new StringBuilder();
        serialise(root,res);
        return res.toString();
    }
}
