import java.io.*;
import java.util.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){ data = x;}
}


class largevalue{

public static List<Integer> largestval(TreeNode root){
	List<Integer> largest_vals = new ArrayList();
	helpermethod(root, largest_vals, 0);
	return largest_vals;
}

public static void helpermethod(TreeNode root, List<Integer> largest_vals, int level){
	if(root == null) return;
	if(level == largest_vals.size()){
		largest_vals.add(root.data);
	}
	else{
		largest_vals.set(level, Math.max(largest_vals.get(level), root.data));
	}
	helpermethod(root.left, largest_vals, level++);
	helpermethod(root.right, largest_vals, level++);
}

public static TreeNode insert(TreeNode root, int data){
	if(root == null) {
		return new TreeNode(data);
	}
	else{
		TreeNode curr;
		if(data <= root.data){
			curr = insert(root.left, data);
			root.left = curr;
		}
		else{
			curr = insert(root.right, data);
			root.right = curr;
		}
		return root;
	}
	}

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		TreeNode root = null;
		while (t-- > 0){
			int data = scan.nextInt();
			root = insert(root, data);
		}
		List<Integer> largest_vals = new ArrayList<Integer>();
		largest_vals = largestval(root);
		if(largest_vals.size() > 0){
			for(int i= 0; i<largest_vals.size(); i++){
				System.out.println(largest_vals.get(i));
			}
		}
		scan.close();


	}
}