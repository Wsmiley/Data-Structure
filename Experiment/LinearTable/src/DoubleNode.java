/**
 * FileName: DoubleNode
 * Author:   Smiley
 * Date:     2019/3/22 19:23
 * Description:
 * History:
 */

/**
 * 〈双链表类结点类〉<br>
 * 〈〉
 *
 * @author Smiley
 * @create 2019/3/22
 * @since 1.0.0
 */
public class DoubleNode<T> {
	public DoubleNode<T>prev;
	public T data;
	public DoubleNode<T>next;

	public DoubleNode(DoubleNode<T>prev,T data,DoubleNode<T>next){
		this.prev=prev;
		this.data=data;
		this.next=next;
	}

	public DoubleNode(){
		this(null,null,null);
	}

	public DoubleNode(T data){
		this.prev=null;
		this.data=data;
		this.next=null;
	}

	public String toString(){
		return this.data.toString();
	}

	public static void main(String[] args) {

	}
}
 
