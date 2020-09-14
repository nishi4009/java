import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class countValley {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        if(s.length() == 0 ) return 0;
        int vCnt =0;
        int total = 0;
        
        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i) == 'U'){
                vCnt++;
                System.out.println(i + ". Up, count: " + vCnt);
                
             }
            else if(s.charAt(i) == 'D'){
                vCnt--;
                if(vCnt == -1)
                    total++;
                System.out.println(i + ". Down, count:  " + vCnt + " Total Valleys: " + total);
               
            }            
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = 8;
  //      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = "UDDDUDUU";
        String s1 = "DDUUDDUDUUUD";
        String s2 = "DUDUUUUUUUUDUDDUUDUUDDDUUDDDDDUUDUUUUDDDUUUUUUUDDUDUDUUUDDDDUUDDDUDDDDUUDDUDDUUUDUUUDUUDUDUDDDDDDDDD";

        int result = countingValleys(100, s2);

        System.out.println("Valleys: " +result);
        scanner.close();
    }
}
