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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null){
            return false;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if(node.val==subRoot.val){
                ArrayDeque<Pair<TreeNode,TreeNode>> compQueue = new ArrayDeque<>();
                TreeNode n2 = subRoot;
                TreeNode n1 = node;
                compQueue.addLast(new Pair<>(n1,n2));
                boolean match=true;
                while(!compQueue.isEmpty()){
                    Pair<TreeNode,TreeNode> pair = compQueue.removeFirst();
                    n1=pair.getKey();
                    n2=pair.getValue();
                    if(n1==null && n2==null){
                        continue;
                    }
                    if((n1==null && n2!=null) || (n2==null && n1!=null)){
                        match=false;
                        break;
                    }
                    if(n1.val!=n2.val){
                        match=false;
                        break;
                    }
                    compQueue.add(new Pair<>(n1.left,n2.left));
                    compQueue.add(new Pair<>(n1.right,n2.right));
                }
                if(match){
                    return true;
                }

            }

            if(node.left!=null)queue.addFirst(node.left);
            if(node.right!=null)queue.addFirst(node.right);
            
        }
        return false;
    }
}
