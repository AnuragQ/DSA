


public class DeleteNodeOnlyNodeReference {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
  
    public void deleteNode(ListNode node) {
        ListNode temp=node;
        temp.val=node.next.val;
        temp.next=node.next.next;
    }
}