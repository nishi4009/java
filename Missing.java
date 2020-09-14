import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Missing {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {

        //System.out.println(" arr is " + arr);

        int alen = arr.length;
        int blen = brr.length;

        Map<Integer, Integer> aMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> bMap = new HashMap<Integer, Integer>();

        for(int i = 0; i< alen; i++){
            if(aMap.containsKey(arr[i]))
                aMap.put(arr[i], aMap.get(arr[i])+1);
            else
                aMap.put(arr[i], 1);
        }
        for(int i = 0; i< blen; i++){
            if(bMap.containsKey(brr[i]))
                bMap.put(brr[i], bMap.get(brr[i])+1);
            else
                bMap.put(brr[i], 1);
        }

        List<Integer> list = new ArrayList<Integer>();


        for(int element: bMap.keySet()){
            if(aMap.containsKey(element)){
                if(bMap.get(element) > aMap.get(element))
                    list.add(element);                
            }
            else
                list.add(element);
        }
        Collections.sort(list);

        int[] res = new int[list.size()];
      
        for(int i = 0; i< list.size(); i++){

            res[i] = list.get(i);
            System.out.println(res[i]);
        }

        return res;
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

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}