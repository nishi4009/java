import java.io.*;
import java.util.*;

class reversed{
	static int reverse(int x){
		int reversed = 0;
		int pop;

		while(x != 0){
			pop = x%10;
			x /= 10;
		
		reversed = (reversed*10) + pop;
		System.out.println("pop = " + pop + " x= " + x + " reversed= " + reversed);
		}
		return reversed;
	}
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//int x = 435;
		int res = reverse(q);
		System.out.println("Reversed No: " + res);

	}
}