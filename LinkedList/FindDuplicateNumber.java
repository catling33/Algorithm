package LinkedList;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // sanity check
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        // check cycle, get first intersection
        int slow = nums[0];
        int fast = nums[0];
        while (nums[fast] < nums.length) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }
        if (nums[fast] >= nums.length || nums[nums[fast]] >= nums.length) {
            return -1;
        }
        // starting from head and first intersection, find entrance
        slow = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        // return entrance value
        return fast;
    }
}
