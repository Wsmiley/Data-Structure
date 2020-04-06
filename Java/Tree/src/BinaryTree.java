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

	public String toString(){
		return toString(this.root);
	}

	private String toString(BinaryNode<T>p){
		if(p==null) {
			return "^";//空子树标记
		}
		return p.data.toString()+""+toString(p.left)+toString(p.right);//递归调用
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


	//中根次序遍历
	public void inorder(){
		inorder(this.root);
		System.out.println();
	}
	private void inorder(BinaryNode<T>p){
		if(p!=null){
			inorder(p.left);
			System.out.print(p.data.toString()+"");
			inorder(p.right);
		}
	}

	public void inorderTraverse(){
		BinaryNode<T>p=this.root;
		LinkedStack<BinaryNode<T>>stack=new LinkedStack<BinaryNode<T>>();
		while(p!=null){
			while (p!=null){
				if(p.right!=null){
					stack.push(p.right);
				}
				stack.push(p);
				p=p.left;
			}
			p=stack.pop();
			while(!stack.isEmpty()&&p.right==null){
				System.out.print(p.data);
				p=stack.pop();
			}
			System.out.print(p.data);
			if(!stack.isEmpty()){
				p=stack.pop();
			}else {
				p=null;
			}
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
			System.out.print(p.data.toString()+"");
		}
	}

	public void postorderTraverse(){
		BinaryNode<T>p=this.root;
		BinaryNode<T>q=this.root;
		LinkedStack<BinaryNode<T>>stack=new LinkedStack<BinaryNode<T>>();
		while(p!=null){
			for(;p.left!=null;p=p.left){
				stack.push(p);
			}
			while (p!=null&&p.right==null||p.right==q){
				System.out.print(p.data);
				q=p;
				if(stack.isEmpty()){
					return;
				}
				p=stack.pop();
			}
			stack.push(p);
			p=p.right;
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

	public boolean equals(BinaryTree<T>p,Object obj) {
		if (p == obj)
			return true;

		if (obj instanceof BinaryTree<?>) {
			BinaryTree<T> tree = (BinaryTree<T>) obj;
			System.out.println("tree: "+tree.toString());
			System.out.println("p: "+p.toString());
			return p.toString().equals(tree.toString());
		}
		return false;
	}

		public BinaryNode<T>search(BinaryTree<T>pattern){
		LinkedStack<BinaryNode<T>>stack=new LinkedStack<BinaryNode<T>>();
		BinaryNode<T>p=this.root;
		while(p!=null||!stack.isEmpty()){
			if(p!=null){
				if (panduan(p,pattern)){
					return p;
				}
				stack.push(p);
				p=p.left;
			}else {
				p=stack.pop().right;
			}
		}
		return null;
	}

	private boolean panduan(BinaryNode<T>R,BinaryTree<T>pattern){
		LinkedStack<BinaryNode<T>>Rstack=new LinkedStack<BinaryNode<T>>();
		LinkedStack<BinaryNode<T>>Pstack=new LinkedStack<BinaryNode<T>>();
		BinaryNode<T>geng=R;
		BinaryNode<T>p=pattern.root;
		while ((p!=null||!Pstack.isEmpty())&&(geng!=null||!Rstack.isEmpty())){
			if(geng!=null&&p!=null&&geng.data.equals(p.data)){
				Rstack.push(geng);
				geng=geng.left;
				Pstack.push(p);
				p=p.left;
			}else {
				if(geng==null&&p==null){
					geng=Rstack.pop().right;
					p=Pstack.pop().right;
				}else {
					return false;
				}
			}
			if(p==null&&Pstack.isEmpty()){
				return true;
			}
		}
		return false;
	}



	private BinaryNode<T>search1(BinaryTree<T>pattern) {
		if (pattern.isEmpty() || isEmpty()) {
			return null;
		}
		LinkedStack<BinaryNode<T>> Gstack = new LinkedStack<BinaryNode<T>>();
		LinkedStack<BinaryNode<T>> Pstack = new LinkedStack<BinaryNode<T>>();
		LinkedStack<BinaryNode<T>> Gchildstack = new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> G = this.root;
		BinaryNode<T> Gchild;
		BinaryNode<T> P = pattern.root;
		while (G != null || !Gstack.isEmpty()) {
			if (G != null) {
				Gchild = G;
				while ((Gchild  !=null || !Gchildstack.isEmpty())&&(!Pstack.isEmpty() || P !=  null)) {
					if (Gchild != null&&P != null) {
						if (Gchild.data.equals(P.data)) {
							Gchildstack.push(Gchild);
							Gchild = Gchild.left;
							Pstack.push(P);
							P = P.left;
						} else {
							Gchildstack.clear();
							P=pattern.root;
							Pstack.clear();
							break;
						}
					} else {
						if (P == null && Gchild == null) {
							Gchild = Gchildstack.pop().right;
							P = Pstack.pop().right;
						} else {
							Gchildstack.clear();
							P = pattern.root;
							Pstack.clear();
							break;
						}
					}
				}
				if(P==null&&Pstack.isEmpty()){
					while (!Gchildstack.isEmpty()){
						G=Gchildstack.pop();
					}
					return G;
				}
				Gstack.push(G);
				G=G.left;
			}else {
				G=Gstack.pop().right;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String[]prelist={ "A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
		String[]values={"C","E",null,null,"F","H",null,null} ;
		BinaryTree<String>bitree=new BinaryTree<String>(prelist);
		BinaryTree<String>bitree1=new BinaryTree<String>(values);
		System.out.println(bitree.toString());
		System.out.println(bitree1.toString());
		System.out.println(bitree.search(bitree1));
		System.out.println(bitree.toString());
	}

}
 
