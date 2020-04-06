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

	public boolean isEmpty(){
		return this.n==0;
	}


	public int size(){
		return this.n;
	}


	public T get(int i){
		 if(i>=0&&i<this.n){
		 	return (T)this.element[i];
		 }
		 return null;
	}


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
		Object[] source=this.element;
		if(this.n==element.length){
			this.element=new Object[source.length*2];
			for(int j=0;j<i;j++){
				this.element[j]=source[j];
			}
		}
		for(int j=this.n-1;j>=i;j--){
			this.element[j+1]=source[j];
		}
		this.element[i]=x;
		this.n++;
		return i;
	}

	public int insert(T x){
		return this.insert(this.n,x);
	}


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

	public void clear()
	{
		this.n=0;
	}


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

	public int search(T key){
		for(int i=0;i<this.n;i++){
			if(key.equals(this.element[i])){
				return i;
			}
		}
		return -1;
	}


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

	public boolean contains(T key){
		return this.search(key)!=-1;
	}


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
 
