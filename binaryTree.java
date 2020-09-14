
import java.io.*;
import java.util.*;

class BSTNode{
	String data;
	BSTNode left;
	BSTNode right;

	BSTNode(String data){
		data = data;
		left = null;
		right = null;
	}
}
class binaryTree{

	public static void postOrder(BSTNode root){
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data + " ");
	}


	public static BSTNode insert(BSTNode root, String nodeName){
		if(root == null){
			return new BSTNode(nodeName);
		}
		else{
			BSTNode curr;
			if(nodeName <= root.data){
				curr = insert(root.left, nodeName);
				root.left = curr;
			}
			else{
				curr = insert(root.right, nodeName);
				root.right = curr;
			}
			return root;
		}

	}

	public static void main(String[] args){
		BSTNode root = null;
		//Scanner scan = new Scanner(System.in);

		//int t = scan.nextInt();
		ArrayList<String> input = new ArrayList<String>();

		input.add("Project-1");
		input.add("a.java");
		input.add("b.java");
		input.add("c.java");
		input.add("a.class");
		input.add("c.class");

		while(input.size()-- > 0){
			String nodeName =  scan.parseString();
			root = insert(root, nodeName);
	
		}

//		scan.close();
		postOrder(root);
	}
	
}