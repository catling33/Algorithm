package Tree;

import java.util.*;

public class SerializeDeserialize {

    // serialize
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        // result list to print
        List<String> list = new ArrayList<>();
        // FIFO queue to store visited nodes
        Deque<TreeNode> queue = new ArrayDeque<>();
        // initial status
        queue.offer(root);
        // BFS
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // deal with left child
            if (cur.left == null) {
                list.add("#");
            } else {
                list.add(cur.left.val + "");
                queue.offer(cur.left);
            }
            // deal with right child
            if (cur.right == null) {
                list.add("#");
            } else {
                list.add(cur.right.val + "");
                queue.offer(cur.right);
            }
        }

        // remove the tailing "#"
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) == "#") {
                list.remove(i);
            } else if (list.get(i) != "#") {
                break;
            }
        }
        // return string
        return String.join(",", list);
    }

    // deserialize
    public TreeNode deserialize(String data) {

        // parse the node values in data string into array of strings
        String[] arr = data.split(",");
        // check if the tree is null
        if (arr[0].equals("#")) {
            return null;
        }

        // first element in the array is root
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        // queue to store visited nodes
        LinkedList<TreeNode> queue = new LinkedList<>();
        // initial status
        queue.offer(root);
        // indicate the current index of element in array
        int index = 1;

        // BFS
        while (!queue.isEmpty() && index < arr.length) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                // create and attach left child
                TreeNode left = null;
                if (!arr[index].equals("#")) { // value of left child is not null
                    left = new TreeNode(Integer.parseInt(arr[index]));
                }
                cur.left = left;
                queue.offer(left);
                index++;

                // create and attach right child
                TreeNode right = null;
                if (index < arr.length && !arr[index].equals("#")) {
                    right = new TreeNode(Integer.parseInt(arr[index]));
                }
                cur.right = right;
                queue.offer(right);
                index++;
            }
        }
        // return root
        return root;
    }

    public static void main(String[] args) {
        SerializeDeserialize sol = new SerializeDeserialize();
        String data = "3,9,20,#,#,15,7";
        TreeNode root = sol.deserialize(data);
        System.out.println(sol.serialize(root));
    }
}
