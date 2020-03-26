import common.TreeNode;

public class _054_BST_Kth_Node {

  public static class Solution {

    public static void main(String[] args) {
    /*
          5
        /   \
       3     7
      / \    / \
     2   4  6   8
     */
      TreeNode treeNode5 = new TreeNode(5);
      TreeNode treeNode3 = new TreeNode(3);
      TreeNode treeNode7 = new TreeNode(7);
      TreeNode treeNode2 = new TreeNode(2);
      TreeNode treeNode4 = new TreeNode(4);
      TreeNode treeNode6 = new TreeNode(6);
      TreeNode treeNode8 = new TreeNode(8);

      treeNode5.left = treeNode3;
      treeNode5.right = treeNode7;
      treeNode3.left = treeNode2;
      treeNode3.right = treeNode4;
      treeNode7.left = treeNode6;
      treeNode7.right = treeNode8;

      Solution bst_k = new Solution();
      for (int i = 1; i < 10; i++) {
        TreeNode node = bst_k.KthNode(treeNode5, i);
        System.out.println(i + ":" + node.val);
      }
    }

    private int key = 0;
    private TreeNode node = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
      if (pRoot == null || k <= 0) return null;
      key = k;
      inOrder(pRoot);
      return node;
    }

    void inOrder(TreeNode root) {
      if (root == null) return ;
      inOrder(root.left);
      key--;
      if (key == 0) {
        node = root;
        return ;
      }
      inOrder(root.right);
    }
  }
}
