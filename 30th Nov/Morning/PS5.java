import java.util.*;

public class PS5 {
    
        public static int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 1) {
                        maxArea = Math.max(maxArea, findArea(grid, i, j));
                    }
                }
            }
            return maxArea/2;
        }
    
        private static int findArea(int[][] grid, int row, int col) {
            if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
                return 0;
            }
    
            grid[row][col] = 0;
            int count = 1;
    
            count += findArea(grid, row, col-1);
            count += findArea(grid, row, col+1);
            count += findArea(grid, row-1, col);
            count += findArea(grid, row+1, col);
    
            return count;
        }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 1},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0}
        };

        int maxArea = maxAreaOfIsland(matrix);
        System.out.println("Max area of the island: " + maxArea);
    }
}
