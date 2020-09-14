import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class checkmagazine {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        if(magazine.length == 0 || note.length == 0){
            return;
        }

        Map<String, Integer> mag = new HashMap<>();

        for(String st : magazine){
            //System.out.println("Check for " + st);
            if(mag.containsKey(st)){
                mag.put(st, mag.get(st)+1);
            }
            else
                mag.put(st, 1);
        }   
        System.out.println("magazine: " + mag);
        Map<String, Integer> nt = new HashMap<>();

        for(String st : note){
            if(nt.containsKey(st)){
                nt.put(st, nt.get(st)+1);
            }
            else
                nt.put(st, 1);
        }
        System.out.println("notes: " + nt);

        boolean result = false;

        for(String str : note){
            if(mag.containsKey(str) && mag.get(str) >= nt.get(str)){
                result = true;
            }
            else {
                result = false;
                break;
            }
            System.out.println(str + "result: " + result);
        }


        if(result)
            System.out.println("Yes");
        else
            System.out.println("No");
        return;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
