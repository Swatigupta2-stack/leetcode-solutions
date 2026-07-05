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
    public boolean isPalindrome(ListNode head) {
      ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    
    
    // Traverse the existing list and copy values
    ListNode current = head;
    while (current != null) {
        tail.next = new ListNode(current.val);
        tail = tail.next;
        current = current.next;
    }
    //reversing the list
    ListNode head2 = dummy.next;
    ListNode temp = head2;
       ListNode prev = null;
    
     
      while(temp!= null){
       ListNode front = temp.next;
       temp.next = prev;
       prev = temp;
       temp = front;
      }

      ListNode reversedCopy = prev;
      ListNode origin = head;
      ListNode rever = reversedCopy;
      while(origin != null && rever != null){
        if(origin.val != rever.val)
        return false;

        origin = origin.next;
        rever = rever.next;
      }
      return true;
    }
}