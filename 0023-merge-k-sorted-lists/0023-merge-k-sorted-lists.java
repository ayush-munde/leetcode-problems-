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
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                head.next=list1;
                head=list1;
               list1= list1.next;
                
            }
            else if(list1.val>list2.val){
                 head.next=list2;

                 head=list2;
               list2= list2.next;
            }
        }
             while(list1!=null){
                head.next=list1;
                head=list1;
                list1=list1.next;
             }
              while(list2!=null){
                head.next=list2;
                head=list2;
                list2=list2.next;
             }
        return dummy.next ;
        
    }
    public ListNode mergeKLists(ListNode[] lists) {
          if(lists==null || lists.length==0) return null;
     
         int k=lists.length;
         for(int gap=1;gap<k;gap*=2){
            for(int i=0;i+gap<k;i+=2*gap){
                lists[i]=mergeTwoLists(lists[i],lists[i+gap]);
            }
         }
         return lists[0];
}
}