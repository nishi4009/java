import java.util.*;
import java.util.List;


public class trade {
    public static List<Integer> find(int[] sysA, int[] sysB) {

        ArrayList<Integer> out = new ArrayList<>();
        int lpCount = 0;

       Arrays.sort(sysA);

        for (int i = 0; i < sysB.length; i++) {
            //System.out.println(sysB[i]);
            int val = sysB[i];

            int count = 0;
            for (int j = 0; j < sysA.length ; j++) {// && sysA[j]<= val
                lpCount++;
                if (sysA[j] <= val) {

                    count ++;
                }
                else 
                  break;                
            }            
            out.add(count);
        }
       // System.out.println("Loop ran " + lpCount);
        return out;
    }
    public static void main (String args[]) {
        int []sysA = {2, 4, 6};
        int []sysB = {4, 7};
        List out = find(sysA, sysB);
        for(int i = 0; i < out.size(); i++) {
            System.out.print(out.get(i));
            System.out.print(" ");
        }

        System.out.println("\n=======================");


        int []sysAA = {5, 19, 9, 8, 16};
        int []sysBB = {6, 3, 15, 16};
        long startTime = System.nanoTime();
        List out2 = find(sysAA, sysBB);
        long stopTime = System.nanoTime();
        for(int i = 0; i < out2.size(); i++) {
            System.out.print(out2.get(i));
            System.out.print(" ");
        }
        System.out.println("Execution Time: " + (stopTime-startTime));


        System.out.println("\n==================================");


        int []systemAA = {5, 19, 9, 8, 16, 32, 10, 13, 17, 22, 43, 45, 7, 6, 12, 11, 21, 14, 13, 51, 64, 23, 4, 2};
        int []systemBB = {6, 3, 15, 16, 25};
        long stTime = System.nanoTime();
        List out3 = find(systemAA, systemBB);
        long sTime = System.nanoTime();
        for(int i = 0; i < out3.size(); i++) {
            System.out.print(out3.get(i));
            System.out.print(" ");
        }
        System.out.println("Execution Time: " + (sTime-stTime));

        System.out.println("\n==================================");

        int []systemA = {5, 19, 9, 8, 16, 32, 10, 13, 17, 22, 43, 45, 7, 6, 12, 11, 21, 14, 13, 51, 64, 23, 4, 2, 23, 24, 33, 39, 75, 93, 77, 65, 49, 38};
        int []systemB = {6, 3, 15, 16, 25, 30, 12, 43, 39, 22, 10};
        long strTime = System.nanoTime();
        List out4 = find(systemA, systemB);
        long stpTime = System.nanoTime();
        for(int i = 0; i < out4.size(); i++) {
            System.out.print(out4.get(i));
            System.out.print(" ");
        }
        System.out.println("Execution Time: " + (stpTime-strTime));

    }
}