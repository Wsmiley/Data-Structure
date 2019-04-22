/**
 * FileName: SeqQueue
 * Author:   Smiley
 * Date:     2019/4/17 15:50
 * Description: 顺序循环队列
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈顺序循环队列〉
 *
 * @author Smiley
 * @create 2019/4/17
 * @since 1.0.0
 */
public final class SeqQueue<T> implements Queue<T> {

	private Object element[];
	private int front,rear;
	public SeqQueue(int lenght){
		if(lenght<64)
			lenght=64;
		this.element=new Object[lenght];
		this.front=this.rear=0;
	}
	public SeqQueue(){
		this(64);
	}

	public boolean isEmpty(){
		return this.front==this.rear;
	}

	public boolean add(T x){
		if(x==null)
			return false;
		if(this.front==(this.rear+1)%this.element.length){
			Object[]temp=this.element;
			this.element=new Object[temp.length*2];
			int j=0;
			for(int i=this.front;i!=this.rear;i=(i+1)%temp.length)
				this.element[j++]=temp[i];
			this.front=0;
			this.rear=j;
		}
		this.element[this.rear]=x;
		this.rear=(this.rear+1)%this.element.length;
		return true;
	}
	public T peek(){
		return this.isEmpty()?null:(T)this.element[this.front];
	}
	public T poll(){
		if(this.isEmpty())
			return null;
		T temp=(T)this.element[this.front];
		this.front=(this.front+1)%this.element.length;
		return temp;
	}

	public static void main(String[] args) {

	}
}
 
