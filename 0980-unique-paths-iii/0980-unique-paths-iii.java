
class Solution {

    public boolean isSafe(int x, int y, int n, int m,
                          int[][] grid, int[][] visited) {

        return x >= 0 && x < n &&
               y >= 0 && y < m &&
               grid[x][y] != -1 &&
               visited[x][y] == 0;
    }

    public int uniquePathsIII(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        int startX = 0;
        int startY = 0;

        int remaining = 0;

        // Find starting cell and count non-obstacle cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] != -1) {
                    remaining++;
                }

                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        return solve(startX, startY, n, m,
                     grid, visited, remaining);
    }

    int solve(int x, int y, int n, int m,
              int[][] grid, int[][] visited,
              int remaining) {

        // Visit current cell
        remaining--;

        // Destination reached
        if (grid[x][y] == 2) {

            if (remaining == 0) {
                return 1;
            }

            return 0;
        }

        // Mark current cell visited
        visited[x][y] = 1;

        int count = 0;

        // Down
        if (isSafe(x + 1, y, n, m, grid, visited)) {
            count += solve(x + 1, y, n, m,
                           grid, visited, remaining);
        }

        // Left
        if (isSafe(x, y - 1, n, m, grid, visited)) {
            count += solve(x, y - 1, n, m,
                           grid, visited, remaining);
        }

        // Right
        if (isSafe(x, y + 1, n, m, grid, visited)) {
            count += solve(x, y + 1, n, m,
                           grid, visited, remaining);
        }

        // Up
        if (isSafe(x - 1, y, n, m, grid, visited)) {
            count += solve(x - 1, y, n, m,
                           grid, visited, remaining);
        }

        // Backtrack
        visited[x][y] = 0;

        return count;
    }
}