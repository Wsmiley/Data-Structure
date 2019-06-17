/**
 * FileName: BinaryTreeGlist
 * Author:   Smiley
 * Date:     2019/6/11 19:01
 * Description: 广义表构造二叉树
 * History:
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈广义表构造二叉树〉
 *
 * @author Smiley
 * @create 2019/6/11
 * @since 1.0.0
 */
public class BinaryTreeGlist {



	public static TriTNode<String> create(String genlist){

		TriTNode rootNode=null;
		TriTNode currentNode=null;

		int flag=0;//广义表转换二叉树的左右子树case标志
		int index=1;//循环

		int backparent=0;//判断到底是否需要返回父结点，0返回，1不返回
		final int LeftChild=1;//添加在左孩子标记
		final int RightChild=2;//添加在右孩子标志

		rootNode=new TriTNode<>(genlist.charAt(0));
		currentNode=rootNode;
		while(index<genlist.length()){

			char c=genlist.charAt(index++);

			switch (c){
				case '(':
					flag=LeftChild;
					break;
				case ',':
					flag=RightChild;
					if(currentNode!=rootNode&&backparent==0) {
						currentNode = currentNode.parent;
					}
					backparent=0;
					break;
				case ')':
					if(currentNode!=rootNode&&backparent==0) {
						currentNode = currentNode.parent;
					}
					backparent=0;
					break;
				case '^':
					backparent=1;
					break;
				default:
					TriTNode Node=new TriTNode<>(c);
					switch (flag){
						case LeftChild:
							currentNode.leftchild=Node;
							Node.parent=currentNode;
							currentNode=Node;
							break;
						case RightChild:
							currentNode.rightchild=Node;
							Node.parent=currentNode;
							currentNode=Node;
							break;
						}
			}
		}
		return rootNode;
	}

//	/*类似递归思想,(,)的条件匹配上*/
//	public static void printGenList(TriTNode root) {
//		TriTNode p;
//		TriTNode pr;
//		p = root;
//		System.out.print("二叉树的广义表表示:");
//		int index=0;//记录()匹配
//		while (p != null) {
//			System.out.print(p.data.toString());
//			if (p.leftchild != null) {
//				System.out.print("(");
//				index++;
//				p = p.leftchild;
//			} else {
//				if (p.rightchild != null) {
//					System.out.print("(");
//					System.out.print("^");
//					index++;
//					System.out.print(",");
//					p = p.rightchild;
//				} else {
//					if(p.isLeaves()&&p.parent.rightchild==p) {
//						System.out.print(")");
//						index--;
//					}
//					if (p.parent.rightchild==null){
//						System.out.print(",");
//						System.out.print("^");
//						System.out.print(")");
//						index--;
//					}
//					do {
//						pr = p;
//						p = p.parent;
//						if(p==root){
//							while (index>1){
//								System.out.print(")");
//								index--;
//							}
//						}
//					} while (p != null && (p.leftchild != pr || p.rightchild == null));
//					if (p != null) {
//						System.out.print(",");
//						p = p.rightchild;
//
//					}
//				}
//			}
//		}
//		System.out.print(")");
//	}

	public static void printGenList(TriTNode root){
		TriTNode p,pr;
		p = root;
		System.out.print("二叉树的广义表表示:");
		while (p!=null) {
			System.out.print(p.data.toString());
			if (p.leftchild != null) {
				System.out.print("(");
				p = p.leftchild;
			} else {
				if (p.rightchild != null) {
					System.out.print("(");
					System.out.print("^");
					System.out.print(",");
					p = p.rightchild;
				} else {
					do {
						pr = p;
						p = p.parent;
						if(p!=null&&pr!=p.leftchild) { ;
							System.out.print(")");
						}
						if(p==null)
							System.out.print(")");
						if (p!=null&&p.rightchild==null){
							System.out.print(",");
							System.out.print("^");
							System.out.print(")");
						}
					} while (p != null && (p.leftchild != pr || p.rightchild == null));
					if (p != null) {
						System.out.print(",");
						p = p.rightchild;
					}
				}
			}
		}
	}



	public static void main(String[] args) {
		String gLists = "A(B(C,D),E(F,G(H,I)))";
		TriTNode rootnode=BinaryTreeGlist.create(gLists);
		BinaryTreeGlist.printGenList(rootnode);
		System.out.println();
	}
}


