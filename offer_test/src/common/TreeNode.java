package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

  public int val = 0;
  public TreeNode left = null;
  public TreeNode right = null;

  public TreeNode(int value) {
    this.val = value;
  }

  public ArrayList<ArrayList<Integer>> print() {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (this == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(this);
    while (!q.isEmpty()) {
      int size = q.size();
      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        list.add(node.val);
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
      }
      res.add(list);
    }
    return res;
  }

}
