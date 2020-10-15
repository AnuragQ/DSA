import java.util.HashSet;

//  The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class RemoveDuplicatesFromUnsortedLL
{
    // Function to remove duplicates from the given linked list
    public Node removeDuplicates(Node head) 
    {
        HashSet<Integer> hs=new HashSet<>();
        Node temp=head;
        hs.add(temp.data);
        // 3->3
        
        
        while(temp!=null && temp.next!=null ){
            if(hs.contains(temp.next.data)){
                temp.next=temp.next.next;
            }else{
                hs.add(temp.next.data);
                temp=temp.next;
            }
        }
        return head;
         // Your code here
    }
}