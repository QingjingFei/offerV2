public class _004_Find_Element_In_2D_Array {

  private static class Solution {

    public static void main(String[] args) {
      int[][] matrix = {
          {1, 2, 8, 9},
          {2, 4, 9, 12},
          {4, 7, 10, 13},
          {6, 8, 11, 15}
      };
      int[] nums = {-1, 1, 15, 7};
      for (int num : nums) {
        System.out.println("-------------");
        System.out.println(String.format("find %d, %b", num, find(num, matrix)));
      }
    }

    public static boolean find(int target, int[][] arr) {
      if (arr == null || arr.length == 0 || arr[0].length == 0) {
        return false;
      }
      int m = 0, n = arr[0].length - 1;  // 从右上角开始，m为行标，n为列标
      while (m < arr.length && n >= 0) {
        if (target == arr[m][n]) {
          return true;
        } else if (target > arr[m][n]) {
          m++;
        } else {
          n--;
        }
      }
      return false;
    }
  }
}
