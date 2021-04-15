/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode fakeHead = left;
        ListNode right = new ListNode(0);
        ListNode saveRight = right;
        while ( head != null ) {
            if ( head.val < x ) {
                //ListNode toL = new ListNode(head.val);
                left.next = head;
                left = left.next;
            } else {
                //ListNode toR = new ListNode(head.val);
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next=null;
        left.next = saveRight.next;
        return fakeHead.next;
    }
}
