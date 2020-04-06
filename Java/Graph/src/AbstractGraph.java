/**
 * FileName: AbstractGraph
 * Author:   Smiley
 * Date:     2019/5/31 15:54
 * Description: Abstract Graph
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈Abstract Graph〉
 *
 * @author Smiley
 * @create 2019/5/31
 * @since 1.0.0
 */
public abstract  class AbstractGraph<T> {
	protected static final int MAX_WEIGHT=0x0000ffff;//无穷大
	protected SeqList<T>vertexlist;//顶点顺序表,存储图的顶点集合

	public AbstractGraph(int length){
		this.vertexlist=new SeqList<>(length);
	}

	public AbstractGraph(){
		this(10);
	}
	//返回图的顶点数，顺序表的元素个数
	public int vertexCount(){
		return this.vertexlist.size();
	}
	//返回图的顶点描述集合描述字符串
	public String toString(){
		return "顶点集合："+this.vertexlist.tostring()+"\n";
	}
	//返回顶点元素Vi
	public T getVertex(int i){
		return this.vertexlist.get(i);
	}
	//设置顶点Vi元素为x
	public void setVertex(int i,T x){
		this.vertexlist.set(i,x);
	}

	public abstract int insertVertex(T x);//插入元素为x的顶点，返回x顶点的序号
	public abstract void removeVertex(T x);//删除顶点Vi以及其所有关联的边
	public abstract void insertedges(Triple edge);//插入元素为x的顶点，返回x顶点的序号
	public abstract int weight(int i,int j);//返回<Vi,Vj>边的权值
	protected abstract int next(int i,int j);//返回Vi在Vj后的后续邻接顶点序号。
	public abstract void removeEdge(Triple edge);//删除顶点Vi以及其所有关联的边
}
 
