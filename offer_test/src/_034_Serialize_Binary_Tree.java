import common.TreeNode;

public class _034_Serialize_Binary_Tree {

  public static class Solution {

    public static void main(String[] args) {
    /*
          1
        /   \
       2     3
      /     / \
     4     5   60
     */
      TreeNode treeNode1 = new TreeNode(1);
      TreeNode treeNode2 = new TreeNode(2);
      TreeNode treeNode3 = new TreeNode(3);
      TreeNode treeNode4 = new TreeNode(4);
      TreeNode treeNode5 = new TreeNode(5);
      TreeNode treeNode6 = new TreeNode(60);

      treeNode1.left = treeNode2;
      treeNode1.right = treeNode3;

      treeNode2.left = treeNode4;
      treeNode3.left = treeNode5;
      treeNode3.right = treeNode6;

      Solution serializeTree = new Solution();
      String str = serializeTree.Serialize(treeNode1);
      System.out.println("序列化：" + str);
      TreeNode treeNode = serializeTree.Deserialize(str);
      System.out.println("反序列化：" + serializeTree.Serialize(treeNode));
    }

    /**
     * 实际上，如果二叉树的序列化是从根节点开始的，
     * 那么相应的反序列化在根节点的数值读出来的时候就可以开始了。
     * 因此，我们可以根据前序遍历的顺序来序列化二叉树。
     * 后序遍历在反序列化的时候要修改为从后往前读序列。
     * 中序遍历、层次遍历均不能达此效果。
     */
    private int idx = -1;

    String Serialize(TreeNode root) {
      if (root == null) {
        return "#";
      } else {
        return Serialize(root.left) + "!" + Serialize(root.right) + "!" + root.val;
      }
    }

    TreeNode Deserialize(String str) {
      String[] s = str.split("!");  // 将序列化之后的序列用"!"分隔符转化为数组
      idx = s.length;
      TreeNode treeNode = helpDeserialize(s);
      return treeNode;
    }

    TreeNode helpDeserialize(String[] s) {
      idx--;
      if (s[idx].equals("#")) return null;
      TreeNode treeNode = new TreeNode(Integer.parseInt(s[idx]));
      treeNode.right = helpDeserialize(s);
      treeNode.left = helpDeserialize(s);
      return treeNode;
    }
  }
}
