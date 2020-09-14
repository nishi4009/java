import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class cntriplet {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> leftmap = new HashMap<>();
        Map<Long, Long> rightmap = new HashMap<>();

        long count = 0;

        for(long item:arr){
            rightmap.put(item, rightmap.getOrDefault(item, 0l)+1);
        }
        System.out.println(rightmap);
        
        for(int i=0; i<arr.size(); i++){
            long mid = arr.get(i);
            long c1 = 0, c3 = 0;

            rightmap.put(mid, rightmap.getOrDefault(mid, 0l)-1);
            if(leftmap.containsKey(mid/r) && mid %r ==0){
                c1 = leftmap.get(mid/r); 
            }

            if(rightmap.containsKey(mid * r)){
                c3 = rightmap.get(mid*r);
            }

            count += c1*c3;
            System.out.println("c1: " + c1 + " c3: " + c3 + " count: " + count);

            leftmap.put(mid, leftmap.getOrDefault(mid, 0l) + 1);
        }

        System.out.println(rightmap);
        System.out.println(leftmap);
        return count;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
