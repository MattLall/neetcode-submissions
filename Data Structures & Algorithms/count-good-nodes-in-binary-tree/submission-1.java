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
        
        Deque<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        queue.addLast(new Pair<>(root,root.val));
        int largest = 0;
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> pair = queue.removeFirst();
            TreeNode node = pair.getKey();
            int maxVal = pair.getValue();
            if(maxVal<=node.val){
                count++;
                maxVal=node.val;
            }
            if(node.left!=null)queue.addLast(new Pair<>(node.left,maxVal));
            if(node.right!=null)queue.addLast(new Pair<>(node.right,maxVal));
        }
        return count;
    }
}
