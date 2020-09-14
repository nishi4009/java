import java.io.*;
import java.util.*;

class Node{
	int data;
	Node left;
	Node right;

	Node(int data){
	this.data = data;
	left = null;
	right = null;
	}

}


class treeheight{

	public static int height(Node root){

		if(root == null) return 0;
		if(root.left == null && root.right == null) return 0;
		else if(root.left != null && root.right == null){
			return 1 + height(root.left);
		}
		else if(root.left == null && root.right != null){
			return 1 + height(root.right);
		}
		else{
			return 1 + Math.max(height(root.left), height(root.right));
		}

	}

	public static Node insert(Node root, int data){
		if(root == null){
			return new Node(data);
		}
		else{
			Node curr;
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

		Node root = null;

		while(t-- > 0){
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();

		int height = height(root);
		System.out.println(height);
	}
}

