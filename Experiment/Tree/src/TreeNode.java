/**
 * FileName: TreeNode
 * Author:   Smiley
 * Date:     2019/5/31 14:05
 * Description:
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Smiley
 * @create 2019/5/31
 * @since 1.0.0
 */
public class TreeNode<T> {
	public T data;
	public TreeNode<T>parent,child,sibling;
	public int level;

	public TreeNode(T data,int level,TreeNode<T>parent,TreeNode<T>child,TreeNode<T>sibling){
		this.level=level;
		this.data=data;
		this.parent=parent;
		this.child=child;
		this.sibling=sibling;
	}

	public TreeNode(T data,int level){
		this(data,level,null,null,null);
	}

	public String toString(){
		return this.data.toString();
	}

	public boolean isLeft(){
		return this.child==null;
	}
}
 
