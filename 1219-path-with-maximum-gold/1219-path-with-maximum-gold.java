

class Solution {

    public boolean isSafe(int i, int j, int n, int m,
                          int[][] grid, int[][] v) {

        return (i >= 0 && i < n) &&
               (j >= 0 && j < m) &&
               (grid[i][j] != 0 && v[i][j] == 0);
    }

    public void goldcollect(int[][] grid, int i, int j,
                            int n, int m, int sum,
                            ArrayList<Integer> result, int[][] v) {

        // Add current cell's gold
        sum += grid[i][j];

        // Mark current cell as visited
        v[i][j] = 1;

        boolean canMove = false;

        // Down
        if (isSafe(i + 1, j, n, m, grid, v)) {
            canMove = true;
            goldcollect(grid, i + 1, j, n, m, sum, result, v);
        }

        // Up
        if (isSafe(i - 1, j, n, m, grid, v)) {
            canMove = true;
            goldcollect(grid, i - 1, j, n, m, sum, result, v);
        }

        // Right
        if (isSafe(i, j + 1, n, m, grid, v)) {
            canMove = true;
            goldcollect(grid, i, j + 1, n, m, sum, result, v);
        }

        // Left
        if (isSafe(i, j - 1, n, m, grid, v)) {
            canMove = true;
            goldcollect(grid, i, j - 1, n, m, sum, result, v);
        }

        // If no further movement is possible
        if (!canMove) {
            result.add(sum);
        }

        // Backtrack
        v[i][j] = 0;
    }

    public int getMaximumGold(int[][] grid) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = grid.length;
        int m = grid[0].length;

        int[][] verify = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] != 0) {
                    goldcollect(grid, i, j, n, m,
                                0, result, verify);
                }
            }
        }
        if (result.isEmpty()) {
    return 0;
}



        return Collections.max(result);
    }
}