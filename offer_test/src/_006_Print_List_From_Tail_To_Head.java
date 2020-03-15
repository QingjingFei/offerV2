import java.util.ArrayList;
import common.ListNode;
import java.util.LinkedList;
import sun.awt.image.ImageWatched.Link;

public class _006_Print_List_From_Tail_To_Head {

  private static class Solution {

    public static void main(String[]args) {
      ListNode nextNode = new ListNode(1);
      ListNode headNode = new ListNode(0, nextNode);
      for(int i = 2; i < 10; i++){
        ListNode node = new ListNode(i);
        nextNode.setNext(node);
        nextNode = node;
      }
      ArrayList<Integer> res = printListFromTailToHead_1(headNode);
    }

    public static ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
      ListNode pre = null;
      while (listNode != null) {
        ListNode next = listNode.next;
        listNode.next = pre;
        pre = listNode;
        listNode = next;
      }
      ArrayList<Integer> list = new ArrayList<>();
      while (pre != null) {
        list.add(pre.val);
        pre = pre.next;
      }
      return list;
    }

    public static ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
      ArrayList<Integer> list = new ArrayList<>();
      ListNode node = listNode;
      while (node != null) {
        list.add(0, node.val);
        node = node.next;
      }
      return list;
    }

    public static ArrayList<Integer> printListFromTailToHead_3(ListNode listNode) {
      LinkedList<Integer> stack = new LinkedList<>();
      ArrayList<Integer> list = new ArrayList<>();
      while (listNode != null) {
        stack.push(listNode.val);
        listNode = listNode.next;
      }
      while (!stack.isEmpty()) {
        list.add(stack.pop());
      }
      return list;
    }
  }
}
