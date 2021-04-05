package Math;

public class GlobalLocalInvernsions {
    public boolean isIdealPermutation(int[] A) {
        // record min value on the right
        int min = Integer.MAX_VALUE;
        // iterate from right to left
        for (int i = A.length - 1; i > 1; i--) {
            min = Math.min(min, A[i]);
            if (A[i - 2] > min) {
                return false;
            }
        }
        return true;
    }
}
