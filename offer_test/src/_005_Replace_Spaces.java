public class _005_Replace_Spaces {

  public static class Solution {

    public static void main(String[] args) {
      String[] strs = {
          "We Are Happy.",
          "Hello world!",
          "  H  i ."
      };
      for (String str : strs) {
        System.out.println("-------------");
        System.out.println(String.format("Before: %s, After: %s",
            str, replaceSpace(new StringBuffer(str))));
      }
    }

    public static String replaceSpace(StringBuffer str) {
      if (str == null) {
        return null;
      }

      int cnt = 0;
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == ' ') {
          cnt++;
        }
      }

      int i = str.length() - 1, j = i + cnt * 2;
      str.setLength(j + 1);

      while (i >= 0) {
        if (str.charAt(i) != ' ') {
          str.setCharAt(j, str.charAt(i));
          j--;
        } else {
          str.replace(j - 2, j + 1, "%20");
          j -= 3;
        }
        i--;
      }

      return str.toString();
    }
  }
}
