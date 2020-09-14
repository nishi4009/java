import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class homework {

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {

        if(arr.length == 0)
          return 0;

        TreeMap<Integer, Integer> fmap = new TreeMap<>();
        TreeMap<Integer, Integer> bmap = new TreeMap<>();

        int[] brr = new int[arr.length];

        for(int i =0; i< arr.length; i++){
            fmap.put(arr[i], i);
            bmap.put(arr[i], i);
            brr[i] = arr[i];
        }
        
        int fCount = 0, bCount = 0;
        int index = 0;

        System.out.println(fmap);
        while(index < arr.length){
            int smallest = fmap.firstKey();
            if(arr[index] != smallest){
                int tindex = fmap.get(smallest);
                int temp = arr[index];
                arr[index] = smallest;
                arr[tindex] = temp;
                
                fmap.put(arr[tindex], tindex);
                fCount++;
            }
            index++;
            fmap.remove(smallest);
            System.out.println(fmap);
        }
        index = brr.length-1;
        while(index >=0){
            int smallest = bmap.firstKey();
            if(brr[index] != smallest){
                int tindex = bmap.get(smallest);
                int temp = brr[index];
                brr[index] = smallest;
                brr[tindex] = temp;

                bmap.put(brr[tindex], tindex);
                bCount++;
            }

            index--;
            bmap.remove(smallest);
            System.out.println(bmap);
        }


        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        for(int i = 0; i<arr.length; i++){
            System.out.print(brr[i] + " ");
        }

        System.out.println("\n Count: " + fCount + " des Count: " + bCount);

        return Math.min(fCount, bCount);

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

        int result = lilysHomework(arr);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
