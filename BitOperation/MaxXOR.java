package BitOperation;

import java.util.Arrays;

public class MaxXOR {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        // sanity check
        // result array
        int[] result = new int[nums.length];
        // calculate maxbit in int
        int maxNum = 0;
        for (int i = 0; i < maximumBit; i++) {
            maxNum += Math.pow(2, i);
        }
        // record current XOR result
        int curResult = 0;
        // start from right to left
        // cur result XOR cur number
        // then XOR maxbit to get k
        // record k
        for (int i = nums.length - 1; i >= 0; i--) {
            curResult ^= nums[nums.length - 1 - i];
            int k = (curResult ^ maxNum);
            result[i] = k;
        }
        // return result
        return result;
    }

    public static void main(String[] args) {
        MaxXOR sol = new MaxXOR();
        int[] nums = {0,1,1,3};
        int maximumBit = 2;
        System.out.println(Arrays.toString(sol.getMaximumXor(nums, maximumBit)));
    }
}
