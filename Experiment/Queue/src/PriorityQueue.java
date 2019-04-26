/**
 * FileName: PriorityQueue
 * Author:   Smiley
 * Date:     2019/4/24 14:14
 * Description: Priority Queue
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈Priority Queue〉
 *
 * @author Smiley
 * @create 2019/4/24
 * @since 1.0.0
 */
public class PriorityQueue<T extends Comparable<?super T>>implements Queue<T> {
	private SortedCirDoublyList<T>list;
	private boolean asc;//升序还是降序

	public PriorityQueue(boolean asc){
		this.list=new SortedCirDoublyList<T>();
		this.asc=asc;
	}

	public PriorityQueue(){
		this(true);
	}

	public boolean isEmpty(){
		return this.list.isEmpty();
	}
	public boolean add(T x){
		return this.list.insert(x)!=null;
	}
	public T peek(){
		return this.asc?this.list.get(0):this.list.head.prev.data;
	}
	public T poll(){
		return this.asc?this.list.remove(0):this.list.remove(Integer.MAX_VALUE);
	}
	public String toString(){
		return this.getClass().getName()+""+(this.asc?this.list.toString():this.list.toPreviousString());
	}

	public static void main(String[] args) {

	}
}
 
