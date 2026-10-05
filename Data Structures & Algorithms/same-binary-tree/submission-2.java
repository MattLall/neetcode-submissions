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
    public boolean isSameTree(TreeNode n1, TreeNode n2) {
        ArrayDeque<Pair<TreeNode,TreeNode>> stack = new ArrayDeque<>();
        stack.addFirst(new Pair<>(n1,n2));

        while(!stack.isEmpty()){
            Pair<TreeNode,TreeNode> pair = stack.pollFirst();
            n1 = pair.getKey();
            n2=pair.getValue();
            if(n1==null && n2==null){
                continue;
            }
            if((n1==null & n2!=null) || (n2==null && n1!=null)){
                return false;
            }

            if(n1.val!=n2.val){
                return false;
            }
            stack.addFirst(new Pair<>(n1.left,n2.left));
            stack.addFirst(new Pair<>(n1.right,n2.right));
        }
        return true;
        
    }
}
