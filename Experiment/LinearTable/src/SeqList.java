/**
 * FileName: SeqList
 * Author:   Smiley
 * Date:     2019/3/21 19:28
 * Description:
 * History:
 */

/**
 * <顺序表></顺序表><br>
 * 〈〉
 *
 * @author Smiley
 * @create 2019/3/21
 * @since 1.0.0
 */
public class SeqList<T>extends Object{
	protected Object[] element;
	protected int n;
	//构造方法
	public SeqList(int length){
		this.element=new Object[length];
		this.n=0;
	}

	public SeqList(){
		this(64);
	}

	public SeqList(T[] value){
		this(value.length);
		for(int i=0;i<value.length;i++){
			this.element[i]=value[i];
		}
		this.n=element.length;
	}

	//判断是否为空的顺序表
	public boolean isEmpty(){
		return this.n==0;
	}

	//顺序表大小
	public int size(){
		return this.n;
	}

	//在顺序表中得到该值
	public T get(int i){
		 if(i>=0&&i<this.n){
		 	return (T)this.element[i];
		 }
		 return null;
	}

	//在顺序表i中设置为x
	public void set(int i,T x){
		if (x==null){
			throw new NullPointerException();
		}
		if (i>0&&i<this.n){
			this.element[i]=x;
		}else {
			throw  new IndexOutOfBoundsException(i+"");
		}
	}


	public String tostring(){
		String str=this.getClass().getName()+"(";
		if (this.n>0){
			str+=this.element[0].toString();
		}
		for(int i=1;i<this.n;i++){
			str+=","+this.element[i].toString();
		}
		return str+")";
	}

	//插入
	public int insert(int i,T x){
		if(x==null){
			throw new NullPointerException();
		}
		if(i<0){
			i=0;
		}
		if(i>this.n){
			i=this.n;
		}
		Object[] source=this.element;//构造新的链表，source引用element
		if(this.n==element.length){//数组满了
			this.element=new Object[source.length*2];//申请出source*2大的表，此时的element不属于原来的element
			for(int j=0;j<i;j++){
				this.element[j]=source[j];//把source引用之前的element赋值给新的element
			}
		}
		for(int j=this.n-1;j>=i;j--){//往后移一位
			this.element[j+1]=source[j];
		}
		this.element[i]=x;
		this.n++;
		return i;
	}

	public int insert(T x){
		return this.insert(this.n,x);//默认放在最后
	}

	//删除
	public T remove(int i){
		if(this.n>0&&i<this.n){
			T old=(T)this.element[i];
			for (int j=i;j<this.n-1;j++){
				this.element[j]=this.element[j+1];
			}
			this.element[this.n-1]=null;
			this.n--;
			return old;
		}
		return null;

	}
	//清除
	public void clear()
	{
		this.n=0;
	}

	//倒序
	public String toPreviouString(){
		String str=this.getClass().getName()+"(";
		if(this.n>0){
			str+=this.element[this.n-1].toString();
		}
		for (int i=1;i<this.n;i++){
			str+=this.element[this.n-i-1].toString();
		}
		return str+")";
	}

	//查找相同的元素，返回在第几位
	public int search(T key){
		for(int i=0;i<this.n;i++){
			if(key.equals(this.element[i])){
				return i;
			}
		}
		return -1;
	}

	//两个顺序表是否相等:元素相等并且长度相等

	public boolean equals(Object obj){
		if (this==obj){
			return true;
		}
		if (obj instanceof SeqList<?>){//<?>是<T>所以父类
			SeqList<T>list=(SeqList<T>)obj;
			if(this.n==list.n){
				for (int i=0;i<this.n;i++){
					if(!(this.get(i).equals(list.get(i)))){
						return false;
					}
				}
			}
		}
		return false;
	}

	//判断是否包含关键字为key元素
	public boolean contains(T key){
		return this.search(key)!=-1;
	}

	//深拷贝
	public SeqList(SeqList<?extends T>list){
		this.n=list.n;
		this.element=new Object[list.element.length];
		for (int i=0;i<list.n;i++){
			this.element[i]=list.element[i];
		}
	}
	public static void main(String[] args) {

		String values[]={"A","B","C","D","E","F"};
		SeqList<String>seqlist=new SeqList<String>(values);
		System.out.println(seqlist.toPreviouString());
		System.out.println(seqlist.isEmpty());
		System.out.println(seqlist.get(3));
		seqlist.insert(3,'H'+"");
		System.out.println(seqlist.get(3));
		System.out.println(seqlist.size());

		SeqList<String>p=new SeqList<String>(seqlist);
		p.insert("I");
		System.out.println("p"+","+p.tostring());

		System.out.println(seqlist.equals(p));
		System.out.println("seqlist"+","+seqlist.tostring());


	}
}
 
