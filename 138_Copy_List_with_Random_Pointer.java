class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null) {
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        Node resultDummy = new Node(0);
        Node resultCurr = resultDummy;
        while (curr != null) {
            resultCurr.next = curr.next;
            curr.next = curr.next.next;
            resultCurr = resultCurr.next;
            curr = curr.next;
        }
        
        return resultDummy.next;
    }
}
