import java.util.PriorityQueue;
/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Merge
{
Node mergeKList(Node[] lists,int N)
{
    //Add your code here.
    PriorityQueue<Node> pq = new PriorityQueue<>((x,y)->x.data-y.data);
    for(int i=0;i<lists.length;i++){
        if(lists[i]!=null){
            pq.add(lists[i]);
        }
    }
    Node ans=new Node(0),temp=ans;
    
    while(!pq.isEmpty()){

        Node minNode=pq.remove();
        temp.next=minNode;
        temp=temp.next;
        minNode=minNode.next;
        if(minNode!=null){
            pq.add(minNode);  
        }
        
        
    }
    return ans.next;
}
}
