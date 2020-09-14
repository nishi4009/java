
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
        
public class rSolution {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    HashMap<Integer, ArrayList<Integer>> cityMap = new HashMap<>();
	long cost = 0;
//	int n = n;
	int m = cities.length;
	int libraryCost = c_lib;
	int roadCost = c_road;
	
	for (int i = 1; i <= n; i++) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(i);
		cityMap.put(i, list);
	}

	for (int a1 = 0; a1 < m; a1++) {
		int x = cities[a1][a1];
		int y = cities[a1][a1+1];
	
		ArrayList<Integer> list1 = cityMap.get(x);
		ArrayList<Integer> list2 = cityMap.get(y);
		
		if (list1 != list2) {
		list1.addAll(list2);
		list2.forEach(i -> cityMap.put(i, list1));
		}
	}
	if (libraryCost < roadCost)
		System.out.println((long) n * libraryCost);
	else {
		
		for (ArrayList<Integer> list : cityMap.values()) {
			int size = list.size();
			if (size > 0) {
				cost += libraryCost;
				cost += (size - 1) * roadCost;
				list.removeIf(i -> true);
			}
		}
		System.out.println(cost);
	}
	System.out.println(cost);
	
	return cost;
 }

  private static final Scanner scanner = new Scanner(System.in);
public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
   }