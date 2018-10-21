/**
 * Created by ziyaoli on 10/20/18.
 */
public class LongestAscendingSubarray {
    public static void main(String[] args) {
        int[] array = {7,2,3,1,5,8,9,6,2,4,6,7,8};
        System.out.println(new LongestAscendingSubarray().longestAscendingSubarray(array));
    }


    private int longestAscendingSubarray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] M = new int[array.length];
        M[0] = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < M.length; i++) {
            if (array[i] > array[i - 1]) {
                M[i] = M[i - 1] + 1;
            } else {
                M[i] = 1;
            }
            result = Math.max(result, M[i]);
        }
        return result;
    }
}


