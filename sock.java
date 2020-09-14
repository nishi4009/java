import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class sock {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        int res = 0;
        System.out.println(ar);
        Arrays.sort(ar);
        for(int i=0; i<n-1; i++){
            //if(i!=n){
                System.out.println("i: " + i + " ar: " + ar[i]);
                if(ar[i] == ar[i+1]){
                    System.out.println("Match found");
                    res++;
                    i++;
                }
            //}
        }

        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        //int n = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        /*String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }*/

        
        int result = sockMerchant(n, ar);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
