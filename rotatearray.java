import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class rotatearray {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
       // System.out.println(a.length);
        if(d > a.length)
            return a;
        int[] temp = new int[a.length];

        for(int i = d, j = 0; i<a.length; i++, j++){
            System.out.println("1. Pushing "+ a[i] + " temp");
            temp[j] = a[i];
        }
        for(int i = temp.length-d, j=0; j<= d; i++, j++){
            if(i >= a.length)
                break;
            System.out.println("2. Pushing "+ a[j] + " temp");
            temp[i] = a[j];
        }
        for (int i = 0; i < temp.length; i++) {
           System.out.print(temp[i] + " ");
        }

        //System.out.println(temp.length);
        return temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        /*for (int i = 0; i < result.length; i++) {
           System.out.print(result[i] + " ");
        }*/

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
