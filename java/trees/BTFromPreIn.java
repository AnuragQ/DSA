package trees;

public class BTFromPreIn {
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

public TreeNode buildTree(int[] preorder, int[] inorder, int prst, int pren, int inst, int inen) {

    if (prst > pren || inst > inen) {
        return null;
    }
    TreeNode node = new TreeNode(preorder[prst]);
    int idx = inst, count = 0;
    while (inorder[idx] != preorder[prst]) {
        idx++;
        count++;
    }

    node.left = buildTree(preorder, inorder, prst + 1, prst + count, inst, inst + count - 1);
    node.right = buildTree(preorder, inorder, prst + count + 1, pren, inst + count + 1, inen);

    return node;

}

public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
}
}