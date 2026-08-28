 /*gth()-1;
         while(i<=j){
            if(arr)
         }*
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
     public ListNode reverseLinkedList(ListNode head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;  // No change is needed; return the current head
        }

        // Recursive step: Reverse the remaining part of the list and get the new head
       ListNode newHead = reverseLinkedList(head.next);

        // Store the next node in 'front' to reverse the link
        ListNode front = head.next;

        // Update the 'next' pointer of 'front' to point to the current head
        front.next = head;

        // Set the 'next' pointer of the current head to null to break the original link
        head.next = null;

        // Return the new head obtained from the recursion
        return newHead;
    }
   
    public boolean isPalindrome(ListNode head) { 
        if(head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
       
        while(fast.next!=null &&  fast.next.next!=null){
                  slow=slow.next;
                  fast=fast.next.next;
        }
        ListNode rcurr= reverseLinkedList(slow.next) ;
        ListNode curr=head;
       
        while(rcurr!=null){
            if(curr.val!=rcurr.val) 
                 return false;
            curr=curr.next;
            rcurr=rcurr.next;
        }
       return true ;
}
}