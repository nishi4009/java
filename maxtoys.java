import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class maxtoys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int toys = 0;
        if(prices.length == 0)
            return 0;
        Arrays.sort(prices);
        int totalexp = 0;

        for(int i = 0; i<prices.length && prices[i] <= k; i++){
            int tempexp = totalexp + prices[i];
            System.out.println(prices[i] + " total exp so far: " + totalexp + " expected after this toy: " + tempexp + " total toys so far: "+ toys);
            if(tempexp <= k){
                totalexp = tempexp;
                toys++;
            }
            else
                break;
        }
        //System.out.println("prices: " + prices.length);
        return toys;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
