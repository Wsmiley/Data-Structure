/**
 * FileName: CirDoublyList
 * Author:   Smiley
 * Date:     2019/3/29 21:23
 * Description: 循环双链表
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈循环双链表〉
 *
 * @author Smiley
 * @create 2019/3/29
 * @since 1.0.0
 */
public class CirDoublyList<T>{
	public DoubleNode<T>head;

	public CirDoublyList(){
		this.head=new DoubleNode<>();
		this.head.next=head;
		this.head.prev=head;
	}

	public CirDoublyList(T[] values){
		this();
		DoubleNode<T>rear=this.head;
		for(int i=0;i<values.length;i++){
			rear.next=new DoubleNode<T>(rear,values[i],null);
			rear=rear.next;
		}
		rear.next=this.head;
		this.head.prev=rear;
	}


	public CirDoublyList(CirDoublyList<T> list)
	{
		this();
		DoubleNode<T> rear = this.head;
		for (DoubleNode<T> p=list.head.next;  p!=list.head;  p=p.next)
		{
			rear.next = new DoubleNode<T>(rear,p.data, this.head);
			rear = rear.next;
		}
		this.head.prev = rear;
	}

	public boolean isEmpty(){
		return this.head.next==this.head;
	}
	public T get(int i){
		DoubleNode<T>p=this.head;
		for(int j=0;p!=this.head&&j<i;j++){
			p=p.next;
		}
		return (i>=0&&p!=head)?p.data:null;
	}

	public DoubleNode<T>insert(int j,T x) {
		if (x == null) {
			throw new NullPointerException("x=null");
		}
		DoubleNode<T> front = this.head;
		for (int i = 0; front.next != this.head && i < j; i++) {
			front = front.next;
		}
		DoubleNode<T> p = new DoubleNode<>(front, x, front.next);
		front.next.prev=p;
		front.next=p;
		return front.next;
	}
	public DoubleNode<T> insert(T x){
		return insert(Integer.MAX_VALUE,x);
	}

	public T remove(int i){
		DoubleNode<T>front=this.head;
		for(int j=0;j<i&&front.next!=this.head;j++){
			front=front.next;
		}
		if(i>0&&front.next!=this.head){
			T old=front.data;
			front.prev.next=front.next;
			front.next.prev=front.prev;
			front.prev=null;;
			front.next=null;
			return old;
		}
		return null;
	}

	public String toString(){
		String str=this.getClass().getName()+"(";
		for(DoubleNode<T>p=this.head.next;p!=this.head;p=p.next){
			str+=p.data.toString();
			if(p.next!=this.head){
				str+=",";
			}
		}
		return str+")";
	}

	public String toPreviousString(){
		DoubleNode<T>p=this.head.prev;
		String str;
		str=getClass().getName()+"(";
		while(p!=this.head){
			str+=p.data.toString();
			p=p.prev;
			if(p!=this.head){
				str+=",";
			}
		}
		return str+")";
	}


	public static void main(String[] args) {
		String values[] = { "A", "B", "C", "D", "F", "G" };
		String values1[] = { "H", "I", "J", "K" };
		CirDoublyList<String>p=new CirDoublyList<>(values);
		System.out.println(p.toString());
		p.insert("I");

		System.out.println(p.remove(2));

		System.out.println(p.toString());
		System.out.println(p.toPreviousString());
	}
}
 
