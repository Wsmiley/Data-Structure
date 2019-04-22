/**
 * FileName: SinglyList
 * Author:   Smiley
 * Date:     2019/3/22 12:54
 * Description: 单链表
 * History:
 */

/**
 * 〈一句话功能简述〉<br>
 * 〈单链表〉
 *
 * @author Smiley
 * @create 2019/3/22
 * @since 1.0.0
 */
public class SinglyList<T> {
	public Node<T> head;

	public SinglyList() {
		this.head = new Node<T>();
	}

	public SinglyList(T[] value) {
		this();
		Node<T> rear = this.head;
		for (int i = 0; i < value.length; i++) {
			rear.next = new Node<T>(value[i], null);
			rear = rear.next;
		}
	}

	// 是否为空
	public boolean isEmpty() {
		return this.head.next == null;
	}

	// 第几个结点
	public T get(int i) {
		Node<T> p = this.head.next;
		for (int j = 0; p != null && j < i; j++) {
			p = p.next;
		}
		return (i >= 0 && p != null) ? p.data : null;
	}

	public String toString() {
		String str = this.getClass().getName() + "(";
		for (Node<T> p = this.head.next; p != null; p = p.next) {
			str += p.data.toString();
			if (p.next != null) {
				str += ",";
			}
		}
		return str + ")";
	}



	// 插入
	public Node<T> insert(int i, T x) {
		if (x == null) {
			throw new NullPointerException("x==null");
		}
		Node<T> front = this.head;
		for (int j = 0; front.next != null && j < i; j++) {
			front = front.next;
		}
		front.next = new Node<T>(x, front.next);
		return front.next;
	}

	// 最后插入
	public Node<T> insert(T x) {
		return insert(Integer.MAX_VALUE, x);
	}

	public T remove(int i) {
		Node<T> front = this.head;
		for (int j = 0; front.next != null && j < i; j++) {
			front = front.next;
		}
		if (i >= 0 && front.next != null) {
			T old = front.next.data;
			front.next = front.next.next;
			return old;
		}
		return null;
	}

	// 链表逆转
	public void reverse(SinglyList<T> list) {
		Node<T> front = null;
		Node<T> p = list.head.next;
		Node<T> succ = null;
		while (p != null) {
			succ = p.next;
			p.next = front;
			front = p;
			p = succ;
		}
		list.head.next = front;
	}

	public int size() {
		int i = 0;
		if (this.isEmpty()) {
			return 0;
		}
		for (Node<T> p = this.head.next; p != null; i++) {
			p = p.next;
		}
		return i;

	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof SinglyList<?>) {
			SinglyList<T> list = (SinglyList<T>) obj;
			for (int i = 0; list.head.next != null; i++) {
				if (!(this.get(i).equals(list.get(i)))) {
					return false;
				}
				list.head = list.head.next;
			}
			return true;
		}
		return false;
	}

	public static <T>boolean isDifferent(SinglyList<T>list){
		if(list.isEmpty()){
			throw new NullPointerException("list==null");
		}
		Node<T>p=list.head.next;
		while (p.next!=null){
			if(p.data==p.next.data){
				return false;
			}
			p=p.next;
		}
		return true;
	}

	public void clear() {
		this.head.next = null;
	}

	public Node<T> search(T key) {
		return null;
	}

	public boolean contains(T key) {
		return false;
	}

	public T remove(T key) {
		return null;
	}

	public static void main(String[] args) {
		String values[] = { "A", "B", "C", "D", "E", "F" };
		String values1[] = { "A", "B", "B", "D", "E", "F" };
		SinglyList<String> p = new SinglyList<String>(values);
		System.out.println(p.toString());
		System.out.println(p.size());
		p.reverse(p);
		System.out.println(p.toString());
		p.insert(11,"G");
		System.out.println(p.toString());
		p.remove(6);
		System.out.println(p.toString());
		p.reverse(p);
		System.out.println(p.toString());

		SinglyList<String>q=new SinglyList<String>(values1);
		System.out.println(SinglyList.isDifferent(q));
		System.out.println(SinglyList.isDifferent(p));
	}
}
