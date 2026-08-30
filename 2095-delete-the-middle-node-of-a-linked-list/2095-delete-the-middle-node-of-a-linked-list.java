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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(size==1)return  null;
        temp=head;
        int mid=size/2;
        int i=0;
        while(i<mid-1){
            temp=temp.next;
              
            i++;
        }
        temp.next=temp.next.next;
        return head;

    }
}