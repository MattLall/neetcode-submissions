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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serial=new StringBuilder(0); //# means null, $ means end of value
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if(node==null){
                serial.append("#,");
            }else{

            serial.append(node.val+",");
            queue.addLast(node.left);
            queue.addLast(node.right);
            }
        }
        return serial.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if(vals[0].equals("#"))return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int index=1;
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if(!vals[index].equals("#")){
                node.left=new TreeNode(Integer.parseInt(vals[index]));
                queue.addLast(node.left);
            }
            index++;
            if(!vals[index].equals("#")){
                node.right=new TreeNode(Integer.parseInt(vals[index]));
                queue.addLast(node.right);
            }
            index++;
        }
return root;
    }
}
