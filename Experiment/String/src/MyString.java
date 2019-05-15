/**
 * FileName: MyString
 * Author:   Smiley
 * Date:     2019/5/15 14:08
 * Description: Finall String
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈Final String〉
 *
 * @author Smiley
 * @create 2019/5/15
 * @since 1.0.0
 */
public final class MyString implements Comparable<MyString>,java.io.Serializable{

	private final char[] value;

	public MyString(){
		this.value=new char[0];
	}

	public MyString(java.lang.String str){
		this.value=new char[str.length()];
		for(int i=0;i<str.length();i++){
			this.value[i]=str.charAt(i);
		}
	}

	public MyString(char[]value,int i,int n){
		if(i>=0&&i+n<=value.length){
			this.value=new char[n];
			for(int j=0;j<n;j++){
				this.value[j]=value[i+j];
			}
		}else {
			throw new StringIndexOutOfBoundsException("i="+i+",n="+n+",i+n="+(i+n));
		}
	}

	public MyString(char[]value){
		this(value,0,value.length);
	}

	public MyString(MyString str){
		this(str.value);
	}

	public int length(){
		return this.value.length;
	}

	public java.lang.String toString(){
		return new String(this.value);
	}

	public char charAt(int i){
		if(i>=0&&i<this.value.length){
			return this.value[i];
		}
		throw new StringIndexOutOfBoundsException(i);
	}

	public MyString substring(int begin,int end){
		if(begin==0&&end==this.value.length){
			return this;
		}
		return new MyString(this.value,begin,end-begin);
	}

	public MyString substring(int begin){
		return substring(begin,this.value.length);
	}

	public MyString concat(MyString str){
		if(str==null){
			str=new MyString("null");
		}
		char[]buffer=new char[this.value.length+str.length()];
		int i;
		for(i=0;i<this.value.length;i++){
			buffer[i]=value[i];
		}
		for(int j=0;j<str.length();j++){
			buffer[i+j]=str.charAt(j);
		}
		return new MyString(buffer);
	}

	public int compareTo(MyString str){
		for(int i=0;i<this.value.length&&i<str.value.length;i++){
			if(this.value[i]!=str.value[i]) {
				return this.value[i] - str.value[i];
			}
		}
		return this.value.length-str.value.length;
	}

	public MyString trim(){
		int n=0;
		char[]buffer=new char[this.value.length];
		for(int i=0;i<this.value.length;i++){
			if(this.value[i]!=' '){
				buffer[n++]=this.value[i];
			}
		}
		return new MyString(buffer,0,n);
	}



	public static void main(String[] args) {
			String value="abc defgh i j k lmn";
			MyString p=new MyString(value);
			System.out.println(p.trim());
	}
}
 
