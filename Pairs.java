import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pairs {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        int len = arr.length;
        int res  =0 ;
        Arrays.sort(arr);
        for(int i = 0; i< len-1; i++){
            for (int j = i+1; j< len && arr[j]-arr[i] <= k; j++){
                //System.out.println(i + ".  Comapring " + arr[i] + " with " + arr[j]);
                if(arr[j]-arr[i] == k ){
                    //System.out.println( arr[j] + " and " + arr[i] + " has difference as " + k);
                    res++;
                }
            }
        }
        System.out.println(" Total " + res + " pairs found with diff of " + k);
    return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
