/**
 * FileName: MyStrigBuffer
 * Author:   Smiley
 * Date:     2019/5/15 14:52
 * Description: java.lang.StringBuffer
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈java.lang.StringBuffer〉
 *
 * @author Smiley
 * @create 2019/5/15
 * @since 1.0.0
 */
public final class MyStrigBuffer implements java.io.Serializable {
	private char[] value;
	private int n;

	public MyStrigBuffer(int capacity) {
		this.value = new char[capacity];
		this.n = 0;
	}

	public MyStrigBuffer() {
		this(16);
	}

	public MyStrigBuffer(String str) {
		this(str.length() + 16);
		this.n = str.length();
		for (int i = 0; i < this.n; i++) {
			this.value[i] = str.charAt(i);
		}
	}

	public int length() {
		return this.n;
	}

	public int capacity() {
		return this.value.length;
	}

	public synchronized String toString() {
		return new String(this.value, 0, this.n);
	}

	public synchronized char charAt(int i) {
		if (i < 0 || i > this.value.length) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		return this.value[i];
	}

	public void setCharAt(int i, char ch) {
		if (i < 0 || i > this.value.length) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		this.value[i] = ch;
	}

	public synchronized MyStrigBuffer insert(int i, String str) {
		if (this.n == 0 && i == 0 || this.n > 0 && i >= 0 && i <= this.n) {
			if (str == null) {
				str = "null";
			}
			char[] temp = this.value;
			if (this.value.length < this.n + str.length()) {
				this.value = new char[(this.value.length + str.length() * 2)];
				for (int j = 0; j < i; i++) {
					this.value[j] = temp[j];
				}
			}
				for (int j = this.n - 1; j >= i; j--) {
					this.value[j + str.length()] = temp[j];
				}
				for (int j = 0; j < str.length(); j++) {
					this.value[i + j] = str.charAt(j);
				}
				this.n += str.length();
				return this;
			}
		else throw new StringIndexOutOfBoundsException("i=" + i);
	}

	public synchronized MyStrigBuffer insert(int i,boolean b){
		return this.insert(i,b?"true":"false");
	}

	public synchronized MyStrigBuffer insert(String str){
		return this.insert(this.n,str);
	}

	public synchronized MyStrigBuffer delete(int begin,int end){
		if(begin>=0&&begin<this.n&&end>=0&&begin<=end){
			if(end>this.n){
				end=this.n;
			}
			for(int i=0;i<this.n-end;i++){
				this.value[begin+i]=this.value[end+i];
			}
			this.n-=end-begin;
			return this;
		}
		else throw new StringIndexOutOfBoundsException("begin="+begin+",end="+end+",end-begin="+(begin+begin));
	}
	public static void main(String[] args) {

	}
}
 
