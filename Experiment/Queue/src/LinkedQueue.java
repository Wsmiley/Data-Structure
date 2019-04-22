/**
 * FileName: LinkedQueue
 * Author:   Smiley
 * Date:     2019/4/17 15:59
 * Description: LinkedQueue
 * History:
 */


/**
 * 〈一句话功能简述〉<br> 
 * 〈LinkedQueue〉
 *
 * @author Smiley
 * @create 2019/4/17
 * @since 1.0.0
 */

public final class LinkedQueue<T> implements Queue<T> {

	private Node<T>front,rear;

	public LinkedQueue(){
		this.front=this.rear=null;
	}
	public boolean isEmpty(){
		return this.front==null||this.rear==null;
	}
	public boolean add(T x){
		if(x==null)
			return false;
		Node<T>p=new Node<T>(x,null);
		if(this.front==null)
			this.front=p;
		else
			this.rear.next=p;
		this.rear=p;
		return true;
	}
	public T peek(){
		return this.isEmpty()?null:this.front.data;
	}
	public T poll(){
		if(isEmpty())
			return null;
		T x=this.front.data;
		this.front=this.front.next;
		if(this.front==null)
			this.rear=null;
		return x;
	}

	public static void main(String[] args) {

	}
}
 
