/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map=new HashMap<>();
        ListNode A=headA;
        ListNode B=headB;

        while(A!=null){
            map.put(A,A.val);
            A=A.next;

        }
        while(B!=null){
            if(map.containsKey(B)){
                return B;
            }
            B=B.next;
        }
        return null;

    }
}