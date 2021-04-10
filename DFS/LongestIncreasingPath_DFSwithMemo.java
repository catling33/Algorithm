package DFS;

public class LongestIncreasingPath_DFSwithMemo {
    public int longestIncreasingPath(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // memo
        int[][] memo = new int[matrix.length][matrix[0].length];
        // directions
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // record max length
        int maxLength = 0;
        // for each cell, do DFS
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, directions, memo));
            }
        }
        // return maxLength
        return maxLength;
    }
    // DFS
    private int dfs(int[][] matrix, int i, int j, int[][] directions, int[][] memo) {
        // check if length is in memo
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        // pass each valid neighbor into next recursion
        // get the max length using its neighbors as start point
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, x, y, directions, memo));
            }
        }
        // include current node in the length and return
        return ++memo[i][j];
    }
}

// TC = O(V + E) = O(mn + 4mn) = O(mn), because each cell and edge is visited once and only once
// SC = O(mn), space used for memo