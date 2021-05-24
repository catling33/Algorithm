package Tree;

import java.util.*;

public class SerializeDeserialize {

    public String serialize(TreeNode root) {
        // sanity check
        if (root == null) {
            return "#";
        }
        // string builder to record the result so far
        StringBuilder sb = new StringBuilder();

        // dfs
        serializeDFS(root, sb);

        sb.deleteCharAt(sb.length() - 1);
        return new String(sb);
    }

    private void serializeDFS(TreeNode root, StringBuilder sb) {
        // base case
        if (root == null) {
            sb.append("#,");
            return;
        }
        // recursion rule
        // self
        sb.append(root.val + "");
        sb.append(",");
        // left
        serializeDFS(root.left, sb);
        // right
        serializeDFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // sanity check
        if (data == null || data.length() == 0 || data == "#") {
            return null;
        }
        // parse string into string array
        String[] array = data.split(",");
        // record the index on string array so far
        int[] index = new int[1];
        // dfs
        return deserializeDFS(array, index);
    }

    private TreeNode deserializeDFS(String[] array, int[] index) {
        // base case
        if (index[0] >= array.length) {
            return null;
        }
        if (array[index[0]].equals("#")) {
            return null;
        }
        // recursion rule:
        // self
        int value = Integer.valueOf(array[index[0]]);
        TreeNode root = new TreeNode(value);

        // append left
        index[0]++;
        root.left = deserializeDFS(array, index);
        // apend right
        index[0]++;
        root.right = deserializeDFS(array, index);

        return root;
    }

    public static void main(String[] args) {
        SerializeDeserialize sol = new SerializeDeserialize();
        String data = "3,9,20,#,#,15,7";
        TreeNode root = sol.deserialize(data);
        System.out.println(sol.serialize(root));
    }
}
