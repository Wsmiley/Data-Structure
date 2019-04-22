/**
 * FileName: LinkedStack
 * Author:   Smiley
 * Date:     2019/4/17 15:42
 * Description: LinkedStack
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈LinkedStack〉
 *
 * @author Smiley
 * @create 2019/4/17
 * @since 1.0.0
 */
public class LinkedStack<T> implements Stack<T>{

	private SinglyList<T>list;
	public LinkedStack(){
		this.list=new SinglyList<T>();
	}
	public boolean isEmpty(){
		return this.list.isEmpty();
	}
	public void push(T x){
		this.list.insert(0,x);
	}
	public T peek(){
		return this.list.get(0);
	}
	public T pop(){
		return this.list.remove(0);
	}

	public static void main(String[] args) {

	}
}
 
