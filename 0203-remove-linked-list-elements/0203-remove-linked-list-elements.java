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
    public ListNode removeElements(ListNode head, int val) {
        
       ListNode temp = head;
       ListNode dummy = head;
       ListNode prev = temp;
       if(head==null)
       return null;
       
       temp = temp.next;
       while(temp!= null){
        if(temp.val==val){
            prev.next = prev.next.next;   
        }
        else{
            prev = prev.next; 
        }
        temp = temp.next;
       }
       if(head.val == val)
       return dummy.next;
       else
       return head;
    }
}