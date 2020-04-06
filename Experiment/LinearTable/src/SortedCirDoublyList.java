/**
 * FileName: SortedCirDoublyList
 * Author:   Smiley
 * Date:     2019/4/24 14:22
 * Description: 排序循环双链表
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈排序循环双链表〉
 *
 * @author Smiley
 * @create 2019/4/24
 * @since 1.0.0
 */
public class SortedCirDoublyList<T extends Comparable<? super T>>extends CirDoublyList<T>{

	public SortedCirDoublyList(){
		super();
	}

	public SortedCirDoublyList(SortedCirDoublyList<T> list)
	{
		super(list);
	}
	public SortedCirDoublyList(CirDoublyList<T> list)
	{
		super();
		for (DoubleNode<T> p=list.head.next;  p!=list.head;  p=p.next)
			this.insert(p.data);
	}

	public DoubleNode<T>insert(T x){
		if(this.isEmpty()||x.compareTo(this.head.prev.data)>0){
			return super.insert(x);
		}
		DoubleNode<T>p=this.head.next;
		while(p!=head&&x.compareTo(p.data)>0){
			p=p.next;
		}
		DoubleNode<T>q=new DoubleNode<T>(p.prev,x,p);
		p.prev.next=q;
		p.prev=q;
		return q;
	}

}
 
