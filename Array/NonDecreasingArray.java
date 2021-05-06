package Array;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        // sanity check
        // count number of conflict
        int count = 0;
        // scan
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i == 1 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else if (nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                }
            }

        }
        // return true
        return true;
    }
}
