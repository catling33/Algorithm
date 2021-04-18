package Array;

public class MinOperationIncreasing {
    public int minOperations(int[] nums) {
        // sanity check
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        // record steps so far
        int step = 0;
        // record min value needed for current i
        int min = nums[0] + 1;
        // iterate
        // if current element < min
        // step += min - current element
        // min = Math.max(min + 1, current element)
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                step += min - nums[i];
            }
            min = Math.max(min, nums[i]) + 1;
        }
        // return steps
        return step;
    }
    public static void main(String[] args) {
        MinOperationIncreasing sol = new MinOperationIncreasing();
        int[] nums = {1,5,2,4,1};
        System.out.println(sol.minOperations(nums));
    }
}
