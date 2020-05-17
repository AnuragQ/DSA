
class kReversePointerRecursive {
    public static void main(String[] args) {
        
    }
}
// https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/422311/Easy-Java-recursive-solution-(100-faster-and-100-less-memory)
// public ListNode reverseKGroup(ListNode head, int k) {

//     ListNode curr = head,temp = head,nxt,prev,head2;
//     int count=k;
//     while(count>1 && temp!=null){
//         temp = temp.next;
//         count--;
//     }
    
//     if(count==1 && temp!=null){
//         temp.next = reverseKGroup(temp.next,k);
//         temp = temp.next;
//         prev = temp;
//         while(curr!=temp){
//             nxt = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = nxt;
//         }

//         head = prev;
//     }
//     return head;
// }


// https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

// Node reverse(Node head, int k) 
// { 
//    Node current = head; 
//    Node next = null; 
//    Node prev = null; 
     
//    int count = 0; 

//    /* Reverse first k nodes of linked list */
//    while (count < k && current != null)  
//    { 
//        next = current.next; 
//        current.next = prev; 
//        prev = current; 
//        current = next; 
//        count++; 
//    } 

//    /* next is now a pointer to (k+1)th node  
//       Recursively call for the list starting from current. 
//       And make rest of the list as next of first node */
//    if (next != null)  
//       head.next = reverse(next, k); 

//    // prev is now head of input list 
//    return prev; 
// }   