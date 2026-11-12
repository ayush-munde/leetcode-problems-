
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m - 1;
        int row = -1;

        // First binary search: Find correct row
        while (low <= high) {
            int midrow = low + (high - low) / 2;

            if (target < matrix[midrow][0]) {
                high = midrow - 1;
            }
            else if (target > matrix[midrow][n - 1]) {
                low = midrow + 1;
            }
            else {
                row = midrow;
                break;
            }
        }

        if (row == -1)
            return false;

        // Second binary search: Find target in row
        low = 0;
        high = n - 1;

        while (low <= high) {
            int midcol = low + (high - low) / 2;

            if (matrix[row][midcol] == target)
                return true;
            else if (matrix[row][midcol] > target)
                high = midcol - 1;
            else
                low = midcol + 1;
        }

        return false;
    }
}
