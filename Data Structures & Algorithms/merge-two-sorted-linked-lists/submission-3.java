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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode out = new ListNode();
        ListNode p1 = list1;
        ListNode p2 = list2;
        if (p1 == null && p2 == null) {
            return null;
        }
        if (p1 == null) {
            out.val = p2.val;
            p2 = p2.next;
        } else if (p2 == null) {
            out.val = p1.val;
            p1 = p1.next;
        }else if (p1.val <= p2.val) {
            out.val = p1.val;
            p1 = p1.next;

        } else {
            out.val = p2.val;
            p2 = p2.next;
        }

        ListNode outNext = out;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                outNext.next = p2;
                // System.out.println(p2.val);
                p2 = p2.next;
            } else if (p2 == null) {
                outNext.next = p1;
                // System.out.println(p1.val);
                p1 = p1.next;
            } else if (p1.val <= p2.val) {
                // System.out.println("-"+p1.val);
                outNext.next = p1;
                // System.out.println("-"+outNext.next.val);
                // System.out.println(p1.val);
                p1 = p1.next;

            } else {
                outNext.next = p2;
                // System.out.println(p2.val);
                p2 = p2.next;
            }
            // System.out.println(outNext.next.val);
            outNext = outNext.next;
            // System.out.println(outNext.val);
        }

        return out;
    }
}