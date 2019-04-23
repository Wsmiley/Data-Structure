/**
 * FileName: BinaryTree
 * Author:   Smiley
 * Date:     2019/4/23 18:57
 * Description: BinaryTree
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈BinaryTree〉
 *
 * @author Smiley
 * @create 2019/4/23
 * @since 1.0.0
 */

public class BinaryTree<T> {
	public BinaryNode<T>root;
	public BinaryTree(){
		this.root=null;
	}
	public boolean isEmpty(){
		return this.root==null;
	}
	//插入x作为根结点,原根结点为左儿子
	public BinaryNode<T>insert(T x){
		return this.root=new BinaryNode<T>(x,this.root,null);
	}

	//插入x为parent的左/右儿子,leftChild指定孩子,true为左，flase为右
	//parten的原左/右儿子成为x结点的左/右孩子,返回插入结点
	public BinaryNode<T>insert(BinaryNode<T>parent,T x,boolean leftChild){
		if(x==null){
			return null;
		}
		if(leftChild){
			return parent.left=new BinaryNode<T>(x,parent,null);
		}
		return parent.right=new BinaryNode<T>(x,null,parent.right);
	}

	//删除parent结点的左/右子树,删除子树
	public void remove(BinaryNode<T>parent,boolean leftChild){
		if(leftChild)
			parent.left=null;
		else parent.right=null;
	}
	public void clear(){
		this.root=null;
	}
	//先根次序遍历,递归
	public void preorder(){
		preorder(this.root);
		System.out.println();
	}
	public void preorder(BinaryNode<T>p){
		if(p!=null){
			System.out.print(p.data.toString()+"");
			preorder(p.left);
			preorder(p.right);
		}
	}

	public String toString(){
		return toString(this.root);
	}
	private String toString(BinaryNode<T>p){
		if(p==null) {
			return "^";//空子树标记
		}
		return p.data.toString()+""+toString(p.left)+toString(p.right);//递归调用
	}
	//中根次序遍历
	public void inorder(){
		inorder(this.root);
		System.out.println();
	}
	public void inorder(BinaryNode<T>p){
		if(p!=null){
			inorder(p.left);
			System.out.println(p.data.toString()+"");
			inorder(p.right);
		}
	}
	//后根次序遍历
	public void postorder(){
		postorder(this.root);
		System.out.println();
	}
	public  void postorder(BinaryNode<T>p){
		if(p!=null){
			postorder(p.left);
			postorder(p.right);
			System.out.println(p.data.toString()+"");
		}
	}
	//结点数
	public int size(){
		if(this.isEmpty()){
			return 0;
		}
		return size(this.root);
	}
	public int size(BinaryNode<T>p){
		if(p!=null){
			return 1+size(p.right)+size(p.right);
		}else {
			return 0;
		}
	}
	//高度
	public int height(){
		return height(this.root);
	}
	public int height(BinaryNode<T>p){
		if(p==null) {
			return 0;
		}
		int Lh=height(p.left);
		int Rh=height(p.right);
		return (Lh>Rh)?Lh+1:Rh+1;
	}

	public BinaryTree(T[] preList){
		this.root=create(preList);
	}

	private int i=0;
	public BinaryNode<T>create(T[] preList){
		BinaryNode<T>p=null;
		if(i< preList.length){
			T element=preList[i];
			i++;
			if (element!=null){
				p=new BinaryNode<T>(element);
				p.left=create(preList);
				p.right=create(preList);
			}
		}
		return p;
	}

	//深拷贝
	public BinaryTree(BinaryTree<T>binaryTree){
		this.root=copy(binaryTree.root);
	}

	public BinaryNode<T>copy(BinaryNode<T>p){
		if(p==null){
			return null;
		}
		BinaryNode<T>q=new BinaryNode<T>(p.data);
		q.left=copy(p.left);
		q.right=copy(p.right);
		return q;
	}

	public static void main(String[] args) {
		String[]prelist={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
		BinaryTree<String>bitree=new BinaryTree<String>(prelist);
		System.out.println("PRE    "+bitree.toString());
		System.out.println("INORDER     ");bitree.inorder();
		System.out.println("rear     ");bitree.postorder();
		bitree.insert(bitree.root.left,"X",true);
		bitree.insert(bitree.root.right,"Y",false);
		bitree.insert("Z");
	}
}
 
