package Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeFromString {
    public TreeNode str2tree(String s) {
        int[] index = new int[]{0};
        return helper(s, index);
    }

    private TreeNode helper(String s, int[] index) {
        // base case
        if (index[0] == s.length()) {
            return null;
        }

        // get root
        int value = getNum(s, index);
        TreeNode newNode = new TreeNode(value);

        // attach left child
        if (index[0] < s.length() && s.charAt(index[0]) == '(') {
            index[0]++;
            newNode.left = helper(s, index);
        }

        // attach right child
        if (index[0] < s.length() && s.charAt(index[0]) == '(') {
            index[0]++;
            newNode.right = helper(s, index);
        }

        // return root
        index[0]++;
        return newNode;

    }

    // get value of root
    private int getNum(String s, int[] index) {
        boolean isNegative = false;
        if (s.charAt(index[0]) == '-') {
            isNegative = true;
            index[0]++;
        }
        int num = 0;
        while (index[0] < s.length() && Character.isDigit(s.charAt(index[0]))) {
            num = num * 10 + (s.charAt(index[0]) - '0');
            index[0]++;
        }

        return isNegative ? num * -1 : num;
    }

    public static void main(String[] args) {
        TreeFromString sol = new TreeFromString();
        String s = "4(2(3)(1))(6(5))";
        TreeNode result = sol.str2tree(s);
        List<Integer> array = preorderPrint(result);
        System.out.print(array);
    }

    private static List<Integer> preorderPrint(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private static void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // self
        result.add(root.val);
        // left
        preOrder(root.left, result);
        // right
        preOrder(root.right, result);
    }

}
