package java.trees;

public class MaxSumN2Npath_BT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair {
        int n2n;
        int c2n;

        Pair() {
            this.n2n = Integer.MIN_VALUE;
            this.c2n = 0;
        }

        Pair(int n2n, int c2n) {
            this.n2n = n2n;
            this.c2n = c2n;
        }
    }

    public Pair maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return new Pair();
        }
        if (node.left == null && node.right == null) {
            return new Pair(node.val, node.val);
        }
        Pair myAns = new Pair();

        Pair left = maxPathSumHelper(node.left);
        Pair right = maxPathSumHelper(node.right);
        myAns.c2n = Math.max(Math.max(left.c2n, right.c2n) + node.val, node.val);
        myAns.n2n = Math.max(
                Math.max(Math.max(Math.max(left.n2n, right.n2n), left.c2n + right.c2n + node.val), node.val),
                Math.max(left.c2n, right.c2n) + node.val);

        return myAns;

    }

    public int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root).n2n;
    }
}