/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Sort012
{
    static Node segregate(Node head)
    {
        // add your code here
        Node zero=new Node(0);
        Node one=new Node(0);
        Node two=new Node(0);
        Node z=zero,o=one,t=two;
        while(head!=null){
            int data=head.data;
            if(data==0){
                z.next=head;
                z=z.next;
            }else if(data==1){
                o.next=head;
                o=o.next;
            }else if(data==2){
                t.next=head;
                t=t.next;
                
            }
            head=head.next;
        }
        if(one.next!=null)
        {
            z.next=one.next;
            o.next=two.next;
            t.next=null;
            
        }else{
            z.next=two.next;
            t.next=null;
        }
        return zero.next;
    }
}
