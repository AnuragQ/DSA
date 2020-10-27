// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

//Node of a linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

// Linked List class
class LinkedList {
    Node head; // head of list
}

// This is method only submission. You only need to complete the method. */
class Intersect {
    int intersectPoint(Node headA, Node headB) {
        // code here
        Node tempA = headA, tempB = headB;

        while (tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        if (tempA == null) {
            while (tempB != null) {
                headB = headB.next;
                tempB = tempB.next;
            }
        } else if (tempB == null) {
            while (tempA != null) {
                headA = headA.next;
                tempA = tempA.next;
            }
        }
        while (headA != null && headB != null && headA.next != headB.next) {
            headA = headA.next;
            headB = headB.next;
        }
        if (headA == null || headB == null) {
            return -1;

        }
        return headA.next.data;

    }
}
