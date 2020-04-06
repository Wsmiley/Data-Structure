/**
 * FileName: Tree
 * Author:   Smiley
 * Date:     2019/5/31 14:03
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
public class Tree<T> {

	public TreeNode<T>root;
	public Tree(){
		this.root=null;
	}

	public Tree(String prelist){
	}

	public String toString(){
		return "树的横向凹入表示: \n"+toString(root,"");
	}

	public String toString(TreeNode<T>p,String tab){
		if(p==null){
			return "";
		}
		return tab+p.data.toString()+"\n"+toString(p.child,tab+"\t")+toString(p.sibling,tab);
	}
	public static void main(String[] args) {

	}
}
 
