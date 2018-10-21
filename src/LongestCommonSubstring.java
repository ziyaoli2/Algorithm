/**
 * Created by ziyaoli on 10/20/18.
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String a = "student";
        String b = "sweden";
        System.out.println(new Solution().longestCommonubstring(a, b));
    }
}

class Solution {
    public int longestCommonubstring(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return 0;
        }
        int[][] M = new int[a.length() + 1][b.length() + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (i == 0 || j == 0) {
                    M[i][j] = 0;
                    continue;
                }
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    M[i][j] = M[i - 1][j - 1] + 1;
                } else {
                    M[i][j] = 0;
                }
                max = Math.max(max, M[i][j]);
            }
        }
        return max;
    }
}
