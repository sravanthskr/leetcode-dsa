// https://leetcode.com/problems/reverse-linked-list/submissions/1609798331/

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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){ //head.next for checking if only one element, it cant be reversed
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            // update the pointer to next elements
            prev = curr;
            curr = nextNode;
        }
        head.next = null;
        head=prev; // updating new head
        return head;
    }
}
