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
 //Depth first search no recursion
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        ArrayDeque<Pair<TreeNode,Integer>> stack = new ArrayDeque<>();
        stack.add(new Pair<>(root,1));
        int maxDepth=0;

        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> node = stack.pop();
            TreeNode branch = node.getKey();
            int depth = node.getValue();
            maxDepth=Math.max(maxDepth,depth);
            if(branch.left!=null) stack.push(new Pair<>(branch.left,1+depth));
            if(branch.right!=null) stack.push(new Pair<>(branch.right,1+depth));
        }

        return maxDepth;


    }
}
