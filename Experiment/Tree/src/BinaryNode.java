/**
 * FileName: BinaryNode
 * Author:   Smiley
 * Date:     2019/4/23 18:51
 * Description: Binary tree node class
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈Binary tree node class〉
 *
 * @author Smiley
 * @create 2019/4/23
 * @since 1.0.0
 */
public class BinaryNode<T> {
	public T data;
	public BinaryNode<T>left,right;
	public BinaryNode(T data,BinaryNode<T>left,BinaryNode<T>right){
		this.data=data;
		this.left=left;
		this.right=right;
	}
	public BinaryNode(T data){
		this(data,null,null);
	}
	public String toString(){
		return this.data.toString();
	}
	//判断是否叶子节点
	public boolean isLeft(){
		return this.left==null&&this.right==null;
	}

}
 
