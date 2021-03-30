package DFS;

import java.util.ArrayList;
import java.util.List;

public class FlipMatchPreOrder {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        // result array list
        List<Integer> result = new ArrayList<>();
        // sanity check
        if (root == null || voyage == null || voyage.length == 0) {
            result.add(-1);
            return result;
        }
        // int[] to indicate current index in voyage
        int[] index = new int[1];
        // DFS
        dfs(root, index, result, voyage);
        // deal with result array
        if (!result.isEmpty() && result.get(0) == -1) {
            result.clear();
            result.add(-1);
        }
        return result;
    }
    // DFS
    private void dfs(TreeNode root, int[] index, List<Integer> result, int[] voyage) {
        // base case
        if (root == null) {
            return;
        }

        // if current node doesn't match
        if (root.val != voyage[index[0]]) {
            result.clear();
            result.add(-1);
            return;
        }
        // go to next element in voyage
        index[0]++;
        // if left child doesn't match the next element
        if (index[0] < voyage.length && root.left != null && root.left.val != voyage[index[0]]) {
            result.add(root.val);
            dfs(root.right, index, result, voyage);
            dfs(root.left, index, result, voyage);
        } else {// if left child matches the next element
            dfs(root.left, index, result, voyage);
            dfs(root.right, index, result, voyage);
        }
    }
}
