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
	}

	public CirSinglyList(T[] value) {
		this();
		Node<T> rear = head;
		for (int i = 0; i < value.length; i++) {
			rear.next = new Node<T>(value[i], null);
			rear = rear.next;
		}
		rear.next = this.head;
	}

	public boolean isEmpty() {
		return this.head.next == head;
	}

	// 得到第i个节点
	public T get(int i) {
		Node<T> p = this.head.next;
		for (int j = 0; j < i && p !=this.head; j++) {
			p = p.next;
		}
		return (i >= 0 && p != this.head) ? p.data : null;
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
			for (int i = 0; p.head.next != p.head; i++) {
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
		list.head = front.next;
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

		String values2[] = { "A", "B", "C", "D", "E","F"};
		String values3[] = { "C", "D","E"};

		CirSinglyList<String> test = new CirSinglyList(values2);
		CirSinglyList<String> test1 = new CirSinglyList(values3);
		System.out.println("test:" + test.toString());
		System.out.println("test1:" + test1.toString());
		test.removeAllMatched(test1);
		System.out.println("After removeAllMatched the test:" + test.toString());
	}
}


