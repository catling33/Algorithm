package Array;

import java.util.Arrays;

public class rotateTheBox {
    public char[][] rotateTheBox(char[][] box) {
        // sanity check
        // process stones in each row
        // map row to col
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            helper(box[i]);
            map(box, result, i);
        }
        // return
        return result;
    }

    private void helper(char[] row) {
        if (row.length <= 1) {
            return;
        }
        int i = 0;
        int count = 0;
        while (i <= row.length) {
            if (i == row.length || row[i] == '*') { // meet obstacle or reach bottom
                int j = i - 1;
                while (count > 0) {
                    count--;
                    row[j--] = '#'; // put down stone
                }
            } else if (row[i] == '#') {
                count++;
                row[i] = '.'; // take out stone
            }
            i++;
        }
    }

    private void map(char[][] box, char[][] result, int i) {
        for (int j = 0; j < box[i].length; j++) {
            result[j][result[0].length - i - 1] = box[i][j];
        }
    }

    public static void main(String[] args) {
        rotateTheBox sol = new rotateTheBox();
        char[][] box = {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
        char[][] result = sol.rotateTheBox(box);
        for (char[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }
}
