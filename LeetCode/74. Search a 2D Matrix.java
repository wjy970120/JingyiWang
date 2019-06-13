/* Search a 2D Matrix:
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */

class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        
        // Search from the right corner.
        // If the current number is greater than target, then column-- and search in the same row.
        // If the current number is less than target, then row++.
        while(i < matrix.length && j >= 0) {
        	if(matrix[i][j] == target) return true;
        	else if(matrix[i][j] > target) j--;
        	else i++;
        }
        return false;
    }
}