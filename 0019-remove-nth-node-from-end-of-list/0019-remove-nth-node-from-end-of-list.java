class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null)
            return null;

        // Find size
        ListNode temp = head;
        int size = 0;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        // If head needs to be removed
        if(size - n == 0){
            return head.next;
        }

        // Reach node before the target
        int i = 1;
        temp = head;

        while(i < size - n){
            temp = temp.next;
            i++;
        }

        // Remove target
        temp.next = temp.next.next;

        return head;
    }
}