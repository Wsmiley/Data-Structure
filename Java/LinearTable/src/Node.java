/**
 * FileName: Node
 * Author:   Smiley
 * Date:     2019/3/21 20:30
 * Description:
 * History:
 */

/**
 * 〈结点〉<br>
 * 〈〉
 *
 * @author Smiley
 * @create 2019/3/21
 * @since 1.0.0
 */

public class Node<T> {

	public T data;
	public Node<T>next;//自引用的类：它的成员变量next的数据类型是Node<T>类自己。自引用的类指一个类声明包含有引用当前类实例的成员变量。

	public Node(T data,Node<T>next){
		this.data=data;
		this.next=next;
	}

	public Node(){
		this(null,null);
	}

	public String toString(){
		return this.data.toString();
	}

}
 
