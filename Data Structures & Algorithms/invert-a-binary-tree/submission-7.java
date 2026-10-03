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
//BFS uses a queue
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root!=null){
            queue.offerLast(root);
        }

        while(!queue.isEmpty()){
            TreeNode branch = queue.pollFirst();
            TreeNode tmp = branch.left;
            branch.left=branch.right;
            branch.right=tmp;
            if(branch.right!=null)queue.offerFirst(branch.right);
            if(branch.left!=null)queue.offerFirst(branch.left);
        }
        return root;
    }
}
