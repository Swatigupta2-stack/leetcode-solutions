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
       ListNode temp = head;
       ListNode front = head;
       ListNode prev = front;
       front = front.next;
       int size=0;
       while(temp!=null){
        size++;
        temp = temp.next;
       } 
       //if(size==1 && n==1)
       //return null;

       if(size==n)
       return head.next;

       size--;
       
       
       while(front!=null){
        if(size== n)
        {
            prev.next = prev.next.next;
           front= front.next;
          size--;

        }
        else{
            prev = prev.next;
            front = front.next;
            size--;
        }


       }
       
       return head;
    }
}