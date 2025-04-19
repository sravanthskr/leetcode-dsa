https://leetcode.com/problems/palindrome-linked-list/

// My logic approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Edge case: 0 or 1 node
        if (head == null || head.next == null) return true;

        // Step 1: Count the number of nodes
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        // Step 2: Traverse to the middle node
        int m = count / 2;
        ListNode temp = head;
        while (m > 1) {
            temp = temp.next;
            m--;
        }

        // Step 3: Split the list into two halves
        ListNode secondHalf = temp.next;

        // If the length is odd, skip the middle node
        if (count % 2 != 0 && secondHalf != null) {
            secondHalf = secondHalf.next;
        }

        // Break the first half by making temp.next null
        temp.next = null;

        // Step 4: Reverse the second half
        ListNode prev = null;
        ListNode currNode = secondHalf;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }

        // Step 5: Compare both halves
        ListNode firstPointer = head;
        ListNode secondPointer = prev;

        while (firstPointer != null && secondPointer != null) {
            if (firstPointer.val != secondPointer.val) {
                return false;
            }
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return true;
    }
}
