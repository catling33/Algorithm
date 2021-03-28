package Array;

public class ReinitializePermutation {
    public int reinitializePermutation(int n) {
        // sanity check
        if (n == 0) {
            return 0;
        }

        // perm array & array
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        // first operation
        perm = operation(perm, n);
        // count operations
        int count = 1;
        // operations
        while (!equals(perm)) {
            perm = operation(perm, n);
            count++;
        }
        // return count
        return count;
    }
    // operation
    private int[] operation(int[] perm, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = perm[i / 2];
            } else {
                arr[i] = perm[n / 2 + (i - 1) / 2];
            }
        }
        return arr;
    }
    // check equal
    private boolean equals(int[] perm) {
        for (int i = 0; i < perm.length; i++) {
            if (perm[i] != i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ReinitializePermutation sol = new ReinitializePermutation();
        int n = 4;
        System.out.print(sol.reinitializePermutation(n));
    }
}
