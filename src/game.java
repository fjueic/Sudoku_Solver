public class game {
    public static void main(String[] args){
        int[][]  test = {
                {0,5,1,0,0,0,0,9,0},
                {0,0,0,7,8,0,0,0,0},
                {0,0,0,0,6,9,3,0,4},
                {3,0,0,1,0,2,0,5,0},
                {0,6,5,0,7,0,0,0,0},
                {0,0,0,0,0,0,9,2,8},
                {4,2,0,0,0,0,0,0,3},
                {8,0,0,0,0,0,1,0,5},
                {0,0,7,6,0,4,0,0,0}
        };
        sudokusolver.print_grid(test);
        if(sudokusolver.solve(test)){
            System.out.println("Done.");
        }else {
            System.out.println("Not possible.");
        }
        sudokusolver.print_grid(test);
    }
}
