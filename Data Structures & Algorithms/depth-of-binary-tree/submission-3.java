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
//Breadth first search
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        ArrayDeque<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        int maxDepth = 0;
        queue.offerLast(new Pair<>(root,1));
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> node = queue.removeFirst();
            TreeNode branch = node.getKey();
            int depth = node.getValue();
            maxDepth=Math.max(maxDepth,depth);
            if(branch.left!=null) queue.offerLast(new Pair<>(branch.left,depth+1));
            if(branch.right!=null) queue.offerLast(new Pair<>(branch.right,depth+1));
        }

        return maxDepth;
    }
}
