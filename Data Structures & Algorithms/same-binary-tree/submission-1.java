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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if((p==null && q!=null) || (p!=null && q==null)){
            return false;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(q);
        stack.addFirst(p);

        while(!stack.isEmpty()){
            p=stack.pollFirst();
            q=stack.pollFirst();
            if((p==null && q!=null) || (q==null && p!=null)){
                return false;
            }
            if(p==null && q==null){
                continue;
            }
            System.out.println(p.val + " "+ q.val);
            if(p.val!=q.val){
                return false;
            }
            if(p.left!=null && q.left!=null){
                if(p.left.val!=q.left.val){
                    return false;
                }
                stack.addFirst(p.left);
                stack.addFirst(q.left);
            }else{
                if(p.left!=null || q.left!=null){
                    return false;
                }
            }
            if(p.right!=null && q.right!=null){
                if(p.right.val!=q.right.val){
                    return false;
                }
                stack.addFirst(p.right);
                stack.addFirst(q.right);
            }else{
                if(p.right!=null || q.right!=null){
                    return false;
                }
            }

        }

        return true;
    }
}
