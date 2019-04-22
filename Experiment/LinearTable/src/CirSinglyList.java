/**
 * FileName: CirSinglyList
 * Author:   Smiley
 * Date:     2019/3/21 20:58
 * Description: 循环单链表
 * History:
 */

/**
 * 〈一句话功能简述〉<br>
 * 〈循环单链表〉
 *
 * @author Smiley
 * @create 2019/3/21
 * @since 1.0.0
 */

public class CirSinglyList<T> extends SinglyList<T> {

	public CirSinglyList() {
		this.head = new Node<T>();
		this.head.next = this.head;
		this.tail = null;
	}

	public CirSinglyList(T[] value) {
		this();
		Node<T> rear = head;
		for (int i = 0; i < value.length; i++) {
			rear.next = new Node<T>(value[i], null);
			rear = rear.next;
		}
		this.tail = rear;
		rear.next = this.head;
	}

	public boolean isEmpty() {
		return this.head.next == head;
	}

	// 得到第i个节点
	public T get(int i) {
		Node<T> p = this.head.next;
		for (int j = 0; j < i && p != this.tail.next; j++) {
			p = p.next;
		}
		return (i >= 0 && p != this.tail.next) ? p.data : null;
	}

	// 深拷贝

	public CirSinglyList(CirSinglyList<T> list) {
		this();
		Node<T> rear = this.head;
		Node<T> p = list.head.next;
		while (p != list.head) {
			rear.next = new Node<T>(p.data, null);
			rear = rear.next;
			p = p.next;
		}
		this.tail = rear;
		rear.next = this.head;
	}

	public CirSinglyList(SinglyList<T> list) {
		this();
		Node<T> rear = this.head;

		Node<T> p = list.head.next;
		while (p != null) {
			rear.next = new Node<T>(p.data, null);
			rear = rear.next;
			p = p.next;
		}
		this.tail = rear;
		rear.next = head;
	}

	// //判断是否同一个值
	// public boolean equals(Object obj){
	//
	// if (this==obj){
	// return true;
	// }
	//
	// if (obj instanceof CirSinglyList<?>){//所有CirSinglyList的父类
	// CirSinglyList<T>list=(CirSinglyList<T>)obj;
	// for(int i=0;list.head.next!=list.tail.next;i++){
	// if(!(this.get(i).equals(list.get(i)))){
	// return false;
	// }
	// return true;
	// }
	// }
	// return false;
	// }

	public boolean equals(SinglyList<T> list) {
		if (this == list) {
			return true;
		}
		if (list instanceof CirSinglyList<?>) {// 所有CirSinglyList的父类
			CirSinglyList<T> p = (CirSinglyList<T>) list;
			for (int i = 0; p.head.next != p.tail.next; i++) {
				if (!(this.get(i).equals(p.get(i)))) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	// 最后插入
	public Node<T> insert(T x) {
		return insert(Integer.MAX_VALUE, x);
	}

	// 长度
	public int size() {
		int n = 0;
		Node<T> p = this.head;
		while (p.next != head) {
			n++;
			p = p.next;
		}
		return n;
	}

	public boolean addAll(int i, CirSinglyList<T> list) {
		if (list == null) {
			return false;
		}
		Node<T> front = this.head;
		for (int j = 0; j < i - 1 && front.next != this.head; j++) {
			front = front.next;
		}
		list.tail.next = front.next;
		front.next = list.head.next;
		list.head.next = list.head;

		return true;
	}

	public boolean addAll(CirSinglyList<T> list) {
		return addAll(Integer.MAX_VALUE, list);
	}

	// 插入
	public Node<T> insert(int i, T x) {
		if (x == null) {
			throw new NullPointerException("x==null");
		}
		Node<T> front = this.head;
		for (int j = 0; front.next != this.head && j < i; j++) {
			front = front.next;
		}
		Node<T> p = new Node<T>(x, front.next);
		front.next = p;
		return p;
	}

	public String toString() {
		String str = this.getClass().getName() + "(";
		for (Node<T> p = this.head.next; p != head; p = p.next) {
			str += p.data.toString();
			if (p.next != head) {
				str += ",";
			}
		}
		return str + ")";
	}

	public T remove(int i) {
		Node<T> front = this.head;
		for (int j = 0; front.next != this.head && j < i; j++) {
			front = front.next;
		}
		if (i >= 0 && front.next != head) {
			T old = front.next.data;
			front.next = front.next.next;
			if (front.next != this.head) {
				this.tail = front.next;
			} else {
				this.tail = front;
			}
			System.out.println(this.tail.data);
			return old;
		}
		return null;
	}


	//匹配
	public void removeAllMatched(CirSinglyList<T> pattern) {
		if (pattern.isEmpty()) {
			return;
		}
		Node<T> start = this.head;
		while (start.next!=this.head) {
			Node<T> p = start.next;
			Node<T> q = pattern.head.next;
			while(p != this.head && q != pattern.head&&p.data.equals(q.data)){
				p = p.next;
				q = q.next;
			}
			if (q != pattern.head) {
				start = start.next;
			} else {

				start.next= p;
			}
		}
	}



//	public void removeAllMatched(CirSinglyList<T> pattern) {
//		if (pattern.isEmpty()) {
//			return;
//		}
//		Node<T> start = this.head.next;
//		do {
//			Node<T> p = start;
//			Node<T> q = pattern.head.next;
//			while (p != this.head && q != pattern.head && p.data.equals(q.data)) {
//				p = p.next;
//				q = q.next;
//			}
//			if (q != pattern.head) {
//				start = start.next;
//			} else {
//				start=p;
//				start.next= p;
//
//			}
//		}while (start!=this.head);
//	}


	public boolean containsAll(CirSinglyList<T>list){
		Node<T>start=this.head.next;
		while(start!=head){
			Node<T>p=start;
			Node<T>q=list.head.next;
			while (p!=this.head&&q!=list.head&&p.data.equals(q.data)){
				p=p.next;
				q=q.next;
			}
			if(q!=list.head){
				start=start.next;
			}else {
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		String values[] = { "A", "B", "C", "D", "F", "G" };
		String values1[] = { "H", "I", "J", "K" };
////
//		CirSinglyList<String> p = new CirSinglyList<String>(values);
//		System.out.println(p.toString());
//		CirSinglyList<String> q = new CirSinglyList<String>(p);
//		System.out.println(p.toString());
//		q.insert("H");
//		System.out.println(q.toString());
//		CirSinglyList<String> f = new CirSinglyList<String>(values1);
//		SinglyList<String> a = new SinglyList<String>(values1);
//		System.out.println(a.toString());
//		q.print();
//		CirSinglyList<String> b = new CirSinglyList<String>(a);
//		a.insert("L");
//		System.out.println(b.toString());
//		System.out.println(a.toString());
//
//		CirSinglyList<String> c = p;
//		System.out.println(c.equals(p));
//
//		SinglyList<String> e = new CirSinglyList<String>(values);
//		System.out.println(e.toString());
//		CirSinglyList<String> d = new CirSinglyList<String>(values);// 换e不行
//		System.out.println("d" + d.toString());
//		System.out.println(d.equals(e));
//		q.print();
//		System.out.println("");
//		q.addAll(f);
//		q.print();
//		System.out.println("");
//		q.remove(10);
//		q.print();
//		System.out.println();

		String values2[] = { "A", "B", "C", "D", "E","F"};
		String values3[] = { "C", "D","E"};
//		String values2[] = { "A", "A", "A", "A" };
//		String values3[] = { "A","A"};
		CirSinglyList<String> test = new CirSinglyList(values2);
		CirSinglyList<String> test1 = new CirSinglyList(values3);
		//System.out.println(test.containsAll(test1));
		System.out.println("test:" + test.toString());
		System.out.println("test1:" + test1.toString());
		test.removeAllMatched(test1);
		System.out.println("test:" + test.toString());
	}
}


