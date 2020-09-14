import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class newyear {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribes = 0;
     //  System.out.println(q.length);
      
        for(int i = q.length-1; i>0; i--){
            System.out.println(i + ". value: " + q[i] + " swaps: " + bribes);
            if(q[i] != i+1){
                if(i-1 >= 0 && q[i-1] == i+1){
                    bribes++;
                    swap(q, i, i-1);
                }
                else if(i-2 >= 0 && q[i-2] == i+1){
                    bribes +=2;
                    swap(q, i-2, i-1);
                    swap(q, i-1, i);
                }
                else{
                    System.out.println("Too Chaotic");
                    return;
                }
            }
        }
        for(int i = 0; i< q.length; i++){
            System.out.print(q[i] + " ");
        }
        
        System.out.println("bribes: " + bribes);
        return;

    }

    public static void swap(int[] arr, int a, int b){
        //System.out.println("Swaping: " + arr[a] +" with "+ arr[b]);
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
