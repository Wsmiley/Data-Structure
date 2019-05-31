/**
 * FileName: GenList
 * Author:   Smiley
 * Date:     2019/5/17 16:39
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
public class GenList<T> {
	public GenNode<T>head;

	public GenList(){
		this.head=new GenNode<>();
	}

	public String toString(){
		return this.toString("");
	}

	public String toString(String str){
		str+="(";
		for(GenNode<T>p=this.head.next;p!=null;p=p.next){
			if(p.child==null){
				str+=p.data.toString();
			}else {
				str+=p.child.toString();
			}
			if (p.next!=null){
				str+=",";
			}
		}
		return str+")";
	}


	public static void main(String[] args) {

	}
}
 
