package Tree;

public class BinaryTreeCameras {
    public int minCameraCover(TreeNode root) {
        // sanity check
        if (root == null) {
            return 0;
        }
        // record cameras placed so far
        int[] count = new int[1];
        // dfs
        int rootResult = dfs(root, count);
        if (rootResult == 3) {
            count[0]++;
        }
        // return number of cameras
        return count[0];
    }

    private int dfs(TreeNode root, int[] count) {
        // base case
        if (root == null) {
            return 2;
        }
        // go right
        int rightResult = dfs(root.right, count);
        // go left
        int leftResult = dfs(root.left, count);
        // self
        // if any child can't be covered --> place a camera here
        if (leftResult == 3 || rightResult == 3) {
            count[0]++;
            return 1;
        }
        // if both are covered by children --> current camera can't be covered
        if (leftResult == 2 && rightResult == 2) {
            return 3;
        }
        // if any child has camera --> current can be covered by child
        return 2;
    }

    public static void main(String[] args) {
        BinaryTreeCameras sol = new BinaryTreeCameras();
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        n1.right = n2;
        n2.right = n3;
        System.out.println(sol.minCameraCover(n1));
    }
}
