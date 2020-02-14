
public class ReverseLL {//reverse a singly linked list with char
	
	public static Node reverse(Node head) {
		
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		if(curr.next == null) {
			return head;
		}
		
		else {
			while(curr != null) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				
			}
		}
		
		return prev;
	}

}


