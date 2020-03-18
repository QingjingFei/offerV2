import java.util.Arrays;

public class _003_1_Repeat_Num_In_Array {

  private static class Solution {

    public static void main(String[] args) {
      int[][] arrays = {
          {2, 3, 1, 0, 2, 5},
          {2, 3, 1, 1, 2, 5},
          {3, 2, 0, 4, 1, 5},
          {6, 2},
          {}
      };
      for (int[] array : arrays) {
        System.out.println("array = " + Arrays.toString(array));
        int[] duplication = new int[]{-1};
        boolean result = new Solution().duplicate(array, duplication);
        System.out.println("result = " + result + ", duplication = " + duplication[0]);
      }
    }
    /*
    若array[i]与下标i不相等，则把array[i]与array[array[i]交换，把array[i]换到它应在的位置去；
    duplication[]仅存储一个重复数字，因为题目也并未要求打印出所有重复数组；
    注意代码开头异常特殊测试用例的处理。
    代码中尽管有一个两重循环，但每个数字最多只要交换两次就能找到属于它自己的位置，因此时间复杂度是O(n)
     */
    public boolean duplicate(int[] array, int[] duplication) {
      int n = array.length;
      if (array == null || n == 1) {
        return false;
      }
      for (int i = 0; i < n; i++) {
        if (array[i] < 0 || array[i] > n - 1) {
          return false;
        }
      }
      for (int i = 0; i < n; i++) {
        while (array[i] != i) {
          if (array[i] == array[array[i]]) {
            duplication[0] = array[i];
            return true;
          }
          // 交换array[i]和array[array[i]]
          int tmp = array[i];
          array[i] = array[tmp];
          array[tmp] = tmp;
        }
      }
      return false;
    }
//    // 交换数组中的两数
//    private void swap(int[] array, int i, int j) {
//      int tmp = array[i];
//      array[i] = array[j];
//      array[j] = tmp;
//    }
  }
}