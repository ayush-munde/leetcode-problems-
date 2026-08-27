class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode temp = head;
        int size = 0;

        // Find size
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // Number of steps to reach middle
        int a = size / 2;

        temp = head;
        int i = 0;

        // Move to middle
        while (i < a) {
            temp = temp.next;
            i++;
        }

        return temp;
    }
}