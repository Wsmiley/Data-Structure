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

//	public TriTNode<T> root;

	public static TriTNode<String> create(String genlist){

				TriTNode rootNode=null;
				TriTNode currentNode=null;

				int flag=0;
				int index=0;

				int backparent=0;//判断到底是否需要返回父结点，0返回，1不返回
				final int LeftChild=1;
				final int RightChild=2;

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
					if(rootNode==null){
						rootNode=Node;
						currentNode=rootNode;
					}else {
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
		}
		return rootNode;
	}

//	public static void printGenList(TriTNode root){
//		System.out.print("二叉树的广义表表示");
//		TriTNode p=root;
//		while(p!=null){
//
//		}
//
//		System.out.println();
//	}


	public static void printGenList(TriTNode root){
		System.out.print("二叉树的广义表表示:");
		printGenList1(root);
		System.out.println();
	}

	private static void printGenList1(TriTNode p){
		if (p==null){
			System.out.print("^");
		}else {
			System.out.print(p.data.toString()+"");
			if(p.leftchild!=null||p.rightchild!=null){
				System.out.print("(");
				printGenList1(p.leftchild);
				System.out.print(",");
				printGenList1(p.rightchild);
				System.out.print(")");
			}
		}
	}



	public static void main(String[] args) {
		String gLists = "(A(B(C,D),E(^,F)))";
		TriTNode rootnode=BinaryTreeGlist.create(gLists);
		System.out.println(rootnode);

		BinaryTreeGlist.printGenList(rootnode);

	}
}

