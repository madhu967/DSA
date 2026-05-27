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
    public ListNode reverseBetween(ListNode head, int left, int right) {
       if(head == null || left==right){
        return head;
       }
       ListNode prevLeft=null;
       ListNode temp=head;
       for(int i=1;i<left;i++){
        prevLeft=temp;
        temp=temp.next;
       }
       ListNode start=temp;
       ListNode prev=null;
       for(int i=left;i<=right;i++){
        ListNode front=temp.next;
        temp.next=prev;
        prev=temp;
        temp=front;
       }
       if(prevLeft!=null){
        prevLeft.next=prev;
       }
       else{
        head=prev;
       }
       start.next=temp;
       return head;
    }
}
