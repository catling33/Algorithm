package Tree;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        // sanity check
        if (root == null) {
            return 0;
        }
        // recursion
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }
    // recursion
    private int[] helper(TreeNode root) {
        // base case
        if (root == null) {
            return new int[2];
        }
        // info from children
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        // self: rob or not rob
        // case 1: rob current house
        int rob = root.val + left[1] + right[1];
        // case 2: don't rob current house
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // report to parent
        return new int[]{rob, notRob};
    }
}
