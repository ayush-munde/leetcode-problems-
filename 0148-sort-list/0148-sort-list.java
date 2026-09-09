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

    public ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            }
            else {
                temp.next = right;
                right = right.next;
            }

            // Move temp forward
            temp = temp.next;
        }

        // Attach remaining nodes
        if (left != null) {
            temp.next = left;
        }
        else {
            temp.next = right;
        }

        return dummy.next;
    }


    public ListNode findMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode mid = findMiddle(head);

        // Divide into two lists
        ListNode right = mid.next;
        mid.next = null;

        ListNode left = head;

        // Sort both halves
        left = sortList(left);
        right = sortList(right);

        // Merge sorted halves
        return merge(left, right);
    }
}