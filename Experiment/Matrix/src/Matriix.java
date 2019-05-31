/**
 * FileName: Matriix
 * Author:   Smiley
 * Date:     2019/5/31 16:11
 * Description: 矩阵
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈矩阵〉
 *
 * @author Smiley
 * @create 2019/5/31
 * @since 1.0.0
 */
public class Matriix {
	private int rows,columns;
	private int[][]element;

	public Matriix(int rows, int columns){
		this.element=new int[rows][columns];
		this.rows = rows;
		this.columns=columns;
	}

	public Matriix(int n){
		this(n,n);
	}

	public Matriix(int rows, int columns, int[][]value){
		this(rows,columns);
		for(int i=0;i<value.length;i++){
			for(int j=0;j<value[i].length;j++){
				this.element[i][j]=value[i][j];
			}
		}
	}

	public int getRow(){
		return this.rows;
	}

	public int getColums(){
		return this.columns;
	}

	public int get(int rows,int columns){
		if(rows>=0&&rows<this.rows &&columns>=0&&columns<this.columns){
			return this.element[rows][columns];
		}
		throw new IndexOutOfBoundsException("rows="+rows+",columns="+columns);
	}

	public void set(int rows,int columns,int x){
		if(rows>=0&&rows<this.rows &&columns>=0&&columns<this.columns){
			this.element[rows][columns]=x;
		}else {
			throw new IndexOutOfBoundsException("rows="+rows+",columns="+columns);
		}
	}

	public String toString(){
		String str="矩阵"+this.getClass().getName()+"("+this.rows +"x"+this.columns+"):\n";
		for(int i=0;i<this.rows;i++){
			for(int j=0;j<this.columns;j++){
				str+=String.format("%6d",this.element[i][j]);
			}
			str+="\n";
		}
		return str;
	}

	public void setRowsColumns(int rows,int columns){
		if(rows>0&&columns>0){
			if(rows>this.element.length||columns>this.element[0].length){
				int[][]source=this.element;
				this.element=new int[rows][columns];
				for (int i=0;i<this.rows;i++){
					for (int j=0;j<this.columns;j++){
						this.element[i][j]=source[i][j];
					}
				}
			}
			this.rows=rows;
			this.columns=columns;
		}else {
			throw new IllegalArgumentException("矩阵行列树不能<=0,m="+rows+",n="+columns);
		}
	}

	public static void main(String[] args) {
		int value[][]={{1,2,3},{4,5,6,7},{9}};
		Matriix mata=new Matriix(3,4,value);
		mata.set(2,3,10);
		System.out.print("A"+mata.toString());
	}
}
 
