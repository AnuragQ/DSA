package java.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Diameter_BT {
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
    public static int height(Node node) {
        if (node == null) {
          return -1;
        }
    
        int lh = height(node.left);
        int rh = height(node.right);
    
        int th = Math.max(lh, rh) + 1;
        return th;
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

  static class DiaPair {
      int height;
      int maxDia;

      DiaPair() {

      }

      DiaPair(int height, int maxDia) {
          this.height = height;
          this.maxDia = maxDia;
      }
  }

  public static DiaPair diameter4Helper(Node node) {
      if (node == null) {
          return new DiaPair(-1, 0);
      }
      int myDia = 0;
      DiaPair ans = new DiaPair(-1, Integer.MIN_VALUE);
      DiaPair left = diameter4Helper(node.left);
      DiaPair right = diameter4Helper(node.right);

      myDia = left.height + right.height + 2;
      ans.maxDia = Math.max(myDia, left.maxDia);

      ans.maxDia = Math.max(ans.maxDia, right.maxDia);
      ans.height = Math.max(left.height, right.height) + 1;
      return ans;

  }

  public static int diameter4(Node node) {
      // write your code here

      DiaPair ans = diameter4Helper(node);
      return ans.maxDia;



  }

  public static int diameter1(Node node) {
      if (node == null) {
        return 0;
      }
  
      int lh = height(node.left);
      int rh = height(node.right);
      int ld = diameter1(node.left);
      int rd = diameter1(node.right);
  
      int td = Math.max(lh + rh + 2, Math.max(ld, rd));
      return td;
    }
  
    static int dia = 0;
  
    public static int diameter2(Node node) {
      if (node == null) {
        return -1;
      }
  
      int lh = diameter2(node.left);
      int rh = diameter2(node.right);
      int th = Math.max(lh, rh) + 1;
  
      if (lh + rh + 2 > dia) {
        dia = lh + rh + 2;
      }
  
      return th;
    }
  
    static class DPair {
      int ht;
      int dia;
    }
  
    public static DPair diameter3(Node node) {
      if (node == null) {
        DPair bp = new DPair();
        bp.ht = -1;
        bp.dia = 0;
        return bp;
      }
  
      DPair lp = diameter3(node.left);
      DPair rp = diameter3(node.right);
  
      DPair mp = new DPair();
      mp.ht = Math.max(lp.ht, rp.ht) + 1;
      mp.dia = Math.max(lp.ht + rp.ht + 2, Math.max(lp.dia, rp.dia));
      return mp;
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

    int diameter = 0;
    diameter = diameter4(root);//my implementation
    System.out.println(diameter);
  }

}





