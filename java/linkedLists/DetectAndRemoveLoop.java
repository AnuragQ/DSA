
// https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
class Node
{
    int data;
    Node next;
}


class solver
{
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        if(head.next==null){
            return;
        }
        Node slow=head.next;
        Node fast=head.next.next;
        
        while(slow!=fast){
            if(slow==null || fast==null || fast.next==null){
                return;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        
        fast=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        while(slow.next!=fast){
            slow=slow.next;
        }
        slow.next=null;
        
        
        
    }
}
//LEETCODE
// https://leetcode.com/problems/linked-list-cycle-ii/submissions/
// /**
//  * Definition for singly-linked list.
//  * class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         if(head==null || head.next==null){
//             return null;
//         }
//         ListNode slow=head.next;
//         ListNode fast=head.next.next;
        
//         while(slow!=fast){
//             if(slow==null || fast==null  || fast.next==null){
//                 return null;
//             }
//             slow=slow.next;
//             fast=fast.next.next;
//         }
        
//         fast=head;
//         while(slow!=fast){
//             slow=slow.next;
//             fast=fast.next;
//         }
//         return slow;
//     }
// }