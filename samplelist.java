import java.io.*;
import java.util.*;
import java.math.*;

public class samplelist{
	static class SinglyLinkedNode{
		public int data;
		public SinglyLinkedNode next;

		public SinglyLinkedNode(int nodedata){
			this.data = nodedata;
			this.next = null;
		}
	}

	static class SinglyLinkedList{
		public SinglyLinkedList head;
		public SinglyLinkedList tail;

		public SinglyLinkedList(){
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodedata){
			SinglyLinkedNode node = new SinglyLinkedNode(nodedata);

			if(this.head == null){
				this.head = node;
			}
			else
				this.tail.next = node;
			this.tail = node;
		}
	}

	public static SinglyLinkedNode insertNodeAtPosition(SinglyLinkedNode head, int data, int pos){

		System.out.println(String.valueOf(head.data));
		return head;
	}

	public static void printSinglyLinkedList(SinglyLinkedNode node, String sep, BufferedWriter bufferedWriter) throws IOException{
		while(node!= null){
			bufferedWriter.write(String.valueOf(node.data));

			System.out.print(String.valueOf(node.data));

			node = node.next;
			if(node!=null){
				bufferedWriter.write(sep);
				System.out.print(sep);
			}
		}
	}

	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));
		SinglyLinkedList list = new SinglyLinkedList();

		int listCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for(int i=0; i<listCount; i++){
			int listItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			list.insertNode(listItem);			
		}

		int data = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int position = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		SinglyLinkedNode list_head = insertNodeAtPosition(list.head, data, poistion);

		printSinglyLinkedList(list_head, " ", bufferedWriter);

		bufferedWriter.newLine();
		bufferedWriter.close();

		scanner.close();		
	}	
}
