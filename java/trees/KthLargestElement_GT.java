package java.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class KthLargestElement_GT {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

public static PriorityQueue<Integer> kthLargest(Node node, int k, PriorityQueue<Integer> pq) {

  if (node == null) {
    return pq;
  }
  if (pq.size() == k) {
    if (pq.peek() < node.data) {
      pq.poll();
      pq.add(node.data);
    }
  } else {
    pq.add(node.data);
  }

  for (Node child : node.children) {
    pq = kthLargest(child, k, pq);
  }
  return pq;

}

public static int kthLargest(Node node, int k) {
  PriorityQueue<Integer> pQueue = kthLargest(node, k, new PriorityQueue<Integer>());
  return pQueue.peek();

}

  public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
    
        int k = Integer.parseInt(br.readLine());
    
        Node root = construct(arr);
        int kthLargest = kthLargest(root, k);
        System.out.println(kthLargest);
      }
    
}