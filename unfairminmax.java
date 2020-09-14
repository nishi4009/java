import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class unfairminmax {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        if(arr.length ==0)
            return 0;

        int minUnfair = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for(int i = 0; i<=arr.length-k; i++){
            minUnfair = Math.min(minUnfair, (arr[i+k-1] - arr[i]));
            System.out.println("min: " + arr[i] + " max: " + arr[i+k-1] + " minunfairness: " + minUnfair);
        }
        System.out.println(minUnfair);
        return minUnfair;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
