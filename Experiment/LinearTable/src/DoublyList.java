/**
 * FileName: DoublyList
 * Author:   Smiley
 * Date:     2019/3/26 19:29
 * Description: 双链表
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈双链表〉
 *
 * @author Smiley
 * @create 2019/3/26
 * @since 1.0.0
 */
public class DoublyList<T> {
	public DoubleNode<T>head;

	public DoublyList(){
		this.head=new DoubleNode<T>();
	}

	public DoublyList(T[]values){
		this();
		DoubleNode<T>rear=this.head;
		for(int i=0;i<values.length;i++){
			rear.next=new DoubleNode<T>(rear,values[i],null);
			rear=rear.next;
		}
	}
	public DoublyList(DoublyList<T>list){
		this();
		DoubleNode<T>rear=this.head;
		DoubleNode<T>p=list.head.next;
		while(p!=null){
			rear.next=new DoubleNode(rear,p.data,null);
			rear=rear.next;
			p=p.next;
		}
	}

	public boolean isEmpty(){
		return this.head.next==null;
	}

	public T get(int i){
		DoubleNode<T>p=this.head.next;
		for (int j=0;p!=null&&j<i;j++){
			p=p.next;
		}
		return (i>0&&p!=null)?p.data:null;
	}

	public String toString(){
		String str=this.getClass().getName()+"(";
		for(DoubleNode<T>p=this.head.next;p!=null;p=p.next){
			str+=p.data.toString();
			if(p.next!=null){
				str+=",";
			}
		}
		return str+")";
	}

	//之后插入
	public DoubleNode<T>insert(int i,T x){
		if(x==null){
			throw new NullPointerException("x==null");
		}
		DoubleNode<T>front=this.head;
		for(int j=0;front.next!=null&&j<i;j++){
		 	front=front.next;
		}
		DoubleNode<T>p=new DoubleNode<T>(front,x,front.next);
		if(front.next==null){
			front.next=p;
		}else {
			front.next.prev = p;
			front.next = p;
		}
		return front;
	}

	public DoubleNode<T>insert(T x){
		return insert(Integer.MAX_VALUE,x);
	}


	public T remove(int i){
		DoubleNode<T>front=this.head.next;
		for(int j=0;front.next!=null&&j<i;j++){
			front=front.next;
		}
		if(i>=0&&front.next!=null){
			T old=front.data;
			front.prev.next=front.next;
			front.next.prev=front.prev;
			front.prev=null;
			front.next=null;
			return old;
		}
		if(front.next==null){
			T old=front.data;
			front.prev.next=null;
			front.prev=null;
			return old;
		}
		return null;
	}

	public String toPreviousString(){
		String str;
		str=getClass().getName()+"(";
		DoubleNode<T>p=this.head.next;
		while (p.next!=null) {
			p = p.next;
		}
		while(p!=this.head) {
			str += p.data.toString();
			p = p.prev;
			if(p.prev!=null)
				str += ",";

		}
		return str+")";
	}


	public void removeAllMatched(DoublyList<T>pattern){
		if (pattern.isEmpty()){
			return;
		}
		DoubleNode<T>start=this.head;
		while(start!=null){
			DoubleNode<T>p=start.next;
			DoubleNode<T>q=pattern.head.next;
			while(p!=null&&q!=null&&p.data.equals(q.data)){
				p=p.next;
				q=q.next;
			}
			if(q!=null){
				start=start.next;
			}else {
				start.next.prev=null;
				start.next=p;
				p.prev.next=null;
				p.prev=start;
			}
		}
	}

	public static void main(String[] args) {
		String values[] = { "A", "B", "C", "D", "E", "F" };
		String values1[] = { "C", "D","E"};
		DoublyList<String>p=new DoublyList(values);
		System.out.println("p:"+p.toString());
		DoublyList<String>q=new DoublyList(values1);
		System.out.println("q:"+q.toString());

		System.out.println("p:"+p.toString());
//		p.insert(4,"H");
		System.out.println("p:"+p.toString());
//		System.out.println(p.remove(3));

		p.removeAllMatched(q);
		System.out.println("p:"+p.toPreviousString());

	}
}
 
