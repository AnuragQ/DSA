
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} 

class LinkedList
{
    static Node mergeSort(Node head)
    {
        
        if(head==null || head.next==null){
            return head;
        }
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node first=head;
                Node second=slow.next;

        slow.next=null;
        return merge(mergeSort(first),mergeSort(second));
        


    }
    static Node merge(Node first,Node second){
        Node dummy=new Node(0);
        Node temp=dummy;
        while(first!=null && second!=null){
            if(first.data<second.data){
                dummy.next=first;
                first=first.next;
                dummy=dummy.next;
            }else{
                dummy.next=second;
                second=second.next;
                dummy=dummy.next;
            }
        }
        while(first!=null){
            dummy.next=first;
            first=first.next;
            dummy=dummy.next;
        }
        while(second!=null){
            dummy.next=second;
            second=second.next;
            dummy=dummy.next;
        }
        return temp.next;
        
    }
}
