import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class grid {

    // Complete the connectedCell function below.
    static int maxConnCells = 0;
    static int connectedCell(int[][] matrix) {
        for(int i = 0; i< matrix.length; i++){
            for (int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j] ==1){
                    dfs(matrix, i, j, 0);
                }
            }
        }
        System.out.println(maxConnCells);
        return maxConnCells;

    }

    private static void dfs(int[][]grid, int i, int j, int currCell){
        if( i < 0  || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)        {
            return ;
        }

        currCell++;
        maxConnCells = Math.max(maxConnCells, currCell);

        grid[i][j] = 0;
        dfs(grid, i-1, j, currCell);
        dfs(grid, i+1, j, currCell);
        dfs(grid, i, j+1, currCell);
        dfs(grid, i, j-1, currCell);
        dfs(grid, i-1, j+1, currCell);
        dfs(grid, i+1, j+1, currCell);
        dfs(grid, i-1, j-1, currCell);
        dfs(grid, i+1, j-1, currCell);
        grid[i][j] = 1;
              //  currCell--;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}