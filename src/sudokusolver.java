public class sudokusolver{
    private static final int size = 9;

//    print soduko board
    protected static void print_grid(int[][] grid){
        for(int i = 0 ; i<size;i++){
            for(int j = 0; j<size;j++){
                if(j%3==0){
                    System.out.print("  ");
                }
                System.out.print(grid[i][j] + " ");
            }
            if(i%3==2){
                System.out.println();
            }
            System.out.println();
        }
    }
//    true if number is in row
    private static boolean is_in_row(int[][] grid, int number, int row){
        for(int i = 0;i<size;i++){
            if(grid[row][i]==number){
                return true;
            }
        }
        return false;
    }

//true if number is in column
    private static boolean is_in_column(int[][] grid, int number, int column){
        for(int i = 0;i<size;i++){
            if(grid[i][column]==number){
                return true;
            }
        }
        return false;
    }
//    true if number is in smaller 3X3 grids
    private static boolean is_in_3X3_grid(int[][] grid,int number,int row,int column){
        int grid_row = row - row%3;
        int grid_column = column - column%3;
        for(int i = grid_row ; i<grid_row+3;i++){
            for(int j = grid_column; j<grid_column+3;j++){
                if(grid[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean is_valid(int[][] grid,int number, int row, int column){
        return !is_in_row(grid,number,row) && !is_in_column(grid,number,column) && !is_in_3X3_grid(grid,number,row,column);
    }


    protected static boolean solve(int[][] grid){
        for(int row = 0; row<size;row++){
            for(int column = 0;column<size;column++){
                if(grid[row][column]==0){
                    for(int n = 1;n<=size;n++){
                        if(is_valid(grid,n,row,column)){
                            grid[row][column] = n;

                            if(solve(grid)){
                                return true;
                            }
                            else{
                                grid[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}