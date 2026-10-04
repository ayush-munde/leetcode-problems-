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
        ListNode temp = head;
   ListNode tail;
        // Find size
        while (temp.next!= null) {
            size++;
            temp = temp.next;
          
        }
          tail=temp;
        
        k = k % size;

        if (k == 0) {
            return head;
        }

        // Find the node before the new head
        temp = head;
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