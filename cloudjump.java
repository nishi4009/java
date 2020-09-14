import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class cloudjump {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        //int i = 0;
        for(int i=0; i<c.length-1; i++){
            System.out.println("i: " + i + " jumps: " + jumps);
            if(c[i+1] == 1){
                jumps++;
                i++;
            }
            else{
                if((i < c.length-2) && c[i+2] == 1){
                    jumps++;
                }
                else{
                    jumps++;
                    i++;
                }
            }
        }

        return jumps;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = 6;
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] d = {0, 0, 0, 1, 0, 0};

        int[] c = {0, 0, 1, 0, 0, 1, 0};//new int[n];
       
        int result = jumpingOnClouds(c);
        System.out.println("Total Jumps: " + result);

        scanner.close();
    }
}