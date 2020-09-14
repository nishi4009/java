import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class postorder {
 public static void postOrder(Node root) {
		if(root == null){
			return;
		}	
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
    }

    public static void preOrder(Node root){

   		 if(root == null){
   		 	return;
   		 }
   		 preOrder(root.left);
   		 System.out.print(root.data + " ");
   		 preOrder(root.right);
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
           // System.out.println("insert is returning: " + root.data);
            return root;
        }
    }

    public static void levelOrder(Node root){
    	if(root == null){
    		return;
    	}



    	Queue<Node> que = new LinkedList<Node>();
    	que.add(root);

    	while(!que.isEmpty()){
    		Node curr = que.peek();
    		System.out.print(curr.data + " ");
    		if(curr.left != null)
    			que.add(curr.left);
    		if(curr.right != null)
    			que.add(curr.right);
    		que.remove(curr);
    	}


    	System.out.println("\nfinal queue: " +que);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       // int t = scan.nextInt();
        Node root = null;
       // while(t-- > 0) {
            int data = 15;
            root = insert(root, data);
            data = 12;
            root = insert(root, 12);
            root = insert(root, 21);
            root = insert(root, 13);
            root = insert(root, 8);
            root = insert(root, 18);
            root = insert(root, 25);
            root = insert(root, 6);
            root = insert(root, 10);
            root = insert(root, 14);
            root = insert(root, 16);
            root = insert(root, 30);
            root = insert(root, 22); 
                 
                 
            
            
        //}
        scan.close();
        System.out.println("PostOrder: ");
        postOrder(root);

        System.out.println("\n\nLevelOrder: ");
     	levelOrder(root);

     	System.out.println("\nPreOrder: ");
     	preOrder(root);
    }	
}