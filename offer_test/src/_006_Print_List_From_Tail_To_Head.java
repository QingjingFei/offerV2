import java.util.ArrayList;
import common.ListNode;
import java.util.LinkedList;

public class _006_Print_List_From_Tail_To_Head {

  public static class Solution {

    public static void main(String[] args) {
      ListNode headNode = new ListNode(0);
      ListNode nextNode = new ListNode(1);
      headNode.next = nextNode;
      for (int i = 2; i < 10; i++) {
        ListNode node = new ListNode(i);
        nextNode.next = node;
        nextNode = node;
      }
      ArrayList<Integer> res = printListFromTailToHead_1(headNode);
      System.out.println(res);
    }

    /*
    1. 反转链表指针，改变了原链表
     */
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

    /*
    2. 利用ArrayList.add(0, E)，在表头插入
     */
    public static ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
      ArrayList<Integer> list = new ArrayList<>();
      ListNode node = listNode;
      while (node != null) {
        list.add(0, node.val);
        node = node.next;
      }
      return list;
    }

    /*
    3. 栈，不改变原链表
     */
    public static ArrayList<Integer> printListFromTailToHead_3(ListNode listNode) {
      ArrayList<Integer> list = new ArrayList<>();
      LinkedList<Integer> stack = new LinkedList<>();
      while (listNode != null) {
        stack.push(listNode.val);
        listNode = listNode.next;
      }
      while (!stack.isEmpty()) {
        list.add(stack.pop());
      }
      return list;
    }

    /*
    4. 递归，可以用栈就可以用递归；
       但若链表非常长，会导致函数调用层级很深，从而导致函数调用栈溢出，用栈更安全。
     */
    static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead_4(ListNode listNode) {
      if (listNode != null) {
        printListFromTailToHead_4(listNode.next);
        list.add(listNode.val);
      }
      return list;
    }
  }
}
