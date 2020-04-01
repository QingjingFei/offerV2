import java.util.Arrays;

public class _test_3Nums {

  public static class Solution {

    public static void main(String[] args) {
      int [][] arrays = {
          {2, 3, 1, 2, 2, 1, 3, 1, 1},
          {2, 3, 3, 2, 3},
          {3, 3, 3, 2, 2, 1, 1, 1},
          {}
      };
      for (int[] array : arrays) {
        System.out.println("array = " + Arrays.toString(array));
        Solution res = new Solution();
        res.sort(array);
        System.out.println("result = " + Arrays.toString(array));
      }
    }

    /**
     *
     * 数组中存有1-3的三种数字,例如[1,2,3,1,2,2,1,3,3]，
     * 将其排序为[1,1,1,2,2,2,3,3,3]，要求仅扫描一遍；
     * 后续将内容变为一个对象，继续排序。
     *
     * 类似题：leetcode 75.颜色分类 https://leetcode-cn.com/problems/sort-colors/
     */
    private int[] array;
    public void sort(int[] nums) {
      array = nums;
      int tmp;
      for (int i = 0, j = array.length - 1, curr = 0; curr <= j; ) {
        if (array[curr] == 1) {
          tmp = array[i];
          array[i++] = array[curr];
          array[curr++] = tmp;
        } else if (array[curr] == 3) {
          tmp = array[j];
          array[j--] = array[curr];
          array[curr] = tmp;
        } else curr++;
      }
    }
  }
}
