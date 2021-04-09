package Array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // if no 1 -> return 1
        // change negatives, 0 and > nums.length to 1
        boolean one = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                one = true;
            }
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if (one == false) {
            return 1;
        }
        // iterate and use index as hash key
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);

            if (index == nums.length) {
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[index] = - Math.abs(nums[index]);
            }
        }
        // iterate again and return first non-negative number
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return nums.length;
        }

        return nums.length + 1;
    }
}
