/**
 * FileName: TriTNode
 * Author:   Smiley
 * Date:     2019/6/11 18:53
 * Description: 三叉链表
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈三叉链表〉
 *
 * @author Smiley
 * @create 2019/6/11
 * @since 1.0.0
 */
public class TriTNode<T> {
	public T data;
	public TriTNode<T>parent,leftchild,rightchild;

	public TriTNode(T data,TriTNode<T>leftchild,TriTNode<T>parent,TriTNode<T>rightchild){
		this.data=data;
		this.leftchild=leftchild;
		this.parent=parent;
		this.rightchild=rightchild;
	}

	public TriTNode(T data){
		this(data,null,null,null);
	}
	public String toString(){
		return this.data.toString();
	}
	public boolean isLeaves(){
		return this.leftchild==null&&this.rightchild==null;
	}
}
 
