package BinarySearch;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] lowestEnding = new int[nums.length];
        lowestEnding[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            int index = findSmallestLarger(lowestEnding, 0, len, nums[i]);
            if (index == -1) {
                len++;
                lowestEnding[len] = nums[i];
            } else {
                lowestEnding[index] = nums[i];
            }

        }
        return len;
    }
    // find smallest larger
    private int findSmallestLarger(int[] array, int left, int right, int target) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[left] > target) {
            return left;
        } else if (array[right] > target) {
            return right;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        int[] nums = new int[]{7,7,7,7,7,7,7};
        System.out.println(sol.lengthOfLIS(nums));
    }
}
