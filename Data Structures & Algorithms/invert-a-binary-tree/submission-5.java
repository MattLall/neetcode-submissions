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

//depth first search no recursion
//DFS uses a stack
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root!=null){
            stack.push(root);
        }

        while(!stack.isEmpty()){
            TreeNode branch = stack.pop();
            TreeNode tmp = branch.left;
            branch.left=branch.right;
            branch.right=tmp;
            if(branch.right!=null){

                stack.push(branch.right);
            }
            if(branch.left!=null){

                stack.push(branch.left);
            }
            
        }
        return root;
    }
}
