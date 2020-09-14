import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class minswaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        if(arr.length == 0)
            return swaps;

        int min = arr[0];
        int minIndex = 0;

        for(int i = 0; i<arr.length; i++){
            if(arr[i] < arr[minIndex]){
                min = arr[i];
                minIndex = i;
            }
        }
        System.out.println("Min element at " + minIndex + " with Value: " + min );

        if(minIndex != 0){
            int temp = arr[minIndex];
            arr[minIndex] = arr[0];
            arr[0] = temp;
            swaps++;
            printar(arr);
        }

        for(int i = 1; i< arr.length; i++){
            int pos = arr[i] - min;
            while(arr[i] != arr[pos]){
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
                swaps++;
                pos = arr[i] - min;
                printar(arr);
            }
        }
        
        return swaps;
    }

    public static void printar(int[] arr){
        if(arr.length !=0){
            for(int i = 0; i<arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int[] arr, int a, int b){
        //System.out.println("Swaping: " + arr[a] +" with "+ arr[b]);
        //System.out.println("Swaps: " + arr[a] + " with "+ arr[b]);
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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

        int res = minimumSwaps(arr);
        System.out.println(res);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
