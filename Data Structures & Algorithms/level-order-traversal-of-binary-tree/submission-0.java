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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        int currentLevel=0;
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> cur = new ArrayList();

        queue.addLast(new Pair<>(root,0));
        while(!queue.isEmpty()){
            
            Pair<TreeNode,Integer> pair = queue.removeFirst();
            TreeNode node = pair.getKey();
            int level = pair.getValue();
            if(node==null)continue;

            if(level!=currentLevel){
                currentLevel = level;
                out.add(cur);
                cur=new ArrayList<>();

            }
            cur.add(node.val);
            if(node.left!=null) queue.addLast(new Pair<>(node.left,level+1));
            if(node.right!=null) queue.addLast(new Pair<>(node.right,level+1));

        }
        if(cur.size()>0){
            out.add(cur);
        }
        return out;
    }
}
