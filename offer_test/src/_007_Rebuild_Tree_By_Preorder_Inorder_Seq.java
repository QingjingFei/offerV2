import common.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;

public class _007_Rebuild_Tree_By_Preorder_Inorder_Seq {

  private static class Solution {

    public static void main(String[] args) {
      /*
             1
           /   \
          2     3
         /     / \
        4     5  6
         \      /
         7     8
       */
      int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
      int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
      Solution rebuild = new Solution();
      TreeNode root = rebuild.reConstructBinaryTree(pre, in);
      ArrayList<ArrayList<Integer>> res = root.print(root);
      System.out.println(res);
    }

    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
      if (pre.length == 0 || in.length == 0) {
        return null;
      }
      TreeNode root = new TreeNode(pre[0]);
      for (int i = 0; i < in.length; i++) {
        if (in[i] == pre[0]) {
          root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
          root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
          break;
        }
      }
      return root;
    }
  }
}