import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class maxSub {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {

        TreeSet<Long> tree = new TreeSet<>();
        List<Long> list = new ArrayList<Long>();
        long sum = 0;
        long max = 0;
        for (int i = 0; i < a.length; i++) {
            sum = (sum + a[i]) % m;
           // System.out.println(i + ". element: " + a[i] + " Sum : " + sum);
            Long higher = tree.higher(sum);
            //System.out.println("Higher for sum " + sum + " is : " + higher);
            if (higher == null) {
                max = Math.max(max, sum);
            } else {
                max = Math.max(max, (sum - higher + m) % m);
            }
            //System.out.println("max: " + max);
            tree.add(sum);
        }
        System.out.println(" Ans : " + max);
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}