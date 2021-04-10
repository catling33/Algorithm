package DFS;

public class LongestIncreasingPath_DFS {
    public int longestIncreasingPath(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // directions
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // record max length
        int maxLength = 0;
        // for each cell, do DFS
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, directions));
            }
        }
        // return maxLength
        return maxLength;
    }
    // DFS
    private int dfs(int[][] matrix, int i, int j, int[][] directions) {
        // intial value of length
        int length = 0;
        // pass each valid neighbor into next recursion
        // get the max length using its neighbors as start point
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                length = Math.max(length, dfs(matrix, x, y, directions));
            }
        }
        // include current node in the length and return
        return length + 1;
    }
    public static void main(String[] args) {
        LongestIncreasingPath_DFS sol = new LongestIncreasingPath_DFS();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(sol.longestIncreasingPath(matrix));
    }
}
