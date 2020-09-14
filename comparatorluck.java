import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class comparatorluck {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int luckbalance = 0;

        Arrays.sort(contests, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return -1*Integer.compare(a[0], b[0]);
            }
        });
        int currluck = 0;
        for(int i = 0; i<contests.length; i++){
            System.out.println("Luck: " + contests[i][0] + " importance: " + contests[i][1]);
            if(contests[i][1] == 1 && k > 0){
                luckbalance += contests[i][0];
                k--;
            }
            else if(contests[i][1] == 1 && k ==0)
                luckbalance -= contests[i][0];
            else
                luckbalance += contests[i][0];
        }
        System.out.println(luckbalance);
        return luckbalance; 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
