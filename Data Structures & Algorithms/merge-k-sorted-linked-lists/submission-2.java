/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        ListNode node = new ListNode(0);
        ListNode out = node;
        int index=nextIndex(lists);
        while(index!=-1){
            node.next=lists[index];
            lists[index]=lists[index].next;
            node=node.next;
            index = nextIndex(lists);
            // System.out.println(index);

        }

    return out.next;

    }

    static int nextIndex(ListNode[] lists){
        int lowestIndex = -1;
        for(int i = 0;i<lists.length;i++){
            if(lists[i]==null){
                continue;
            }
            if(lowestIndex==-1 || lists[lowestIndex].val>lists[i].val){
                lowestIndex=i;
            }
        }
        return lowestIndex;
    }
}
