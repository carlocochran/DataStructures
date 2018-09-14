public class Queue {
	
	private static final int SIZE = 4;
	private Node[] nodes = new Node[SIZE];
	
	private int headIndex = -1;
	private int tailIndex = -1;
	
	public int currentSize = 0;

	public static final class Node{
		private String key;
		private String value;
		
		public Node(String key, String value){
			this.key = key;
			this.value = value;
		}
		
		public String toString(){
			return "Key: "+ key +", Value "+ value;
		}
	}
	
	public void enqueue(Node n) throws Exception{		
		if (isQueueFull()){
			throw new Exception("Queue overflow!");
		}
		
		if (headIndex == -1 && tailIndex == -1){
			headIndex = 0;
			tailIndex = 0;
		}
		
		nodes[tailIndex] = n;
		tailIndex = (tailIndex + 1) % SIZE;
		currentSize++;		
	}
	
	public Node dequeue() throws Exception {
		if (isQueueEmpty()){
			throw new Exception("Queue underflow!");
		}
		
		Node node = nodes[headIndex];
		nodes[headIndex] = null;
		headIndex = (headIndex + 1) % SIZE;
		if (headIndex == tailIndex){
			headIndex = 0;
			tailIndex = 0;			
		}
		
		currentSize--;		
		return node;
	}
	
	public boolean isQueueFull(){
		return currentSize == SIZE;
	}
	
	public boolean isQueueEmpty(){
		return currentSize == 0;
	}
	
	public static void main (String[] args) throws Exception{
		Queue q = new Queue();
		q.enqueue(new Node("a", "b"));
		q.enqueue(new Node("d", "e"));
		q.enqueue(new Node("f", "e"));		
		q.enqueue(new Node("h", "e"));
		System.out.println(q.dequeue());
		q.enqueue(new Node("h1", "e"));
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(new Node("g", "e"));
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}