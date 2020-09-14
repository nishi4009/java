/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
if(head == null) return false;

Node first = head;
Node second = head.next;
while(second != null && second.next != null){
	if(first == second)
		return true;
	first = first.next;
	second = second.next.next; 
}
return false;

}