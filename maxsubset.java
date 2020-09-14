import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class maxsubset {

    // Complete the maxSubsetSum function below.
    public static int maxSubsetSum(int[] arr) {
  int n = arr.length;

        int[] maxUpTo = new int[n];
        
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            int valOrZero = Math.max(0, val);
            
            int max1 = get(maxUpTo, i - 1);
            int max2 = get(maxUpTo, i - 2);
            
            int temp = max1 + valOrZero;
            maxUpTo[i] = Math.max(max1, max2 + valOrZero);
            System.out.println(i + ". max1: " + max1 + " max2: " + max2 + " val: " + val + " valorzero: " + valOrZero + " maxupTo: " + maxUpTo[i] );
        }
        System.out.println(maxUpTo[n-1]);
        return maxUpTo[n -1];
    }
    
    private static int get(int[] values, int index) {
        if (index < 0) {
            return 0;
        } else {
            return values[index];
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        System.out.println(res);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
