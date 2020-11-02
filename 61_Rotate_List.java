
// make the linkedlist a circle first
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        curr.next = head;
        int n = len - (k % len) - 1;
        
        curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        
        ListNode result = curr.next;
        curr.next = null;
        
        return result;
    }
    

}
