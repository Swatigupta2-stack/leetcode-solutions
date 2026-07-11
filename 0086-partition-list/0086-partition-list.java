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
    public ListNode partition(ListNode head, int x) {
        
    ListNode shead = new ListNode(0); ;
        ListNode bhead = new ListNode(0);
        ListNode small = shead; 
    ListNode big =bhead; 
        ListNode temp = head;

        while(temp != null){
            if(temp.val < x){
               
                    small.next = temp;
                    small = small.next;
                
            }
            else{
                
                    big.next = temp;
                    big = big.next;
                }
            temp = temp.next;
        }
        big.next = null;
         
         small.next = bhead.next;

        return shead.next;
    }
}