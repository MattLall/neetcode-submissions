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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        return rev(null,head);
    }

    public ListNode rev(ListNode prev,ListNode head){
        ListNode next = head.next;
        head.next=prev;
        if(next==null){
            ListNode node = new ListNode(head.val,head.next);
            return node;
        }else{
            ListNode node = rev(head,next);
            return node;
        }
    }
}
