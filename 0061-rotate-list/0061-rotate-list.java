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

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int size = 1;
           ListNode tail=head;
        // Find size
        while (tail.next!= null) {
            size++;
            tail= tail.next;
          
        }
      
        
        k = k % size;

        if (k == 0) {
            return head;
        }

        // Find the node before the new head
        ListNode temp = head;
         tail.next=head;
        int i = 0;
        while (i < size - k-1) {
            temp = temp.next;
            i++;
        }
        head=temp.next;
       temp.next=null;

       

        return head;
    }
}