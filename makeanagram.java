import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class makeanagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        int cdelete = 0;
        Map<Character, Integer> amap = new HashMap<>();
        Map<Character, Integer> bmap = new HashMap<>();

        for(Character ch: a.toCharArray()){
            amap.put(ch, amap.getOrDefault(ch, 0) +1);
        }
        for(Character ch : b.toCharArray()){
            bmap.put(ch, bmap.getOrDefault(ch, 0)+1);
        }

        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();

        Arrays.sort(arr);
        Arrays.sort(brr);
      //  System.out.println(amap);
       // System.out.println(bmap);

        for(Map.Entry aEntry: amap.entrySet()){
            if(bmap.containsKey(aEntry.getKey())){
                //if(aEntry.getValue() != bmap.get(aEntry.getKey())){
                  int diff = Math.abs((int)aEntry.getValue()-bmap.get(aEntry.getKey()));
                   cdelete += diff;
         //          System.out.println("Diff: " + diff + " total char to be deleted so far: " + cdelete); 
                //}
            }
            else{
                cdelete += (int)aEntry.getValue();
           //     System.out.println("char: " + aEntry.getKey() + " not found total char to be deleted so far: " + cdelete);                 
            }
        }

        for(Map.Entry aEntry: bmap.entrySet()){
            if(!amap.containsKey(aEntry.getKey())){
                cdelete +=(int)aEntry.getValue();
             //   System.out.println("char: " + aEntry.getKey() + " not found total char to be deleted so far: " + cdelete);                 
            }
        }

        return cdelete;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        System.out.println(res);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
