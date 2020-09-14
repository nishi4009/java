// share price problem.
package com.kh;

public class Solution6 {

    public static void findSq(int diff, int[] prices){
        int finalStart = -1;
        int finalEnd = -1;

        int currStart = 0;
        int currEnd = -1;

        for (int i=1;i<prices.length;i++) {
            if (Math.abs(prices[i] - prices[i - 1]) <= diff) {
                currEnd = i;
            } else {
                // check if we got a sequence so far and update final start/end if it is longer.
                if (currEnd != -1) {
                    int diffCurr = currEnd - currStart;
                    int diffFinal = finalEnd - finalStart;
                    if (diffCurr > diffFinal) {
                        finalStart = currStart;
                        finalEnd = currEnd;
                    }
                    currEnd = -1;
                }
                currStart = i;
            }
        }

        // check if we got a sequence so far and update final start/end if it is longer.
        if (currEnd != -1) {
            int diffCurr = currEnd - currStart;
            int diffFinal = finalEnd - finalStart;
            if (diffCurr > diffFinal) {
                finalStart = currStart;
                finalEnd = currEnd;
            }
        }

        System.out.println("=========start = " + finalStart + ", end = " + finalEnd + "=====");
        for(int i = finalStart; i <= finalEnd; i++) {
            System.out.println(prices[i]);
        }
    }
    public static void main(String args[]) {
        int []a = {2, 3, 1, 3};
        findSq(2, a);

        int []b = {2, 4, 3, 6, 6, 3};
        findSq(0, b);

        int []c = {1, 2, 1, 2, 2, 1, 3, 1, 1, 2, 2, 2, 2};
        findSq(1, c);
    }
}