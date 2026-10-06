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
//DFS but no stack is required, only need to pick one side per node and don't need the other
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(cur!=null){
            if(p.val>cur.val && q.val>cur.val){
                cur=cur.right;
            }else if(p.val<cur.val && q.val<cur.val){
                cur=cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }
}
