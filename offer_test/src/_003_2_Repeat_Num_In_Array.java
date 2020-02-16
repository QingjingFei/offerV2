import java.util.Arrays;

public class _003_2_Repeat_Num_In_Array {

  private static class Solution {

    public static int getDuplication(int[] arr) {
      if (arr == null || arr.length == 0) {
        return -1;
      }
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] < 1 || arr[i] >= arr.length) {
          return -1;
        }
      }
      int[] tmpArr = new int[arr.length];
      for (int i = 0; i < tmpArr.length; i++) {
        if (arr[i] == tmpArr[arr[i]]) {
          return arr[i];
        }
        tmpArr[arr[i]] = arr[i];
      }
      return -1;
    }

    public static void main(String[] args) {
      int[][] arrays = {
          {2, 1, 5, 4, 3, 2, 6, 7},
          {2, 3, 1, 1, 2, 5},
          {2, 2, 1, 4, 1, 3},
          {6, 2},
          {}
      };
      for (int[] arr : arrays) {
        System.out.println("array = " + Arrays.toString(arr));
        int res = new Solution().getDuplication(arr);
        System.out.println("duplication = " + res);
      }
    }

  }
}
