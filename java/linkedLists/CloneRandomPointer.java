


class CloneRandomPointter {
    class Node {
        int data;
        Node next, arb;
    
        Node(int d) 
        { 
            data = d;
            next = arb = null; 
            
        }
    }
    Node copyList(Node head) {
        // your code here
        Node temp=head;
        while(temp!=null){
            Node copy=new Node(temp.data);
            copy.next=temp.next;
            temp.next=copy;
            temp=copy.next;
        }
    
        temp=head;
        while(temp!=null ){
            if(temp.next!=null){
                if(temp.arb != null){
                    temp.next.arb = temp.arb.next;
                }
            }
            temp=temp.next.next;
        }
        temp=head;
        Node dum=new Node(0);
        Node t=dum;
        while(temp!=null && temp.next!=null){
            dum.next=temp.next;
            dum=dum.next;
            temp.next=temp.next.next;////mistake was here, not reverting original list
            temp=temp.next;
        }
        //TA approach
        // temp=head;
        // Node newList=head.next;
        // Node newHead=newList;
        // while(temp!=null && newList!=null){
        //     if(temp.next!=null){
        //         temp.next=temp.next.next;
        //     }
        //     if(newList.next!=null){
        //         newList.next=newList.next.next;
        //     }
        //     temp=temp.next;
        //     newList=newList.next;
        // }
        

        return t.next;
    }
}
