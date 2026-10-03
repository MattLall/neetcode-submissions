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
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root!=null){
            queue.push(root);
        }

        while(!queue.isEmpty()){
            TreeNode branch = queue.pop();
            TreeNode tmp = branch.left;
            branch.left=branch.right;
            branch.right=tmp;
            if(branch.right!=null){

                queue.push(branch.right);
            }
            if(branch.left!=null){

                queue.push(branch.left);
            }
            
        }
        return root;
    }
}
