class Solution {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // mark the guard with 2
        for(int[] guard: guards){
            grid[guard[0]][guard[1]] = 2;
        }
        
        //mark the wallswith 3
        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = 3;
        }

        for(int[] guarded: guards){
            markGuarded(guarded[0], guarded[1], grid);
        }
        
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
    public static void markGuarded(int row, int col, int[][] grid) {
        // Up
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1; // Marking as guarded
        }

        // Down
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1; // Marking as guarded
        }

        // Left
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1; // Marking as guarded
        }

        // Right
        for (int j = col + 1; j < grid[0].length; j++) {
            if (grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1; // Marking as guarded
        }
    }
}