public class Stack{
	
	private static final int SIZE = 5;
	
	private int currentSize = 0;
	
	private Node[] nodes = new Node[SIZE];
	
	public static final class Entry<T>{
		private T entry;
		
		public Entry(T t){
			this.entry = t;
		}
		
		public T getValue(){
			return entry;
		}
	}
	
	public static final class Node{
		private Entry entry;
		
		public Node(Integer n){
			entry = new Entry<Integer>(n);
		}
		
		public Entry getEntry(){
			return entry;
		}
	}
	
	public int getSize(){
		return currentSize;
	}
	
	public void push(int n) throws Exception{
		if (currentSize == SIZE){
			throw new Exception("Stack Overflow");
		}		
		
		nodes[currentSize] = new Node(n);
		currentSize++;
	}
	
	public Integer pop() throws Exception {
		if (currentSize == 0){
			throw new Exception("Stack Underflow");
		}
		
		Node node = nodes[currentSize-1];
		nodes[currentSize-1] = null;
		currentSize--;		
		return (Integer)node.getEntry().getValue();
	}
	
	public Integer peek() throws Exception {
		return (Integer)nodes[currentSize-1].getEntry().getValue();
	}
	
	public static void main(String[] args) throws Exception{
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);		
		s.push(11);
		s.push(21);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());		
	}
}