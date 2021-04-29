package Tree;


public class RemoveBSTKeysInRange {
    public TreeNode remove(TreeNode root, int min, int max) {
        // sanity check
        // base case
        if (root == null) {
            return root;
        }
        // recursion rule
        // get left and right sub-problem root
        TreeNode left = remove(root.left, min, max);
        TreeNode right = remove(root.right, min, max);
        // if current root is out of range -> attach left and right child and return
        if (root.val < min || root.val > max) {
            root.left = left;
            root.right = right;
            return root;
        }
        // if current root should be deleted
            // if one of the result is null -> return non-null result
            // right result has no left child
                // attach left result to right result
                // return right result
            // left result has left child
                // find the smallest node in left result
                // attach left result to smallest node
                // return smallest node
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        if (right.left == null) {
            right.left = left;
            return right;
        }
        TreeNode smallest = findSmallest(right);
        smallest.left = left;
        smallest.right = right;
        return smallest;
    }
    // find smallest
    private TreeNode findSmallest(TreeNode root) {
        TreeNode prev = null;
        while (root != null) {
            prev = root;
            root = root.left;
        }
        return prev;
    }
}
