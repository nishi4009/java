import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class shortpallindrome {

    // Complete the shortPalindrome function below.
    private static int M = 1000000007;
    private static char[] a;
    static int shortPalindrome(String s) {

        a = s.toCharArray();
        int count = 0;
        for (int i = 97; i <= 122; i++) {
            count = (count + makeArray((char) i)) % M;
        }

        return count;
    }

    //97-122

    private static int makeArray(char yo) {
        System.out.println("yo: " + yo);
        int[] curr = new int[4];
        int[] ab = new int[26];


        for (int i = 0; i<a.length; i++) {

            char x = a[a.length-i-1];
            System.out.println("x: " + x);
            int previousone = curr[0];
            System.out.println("previousone: " + previousone);

            if (yo == x) {
                curr[3] = (curr[3] + curr[2]) % M;
                curr[0] = (1 + curr[0]) % M;
            }
            curr[2] = (curr[2] + ab[(int) x - 97]) % M;
            ab[(int) x - 97] = (ab[(int) x - 97] + previousone) % M;
            curr[1] = (curr[1] + previousone) % M;
        }
        return curr[3];
    }
        

      
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String s = scanner.nextLine();

        int result = shortPalindrome(s);

        bufferedWriter.write(String.valueOf(result));
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
