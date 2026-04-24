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
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        int digit=0, carry=0;
        ListNode dummy= new ListNode(0);
        ListNode curr= dummy;
      while(L1!=null || L2!=null|| carry!=0){
        int sum= carry;
        if(L1!= null){
        sum+= L1.val;
        L1= L1.next;
        }
        if(L2!=null){
        sum+= L2.val;
         L2=L2.next;
        }
        
        digit= sum %10;
        carry= sum /10;
        curr.next=  new ListNode(digit);
        curr= curr.next;
      }  
      return dummy.next;
    }
}