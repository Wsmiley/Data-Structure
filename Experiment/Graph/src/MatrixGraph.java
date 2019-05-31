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

	public MatrixGraph(T[] vertices)
	public static void main(String[] args) {

	}
}
 
