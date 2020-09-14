import java.util.*;
import java.io.*;
import java.math.*;


public class findanagrams{

	static void findamagraspos(String s, String p){
		if(s.length() ==0 || p.length() == 0 || p.length() > s.length()){
			System.out.println("Wrong inputs");
			return;
		}

		List<Integer> result = new ArrayList<Integer>();

		System.out.println("received: s: " + s + " p: " + p);

		int lefti = 0;
		int righti = p.length()-1;

		char[] pArr = p.toCharArray();
		Arrays.sort(pArr);
		p = new String(pArr);
		//System.out.println("New p: " + p);

		while (righti < s.length()){
			char[] x = s.substring(lefti, righti+1).toCharArray();
			Arrays.sort(x);
			String q = new String(x);
			//System.out.println("Substring: " + q);
			if(p.equals(q)){
				//System.out.println("StartIndex : " + lefti);
				result.add(lefti);
			}
			lefti++;
			righti++;
		}


		System.out.println(result.size());
		for(int i=0; i<result.size();i++){
			System.out.println(result.get(i));
		}
		return ;
	}


	public static void main(String args[]){
		String s = new String();
		s = "abba";
		String p = new String();
		p = "ab";
		findamagraspos(s,p);

		s = new String("cbaebabacd");
		p = new String("abc");
		findamagraspos(s,p);
	}
}