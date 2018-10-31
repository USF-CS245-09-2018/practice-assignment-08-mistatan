import java.lang.IllegalStateException;

public class LinkedList implements List{
	private int size = 0;
	private Node head;

	public class Node{
		private Object data;
		private Node next;
	}

	public Object remove(int pos) throws IllegalAccessException{
		if(pos < 0 || pos > size){
			throw new IllegalAccessException("Nothing there to remove");
		}
		if(pos == 0){
			Node node = head;
			head = head.next;
			--size;
			return node.data;
		}
		Node previous = find(pos-1);
		Node temp = previous.next;
		previous.next = temp.next;

		--size;
		return temp.data;
	}
	public void add(int pos, Object data) throws IllegalAccessException{
		if(pos < 0 || pos > size){
			throw new IllegalAccessException("Can't add there");
		}
		Node node = new Node();
		node.data = data;

		if(pos == 0){
			node.next = head;
			head = node; 
		}
		Node previous = find(pos-1);
		node.next = previous.next;
		previous.next = node;

		++size;
	}
	public void add(Object data){
		Node node = new Node();
		node.data = data;
		
		if(size == 0){
			head = node;
		}
		Node previous = find(size-1);
		previous.next = node;
		++size;
	}
	public Object get(int pos) throws IllegalAccessException{
		if(pos < 0 || pos > size){
			throw new IllegalAccessException("Nothing there");
		}
		Node node = head;
		for(int i = 0; i < pos; i++){
			node = node.next;
		}return node.data;
	}
	private Node find(int pos){
		Node node = head;
		for(int i = 0; i < pos; i++){
			node = node.next;
		}
		return node;
	}

	public int size(){
		return size;
	}
}