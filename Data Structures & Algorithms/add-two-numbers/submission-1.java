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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode out = new ListNode(0);
        ListNode dummy = out;
        while (l1 != null || l2 != null || carry!=0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            l1=l1!=null ? l1.next:null;
            l2=l2!=null ? l2.next:null;
            carry = sum/10;

            sum = sum % 10;
            dummy.next = new ListNode(sum);
            dummy=dummy.next;
        }
        // if(carry!=0){
        //     dummy.next=new ListNode(1);
        // }

        return out.next;
    }
}
