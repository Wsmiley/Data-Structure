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

	private BinaryNode<T>copy(BinaryNode<T>p){
		if(p==null){
			return null;
		}
		BinaryNode<T>q=new BinaryNode<T>(p.data);
		q.left=copy(p.left);
		q.right=copy(p.right);
		return q;
	}

	public boolean isEmpty(){
		return this.root==null;
	}
	//插入x作为根结点,原根结点为左儿子

	public BinaryNode<T>insert(T x){
		return this.root=new BinaryNode<T>(this.root,x,null);
	}

	//插入x为parent的左/右儿子,leftChild指定孩子,true为左，flase为右
	//parten的原左/右儿子成为x结点的左/右孩子,返回插入结点

	public BinaryNode<T>insert(BinaryNode<T>parent,T x,boolean leftChild){
		if(x==null){
			return null;
		}
		if(leftChild){
			return parent.left=new BinaryNode<T>(parent,x,null);
		}
		return parent.right=new BinaryNode<T>(null,x,parent.right);
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
	private void preorder(BinaryNode<T>p){
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
	private void inorder(BinaryNode<T>p){
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
	private void postorder(BinaryNode<T>p){
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
	private int size(BinaryNode<T>p){
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

	private int height(BinaryNode<T>p){
		if(p==null) {
			return 0;
		}
		int Lh=height(p.left);
		int Rh=height(p.right);
		return (Lh>Rh)?Lh+1:Rh+1;
	}

	public void printGenList(){
		System.out.print("二叉树的广义表表示:");
		printGenList(this.root);
		System.out.println();
	}

	private void printGenList(BinaryNode<T>p){
		if (p==null){
			System.out.print("^");
		}else {
			System.out.print(p.data.toString()+"");
			if(p.left!=null||p.right!=null){
				System.out.print("(");
				printGenList(p.left);
				System.out.print(",");
				printGenList(p.right);
				System.out.print(")");
			}
		}
	}

	public void preoderTraverse(){
		System.out.println("先根次序遍历（非递归）");
		LinkedStack<BinaryNode<T>>stack=new LinkedStack<BinaryNode<T>>();
		BinaryNode<T>p=this.root;
		while(p!=null||!stack.isEmpty()){
			if (p!=null){
				System.out.print(p.data+"");
				stack.push(p);
				p=p.left;
			}else {
				System.out.print("^");
				p=stack.pop();//返回父结点
				p=p.right;
			}
		}
	}

	public void levelorder(){
		System.out.print("层次遍历");
		LinkedQueue<BinaryNode<T>>que=new LinkedQueue<BinaryNode<T>>();
		BinaryNode<T>p=this.root;
		while(p!=null){
			System.out.print(p.data);
			if(p.left!=null){
				que.add(p.left);
			}
			if (p.right!=null){
				que.add(p.right);
			}
			p=que.poll();
		}
		System.out.println();

	}
	public BinaryNode<T>search(T key) {
		if (isEmpty()) {
			System.out.println("The tree is empty");
			return null;
		}
		return search(this.root,key);
	}

	private BinaryNode<T>search(BinaryNode<T>p,T key) {
		if (p != null){
			if (p.data==key) {
				return p;
			}
			BinaryNode<T> q = search(p.left, key);
			if (q != null) {
				return q;
			}
			BinaryNode<T> f = search(p.right, key);
			if (f != null) {
				return f;
			}
		}
		return null;
	}

	public BinaryNode<T>parent(BinaryNode<T>node){
		if(this.root==null||node.equals(this.root)){
			return null;
		}
		return parent(this.root,node);

	}

	private BinaryNode<T>parent(BinaryNode<T>p,BinaryNode<T>node) {
		if (p!=null){
			if(node.equals(p.getLeft())||node.equals(p.getRight())){
				return p;
			}else{
				parent(p.left,node);
				parent(p.right,node);
			}
		}
		return null;
	}

	public void removeAllMatched(BinaryTree<T>pattern){
		removeAllMatched(this.root,pattern.root);
	}

	private void removeAllMatched(BinaryNode<T>r,BinaryNode<T>parrtern){
	}

	public static void main(String[] args) {
		String[]prelist={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
		String[]values={"A","B","C","D","E","F","G"};
		BinaryTree<String>bitree=new BinaryTree<String>(prelist);
		BinaryTree<String>bitree1=new BinaryTree<String>(values);
		System.out.println("PRE:"+bitree.toString());
//		System.out.println("INORDER     ");bitree.inorder();
//		System.out.println("rear     ");bitree.postorder();
		System.out.println("pre:"+bitree1.toString());
//		bitree.insert(bitree.root.left,"X",true);
//		bitree.insert(bitree.root.right,"Y",false);
//		bitree.insert("Z");
		BinaryNode<String>z=new BinaryNode<>(null,"D",null);
		BinaryNode<String>p=new BinaryNode<>(null,"B",null);
		BinaryNode<String>q=new BinaryNode<>(p,"A",z);

		System.out.println(bitree.parent(q));
		System.out.println("bitree:"+bitree.search("F"));
		bitree.printGenList();
	}
}
 
