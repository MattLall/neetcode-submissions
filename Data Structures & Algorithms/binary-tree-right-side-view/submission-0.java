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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if(root==null) return out;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode node=null;
            for(int i =queue.size(); i>0;i--){
                node=queue.removeFirst();
                if(node.left!=null)queue.addLast(node.left);
                if(node.right!=null)queue.addLast(node.right);
                
            }
            out.add(node.val);
        }

        return out;
    }
}
