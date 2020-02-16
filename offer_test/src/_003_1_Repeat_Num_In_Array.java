import java.util.Arrays;

public class _003_1_Repeat_Num_In_Array {

  private static class Solution {

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
  }
}