/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node out =new Node(0);
        Node dummy;
        while(head!=null){
            dummy=getCopy(map,head);
            if(out.next==null){
                out.next=dummy;
            }
            dummy.random=head.random==null ? null : getCopy(map,head.random);
            dummy.next=head.next==null ? null : getCopy(map,head.next);
            dummy=dummy.next;
            head=head.next;
        }
        return out.next;

    }

    public Node getCopy(Map<Node,Node> map,Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }else{
            Node n = new Node (node.val);
            map.put(node,n);
            return n;
        }
    }
}
