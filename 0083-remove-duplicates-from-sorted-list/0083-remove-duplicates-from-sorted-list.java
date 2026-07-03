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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode prev = temp;
        if(head == null)
        return head;
        temp = temp.next;
        while(temp!=null && prev.next!= null){
            if(temp.val == prev.val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
           
        temp = temp.next;
        }
        return head;
    }
}