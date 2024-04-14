import java.util.Scanner;

public class NQueens {

    private static int N;
    private static int[][] board;
    static String bf="\033[34m";
    static String wf="\u001B[0m\n";
    static String of="\033[33m";
    static int count = 0;

    
    NQueens() {
        System.out.println(bf+"\n╔═════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                            "+of+"Welcome To N Queen Solver"+bf+"                        ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════╝\n"+wf);
        Scanner sc=new Scanner(System.in);
        while(true){
            int choice;
            if(count!=0){
                System.out.println("Total Number Of Solutions: "+count);
                count=0;
            }
            while (true) {
                System.out.println("\n[1] Solve\n[2] Quit");
                try {
                    choice=sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Enter only integer values!!");
                    sc.nextLine();
                }
            }
            switch(choice){
                case 1:
                    
                    System.out.print("Enter value of N: ");
                    N = sc.nextInt(); // You can change N to the desired board size
                    if(N>3){
                        board = new int[N][N];
                        System.out.println();
                        solveNQueens(0);
                    }
                    else{
                        System.out.println("\nN Queen problem can't be solved for "+N+"x"+N+" matrix!");
                    }
                break;
                case 2:
                    return;
                default:
                    System.out.println("\nEnter valid choice!!");
                break;
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        //check row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
    
    private static void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j]==1){
                    System.out.print(" "+bf+board[i][j] + " ");
                }
                else{
                    System.out.print(" "+of+board[i][j] + " ");
                }
            }
            System.out.println(wf);
        }
    }
    private static boolean solveNQueens(int row) {
        
        if (row == N) {
            count++;
            System.out.println("Solution "+count+":");
            printSolution();
            System.out.println();
            System.out.println();
            return true;
        }

        boolean res = false;
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                res = solveNQueens(row + 1) || res;
                board[row][col] = 0; // Backtrack
            }
        }
        return res;
    }
}
