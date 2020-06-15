package java.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PrintNodesAtKdistance_BT {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static class FoundPair {
        boolean found;
        int k;
    }

    public static FoundPair printKNodesFar(Node node, int data, int k, boolean found) {
        // write your code here
        if (node == null) {
            FoundPair ans = new FoundPair();
            ans.k = -1;
            return ans;
        }
        if (k == 0 && found == true) {
            System.out.println(node.data);
        }
        if (node.data == data || found == true) {

            printKNodesFar(node.left, data, k - 1, true);
            printKNodesFar(node.right, data, k - 1, true);
            FoundPair ans = new FoundPair();
            ans.found = true;
            ans.k = k - 1;
            return ans;
        }

        FoundPair leftAns = printKNodesFar(node.left, data, k, false);
        FoundPair rightAns = printKNodesFar(node.right, data, k, false);

        if (leftAns.found) {
            if (leftAns.k == 0) {
                System.out.println(node.data);

            }
            printKNodesFar(node.right, data, leftAns.k - 1, true);
            leftAns.k--;
            return leftAns;
        } else if (rightAns.found) {
            if (rightAns.k == 0) {
                System.out.println(node.data);

            }
            printKNodesFar(node.left, data, rightAns.k - 1, true);

            rightAns.k--;
            return rightAns;
        } else {

            return new FoundPair();
        }

    }

    public static void printKNodesFar(Node node, int data, int k) {
        printKNodesFar(node, data, k, false);

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }

}