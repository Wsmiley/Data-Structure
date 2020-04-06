/**
 * FileName: MatrixGraph
 * Author:   Smiley
 * Date:     2019/5/31 16:06
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
public class MatrixGraph<T> extends AbstractGraph<T>{
	protected Matriix matriix;

	public MatrixGraph(int length){
		super(length);
		this.matriix=new Matriix(length);
	}

	public MatrixGraph(){
		this(10);
	}

	public MatrixGraph(T[] vertices){
		this(vertices.length);
		for(int i=0;i<vertices.length;i++){
			this.insertVertex(vertices[i]);
		}
	}

	public MatrixGraph(T[] vertices,Triple[]edges){
		this(vertices);
		for(int i=0;i<edges.length;i++){
			this.insertedges(edges[i]);
		}
	}
	public String toString()                               //返回图的顶点集合和邻接矩阵描述字符串
	{
		String str = super.toString()+"邻接矩阵:  \n";
//        str+=this.matrix.toString();
		int n = this.vertexCount();                        //顶点数
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
				if (this.matriix.get(i,j)==MAX_WEIGHT)
					str += "     ∞";
				else  str += String.format("%6d", this.matriix.get(i,j));
			str+="\n";
		}
		return str;
	}
	//插入一条边
	public void insertedges(Triple edge){
		this.insertEdge(edge.row, edge.column, edge.value);
	}

	public void insertEdge(int i, int j, int weight)       //插入边〈vi,vj〉，权值为weight
	{
		if (i!=j)                                          //不能表示自身环
		{
			if (weight<=0 || weight>MAX_WEIGHT)            //边的权值容错，视为无边，取值∞
				weight=MAX_WEIGHT;
			this.matriix.set(i,j,weight);                   //设置矩阵元素[i,j]值为weight。若i、j越界，抛出序号越界异常
		}
		else throw new IllegalArgumentException("不能插入自身环，i="+i+"，j="+j);
	}

	//（2）插入顶点
	public int insertVertex(T x)                           //插入元素为x的顶点，返回x顶点序号
	{
		int i = this.vertexlist.insert(x);                 //顶点顺序表尾插入x，返回x序号，自动扩容
		if (i >= this.matriix.getRow())                    //若邻接矩阵容量不够，
			this.matriix.setRowsColumns(i+1,i+1);           //矩阵扩容。保持邻接矩阵行列数同图的顶点数
		for (int j=0; j<i; j++)                            //初始化第i行、列元素值为∞。i==j值已为0
		{
			this.matriix.set(i,j,MAX_WEIGHT);
			this.matriix.set(j,i,MAX_WEIGHT);
		}
		return i;                                          //返回插入顶点序号
	}

	//（3）删除边
	public void removeEdge(int i, int j)                   //删除边〈vi,vj〉，忽略权值）
	{
		if (i!=j)
			this.matriix.set(i, j, MAX_WEIGHT);             //设置边的权值为∞。若i、j越界，抛出序号越界异常
	}
	public void removeEdge(Triple edge)                    //删除边，忽略权值
	{
		this.removeEdge(edge.row, edge.column);
	}

	//（4）删除顶点
	public void removeVertex(int i)                        //删除顶点vi及其所有关联的边
	{
		int n=this.vertexCount();                          //原顶点数
		if (i>=0 && i<n)
		{
			this.vertexlist.remove(i);                     //删除顶点顺序表第i个元素，顶点数减1。  //顺序表删除，若i越界，返回null
			for (int j=i+1; j<n; j++)                      //第i+1～n-1行元素上移一行，n为原顶点数
				for (int k=0; k<n; k++)
					this.matriix.set(j-1, k, this.matriix.get(j,k));
			for (int j=0; j<n; j++)
				for (int k=i+1; k<n; k++)                  //第i+1～n-1列元素左移一列
					this.matriix.set(j, k-1, this.matriix.get(j,k));
			this.matriix.setRowsColumns(n-1, n-1);          //邻接矩阵少一行一列
		}
		else throw new IndexOutOfBoundsException("i="+i);  //抛出序号越界异常
	}
	public int weight(int i, int j)           //返回<vi,vj>边的权值。用于图的最小生成树、最短路径等算法
	{
		return this.matriix.get(i,j);             //返回矩阵元素[i,j]值。若i、j越界，抛出序号越界异常
	}
	protected int next(int i, int j)
	{
		int n=this.vertexCount();
		if (i>=0 && i<n && j>=-1 && j<n && i!=j)
			for (int k=j+1; k<n; k++)                      //当j=-1时，k从0开始寻找后继邻接顶点
				if (this.matriix.get(i,k)>0 && this.matriix.get(i,k)<MAX_WEIGHT)//权值表示有边
					return k;
		return -1;
	}
	public void removeVertex(T vertex)           //删除顶点vertex及其关联的边
	{
		int i=this.vertexlist.search(vertex);    //在顺序表中查找值为vertex的元素，返回序号
		this.removeVertex(i);                    //删除顶点vi及其关联的边
	}

	public static void main(String[] args) {
		String[]vertices={"A","B","C","D","E"};
		Triple edges[]={new Triple(0,1,45),new Triple(0,2,28),new Triple(0,3,10),
						new Triple(1,0,45),new Triple(1,2,12),new Triple(1,4,21),
						new Triple(2,0,28),new Triple(2,3,17),new Triple(0,2,28),new Triple(2,4,26),
						new Triple(3,0,10),new Triple(3,4,15),new Triple(3,4,15),
						new Triple(4,1,21),new Triple(4,2,26),new Triple(4,3,15)};
		MatrixGraph<String>graph=new MatrixGraph<>(vertices,edges);
		System.out.println("带权无向图G3,"+graph.toString());
	}
}
 
