import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class finda
{

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    
    //long res = 0;
    long found = 0;
    long whole = n/s.length();
    int remainder = (int) n%s.length();
    for(char ch:s.toCharArray()){
        if(ch == 'a'){
            found++;
        }
    }
    long total = found * whole;
    //System.out.println("String: " + s + " found a: " + founda);
    if(remainder == 0)
        return total;
    else{
        String part = s.substring(0, remainder);
        for(char c : part.toCharArray()){
            if(c == 'a')
                total++;
        }
    }
    return total;

    }

    private static final Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) throws IOException {
      
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println("frequency of a: " + result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}