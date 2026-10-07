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
    public int goodNodes(TreeNode root) {
        int count = 0;
        if(root==null){
            return count;
        }
        
        Deque<Pair<TreeNode,Integer>> stack = new ArrayDeque<>();
        stack.addFirst(new Pair<>(root,root.val));
        int largest = 0;
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> pair = stack.removeFirst();
            TreeNode node = pair.getKey();
            int maxVal = pair.getValue();
            if(maxVal<=node.val){
                count++;
                maxVal=node.val;
            }
            if(node.left!=null)stack.addFirst(new Pair<>(node.left,maxVal));
            if(node.right!=null)stack.addFirst(new Pair<>(node.right,maxVal));
        }
        return count;
    }
}
