import common.TreeNode;

public class Serialize_Binary_Tree {

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
      System.out.println(str);
      TreeNode treeNode = serializeTree.Deserialize(str);
      System.out.println(treeNode);
    }

    private int index = -1;

    String Serialize(TreeNode root) {
      if (root == null) {
        return "#";
      } else {
        return root.val + "!" + Serialize(root.left) + "!" + Serialize(root.right);
      }
    }

    TreeNode Deserialize(String str) {
      String[] s = str.split("!");  // 将序列化之后的序列用"!"分隔符转化为数组
      index++;  // 索引每次加一
      int len = s.length;
      if (index > len) {
        return null;
      }
      TreeNode treeNode = null;
      if (!s[index].equals("#")) {  // 不是叶子节点，继续走；是叶子节点，出递归
        treeNode = new TreeNode(Integer.parseInt(s[index]));
        treeNode.left = Deserialize(str);
        treeNode.right = Deserialize(str);
      }
      return treeNode;
    }
  }
}
