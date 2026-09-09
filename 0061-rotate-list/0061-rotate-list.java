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

        int size = 0;
        ListNode temp = head;

        // Find size
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        k = k % size;

        if (k == 0) {
            return head;
        }

        // Find the node before the new head
        temp = head;

        int i = 1;
        while (i < size - k) {
            temp = temp.next;
            i++;
        }

        // New head
        ListNode head2 = temp.next;

        // Break the list
        temp.next = null;

        // Go to last node
        temp = head2;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Connect old head
        temp.next = head;

        return head2;
    }
}