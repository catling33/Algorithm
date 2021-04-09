package Tree;

public class InorderSuccessorBST_Recursion {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // sanity check
        if (root == null) {
            return root;
        }
        // record previous node
        TreeNode[] prev = new TreeNode[1];
        // record answer
        TreeNode[] result = new TreeNode[1];
        // recursion
        helper(prev, result, root, p);
        return result[0];
    }
    // recursion
    private void helper(TreeNode[] prev, TreeNode[] result, TreeNode node, TreeNode p) {
        // base case
        // if node is null or result is found
        if (node == null || result[0] != null) {
            return;
        }

        // go left
        helper(prev, result, node.left, p);

        // self
        if (prev[0] != null && result[0] == null) {
            result[0] = node;
            return;
        }

        if (node.val == p.val) {
            prev[0] = node;
        }

        // go right
        helper(prev, result, node.right, p);
    }

    public static void main(String[] args) {
        SerializeDeserialize tool = new SerializeDeserialize();
        InorderSuccessorBST_Recursion sol = new InorderSuccessorBST_Recursion();
        TreeNode root = tool.deserialize("5,3,6,2,4,#,#,1");
        TreeNode result = sol.inorderSuccessor(root, new TreeNode(1));
        System.out.println(result == null ? null : result.val);
    }
}
