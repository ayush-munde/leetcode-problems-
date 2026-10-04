class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null)
            return null;

        // Find size
        ListNode temp= head;
        int size = 0;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        // If head needs to be removed
        if(size - n == 0){
            return head.next;
        }

      ListNode slow=head;
      ListNode fast=head;
  int i=0;

        while(i < n){
            fast= fast.next;
            i++;
        }
           while(fast.next!=null){
            fast=fast.next;
            slow= slow.next;
           
        }
        // Remove target
        slow.next = slow.next.next;

        return head;
    }
}