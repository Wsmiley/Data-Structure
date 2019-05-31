/**
 * FileName: GenNode
 * Author:   Smiley
 * Date:     2019/5/17 16:22
 * Description:
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Smiley
 * @create 2019/5/17
 * @since 1.0.0
 */
public class GenNode<T> {

	public T data;
	public GenNode<T>child;
	public GenNode<T>next;

	public GenNode(T data,GenNode<T>child,GenNode<T>next){
		this();
		this.data=data;
		this.child=child;
		this.next=next;
	}

	public GenNode(T data){
		this();
		this.data=data;
	}

	public GenNode(){
		this.data=null;
		this.child=null;
		this.next=null;
	}

	public String toString(){
		return this.data.toString();
	}

}
 
