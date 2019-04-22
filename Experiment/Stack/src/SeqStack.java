/**
 * FileName: SeqStack
 * Author:   Smiley
 * Date:     2019/4/17 15:02
 * Description: stacktest
 * History:
 */


/**
 * 〈一句话功能简述〉<br> 
 * 〈stacktest〉
 *
 * @author Smiley
 * @create 2019/4/17
 * @since 1.0.0
 */
public final class SeqStack<T> implements Stack<T>{
	private SeqList<T>list;

	public SeqStack(int length){
		this.list=new SeqList<T>(length);
	}
	public SeqStack(){
		this(64);
	}
	public boolean isEmpty(){
		return this.list.isEmpty();
	}
	public void push(T x){
		this.list.insert(x);
	}
	public T peek(){
		return this.list.get(list.size()-1);
	}
	public T pop(){
		return list.remove(list.size()-1);
	}

	public static void main(String[] args) {

	}
}
 
