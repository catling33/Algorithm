package DFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public List<String> Restore(String ip) {
        // sanity check
        if (ip == null || ip.length() < 4) {
            return null;
        }
        // result array list
        List<String> result = new ArrayList<>();
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        // convert to charArray
        char[] array = ip.toCharArray();
        // dfs
        dfs(0, 0, sb, result, array);
        // return
        return result;
    }

    // index represent the recursion tree level
    // start represent the start index of ip string in current level
    private void dfs(int index, int start, StringBuilder sb, List<String> result, char[] array) {
        // base case
        if (index == 4) { // all input already included in four chunks
            if (sb.length() == array.length + 4) {
                result.add(sb.substring(0, sb.length() - 1)); // exclude the ending "."
            }
            return;
        }
        // append
        // next recursion
        // remove
        if (start < array.length) {
            sb.append(array[start]).append('.');
            dfs(index + 1, start + 1, sb, result, array);
            // sb = 0.
            sb.delete(sb.length() - 2, sb.length());
        }

        if (start + 1 < array.length) {
            char a = array[start];
            char b = array[start + 1];
            if (a != '0') { // avoid leading 0
                sb.append(a).append(b).append('.');
                dfs(index + 1, start + 2, sb, result, array);
                sb.delete(sb.length() - 3, sb.length());
            }
        }

        if (start + 2 < array.length) {
            char a = array[start];
            char b = array[start + 1];
            char c = array[start + 2];
            if (a == '1' || a == '2' && b >= '0' && b <= '4'
                    || a == '2' && b == '5' && c >= '0' && c <= '5') {
                sb.append(a).append(b).append(c).append('.');
                dfs(index + 1, start + 3, sb, result, array);
                sb.delete(sb.length() - 4, sb.length());
            }
        }
    }

    public static void main(String[] args){
        RestoreIPAddress sol = new RestoreIPAddress();
        String IP = "25525511135";
        System.out.println(sol.Restore(IP));
    }
}
