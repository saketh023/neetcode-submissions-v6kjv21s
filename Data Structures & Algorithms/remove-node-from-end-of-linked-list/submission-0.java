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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;
        int size=0;
        while(curr != null){
            curr = curr.next;
            size++;
        }

        int position = size-n+1;

        curr = head;
        int count = 0;

        if(position == 1){
            head = head.next;
            return head;
        }
        while(curr != null){
            if(count == position-1){
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }

        return head;
    }
}