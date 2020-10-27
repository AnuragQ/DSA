package java.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LargestBSTSubtree {
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

static class BstPair {
    Node bstNode;
    int size;
    boolean isBst;
    int hi;
    int lo;

    BstPair(Node bstNode, int size, boolean isBst, int hi, int lo) {
        this.bstNode = bstNode;
        this.size = size;
        this.isBst = isBst;
        this.hi = hi;
        this.lo = lo;

    }
}

public static BstPair largestBst(Node node) {
    if (node == null) {
        return new BstPair(null, 0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    BstPair left = largestBst(node.left);
    BstPair right = largestBst(node.right);
    int lo, hi;
    lo = Math.min(node.data, left.lo);
    hi = Math.max(node.data, right.hi);

    BstPair ans = new BstPair(node, 0, false, hi, lo);

    // System.out.println(lo + " " + hi);

    if (!left.isBst && !right.isBst) {

    } else if (!left.isBst) {
        ans.bstNode = right.bstNode;
        ans.size = right.size;
        return ans;
    } else if (!right.isBst) {
        ans.bstNode = left.bstNode;
        ans.size = left.size;
        return ans;
    } else if (node.data > left.hi && node.data < right.lo) {
        // System.out.println("in ");
        ans.isBst = true;
        ans.size = left.size + right.size + 1;
        return ans;
    }

    if (left.size > right.size) {
        ans.bstNode = left.bstNode;
        ans.size = left.size;
        return ans;
    } else {
        ans.bstNode = right.bstNode;
        ans.size = right.size;
        return ans;
    }

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

        Node root = construct(arr);
        BstPair ans = largestBst(root);
        System.out.println(ans.bstNode.data + "@" + ans.size);
        // write your code here
    }

}