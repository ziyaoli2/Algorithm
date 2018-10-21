/**
 * Created by ziyaoli on 10/21/18.
 */
public class LongestAscendingSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[] {7,2,3,1,5,8,9,6,3,2,3,10,1,-9,20}; //answer is 7
        System.out.println(new LongestAscendingSubsequence().longestAscendingSubsequence(arr));
    }

    private int longestAscendingSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] M = new int[arr.length];
        int result = Integer.MIN_VALUE;
        M[0] = 1;
        for (int i = 1; i < M.length; i++) {
            int max = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, M[j]);
                }
            }
            M[i] = max + 1;
            result = Math.max(result, M[i]);
        }
        return result;
    }
}


