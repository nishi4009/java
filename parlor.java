import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class parlor {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {

        int[] result = new int[2];
        //int firstele = arr[0];
        //int second = 0;
        Map<Integer, Integer> map = new HashMap<>();


        for(int i= 0; i< arr.length; i++){
            int x = arr[i];
            int y = m-x;
            Integer j = map.get(y);
            //System.out.println("Checking map for " + y);
            if(j != null){
              //  System.out.println("Map values found "+ i + " and " + j );
                result[0] = j+1;
                result[1] = i+ 1;
                break;
            }
            //System.out.println("adding " + x + " i: " + i + "in the map");
            map.put(x, i);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));
                System.out.println(result[i]);

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                    System.out.println(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
