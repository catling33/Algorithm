package Tree;

public class InorderSuccessorBST_Search {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // sanity check
        if (root == null || p == null) {
            return null;
        }
        // pointer to mark potential result
        TreeNode result = null;
        // search for p iteratively
        // if current node is bigger than p -> mark as potential result
        // other wise, continue to search
        while (root != null) {
            if (root.val > p.val) {
                result = root; // current node could be the result
                root = root.left; // search for the node in left subtree
            } else {
                root = root.right; // discard current node and left subtree, search for target in right subtree
            }
        }
        // return result
        return result;
    }
}
