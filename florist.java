import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class florist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {

        int minCost = 0;
        if(c.length == 0)
            return 0;

        Arrays.sort(c);

        int[] temp = new int[c.length];

        for(int i =c.length-1, j=0; j < c.length && i>=0; i--, j++){
            temp[j] = c[i];
        }
        int count = 0;
        if(k == c.length){ 
            for(int i =0; i< c.length &&  i != k; i++){
                minCost += c[i];
            }
        }
        else if(k < c.length){
            int i = 0;
            for(i = 0; i< k; i++){
                minCost += temp[i];
                System.out.println("adding " + temp[i] + " to cost, so far: " + minCost);
                
            }

            int prev = 1;
          //  int count = 0;
            for(; i< c.length; i++){
                minCost += (prev+1)*temp[i];
                count++;
                if(count == k){
                    prev++;
                    count = 0;
                }
                System.out.println(count + ". special adding " + temp[i] + " to cost so far: " + minCost);
                
            } 
        }
        System.out.println(minCost);
        return minCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
