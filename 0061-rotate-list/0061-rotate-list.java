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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        ListNode start = head;
        if(head == null || head.next == null)
        return head;
        int size = 0;
        int count = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        temp = head;
        if(k> size){
            while(k> size){
                k = k-size;
            }
        }
        if(k == size)
        return head;
        else{
            int n = size - k;
            while(n!= 1){
                temp = temp.next;
                n--;
            }
            while(temp.next != null){
                ListNode helper = temp.next;
                temp.next = temp.next.next;
               if(count== 0){
                helper.next = head;
                head = helper;
                start = head;
                count++;
                //ListNode start = head;
               }
               else{
                helper.next = start.next;
                start.next = helper;
                start = start.next;
               }
            }
        }
        return head;
    }
}