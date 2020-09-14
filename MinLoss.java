import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class MinLoss {

    // Complete the minimumLoss function below.
    static int minimumLoss(long[] price) {
        
       Map<Long, Long> hashmap = new HashMap<Long, Long>();
       for(int i = 0; i<price.length; i++){
        hashmap.put(price[i], (long)i);
       }

       Arrays.sort(price);
       long minLoss = Long.MAX_VALUE;
       for(int j = 1 ; j< price.length; j++){
        if((price[j] > price[j-1]) && (hashmap.get(price[j]) < hashmap.get(price[j-1])) ){
            minLoss = Math.min(minLoss, (price[j] - price[j-1]));
        }
       }
      // System.out.println("Minimum Loss " + minLoss);
       return (int)minLoss;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        int result = minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
