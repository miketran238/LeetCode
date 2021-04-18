/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = new ListNode(0), nTh = head;
        prev.next = head;
        boolean isHead = false;
        while ( curr!= null ) {
            if( n == 0 ) {
                n++;
                //Move the two marker
                isHead = true;
                prev = prev.next;
                nTh = nTh.next;
            }
            n--;
            curr = curr.next;
        }
        curr = nTh.next;
        prev.next = curr;
        nTh = null;
        if ( n == 0 && !isHead ) return head.next;
        return head;
    }
}
