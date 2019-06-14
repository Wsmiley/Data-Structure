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
		int index=0;//循环

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

	/*不用栈遍历二叉树*/

//	public static void printGenList1(TriTNode root){
//
//		TriTNode p=root;
//		TriTNode q=p;
//
//		int index=1;//需要返回到第几个父母
//		int count=0;//记录是否跳出循环
//
//		while (true){
//
//			if(q!=null){
//				System.out.print(q.data.toString());
//				q=q.leftchild;
//				if(q!=null){//类似进栈一样
//					if(!q.isLeaves())
//						p=q;
//				}
//			}else {
//				q = p.rightchild;
//				if (q != null) {
//					index++;
//					p = q;
//				}else {
//					for(int i=0;i<index;i++){
//						p=p.parent;
//						if(p==root){
//							index=0;
//							count++;
//							if(count==2){
//								break;
//							}
//						}
//					}
//
//				}
//			}
//			if(count==2)
//				break;
//		}
//	}

	/*已完成查bug*/
//	public static void printGenList(TriTNode root){
//
//		TriTNode p=root;
//		TriTNode q=p;
//
//		int index=1;//需要返回到第几个父母
//		int count=0;//记录是否跳出循环
//
//		while (true){
//
//			if(q!=null){
//				System.out.print(q.data.toString());
//				if(q.isLeaves()&&q==q.parent.leftchild){
//					System.out.print(",");
//					if(q.parent.rightchild==null){
//						System.out.print(")");
//					}
//				}
//
//				if(!q.isLeaves()){
//					System.out.print("(");
//					if(q.leftchild==null){
//						System.out.print(",");
//					}
//				}
//				if(q.isLeaves()&&q==q.parent.rightchild){
//					System.out.print(")");
//				}
//				q=q.leftchild;
//				if(q!=null){//类似进栈一样
//					p=q;
//				}
//			}else {
//				q = p.rightchild;
//				if (q != null) {
//					p = q;
//					index++;
//				}else {
//					for(int i=0;i<index;i++){
//						p=p.parent;
//						if(p==root){//遍历完左子树，开始遍历右子树
//							index=0;
//							count++;
//							if(count==1){
//								System.out.print(",");
//							}
//							if(count==2){
//								break;
//							}
//						}
//					}
//				}
//			}
//			if(count==2){
//				System.out.print(")");
//				break;
//			}
//		}
//	}

	public static void printGenList(TriTNode root){

		TriTNode p=root;
		TriTNode q=p;

		int index=1;//需要返回到第几个父母
		int count=0;//记录是否跳出循环
		while (true){

			if(q!=null){
				System.out.print(q.data.toString());
				if(q.isLeaves()&&q==q.parent.leftchild){
					if(q.parent.rightchild==null){
						System.out.print(",");
						System.out.print(")");
					}
				}

				if(!q.isLeaves()){
					System.out.print("(");
				}
				if(q.isLeaves()&&q==q.parent.rightchild){
					System.out.print(")");
				}
				q=q.leftchild;
				if(q!=null){//类似进栈一样
					if(!q.isLeaves())
						p=q;
				}
			}else {
				q = p.rightchild;
				if (q != null) {
					p = q;
					index++;
					System.out.print(",");
				}else {
					for(int i=0;i<index;i++){
						p=p.parent;
						if(p==root){//遍历完左子树，开始遍历右子树
							index=0;
							count++;
							if(count==2){
								break;
							}
						}
					}
				}
			}
			if(count==2){
				System.out.print(")");
				break;
			}
		}
	}



	public static void main(String[] args) {
		String gLists = "(A(B(C,D),E(F,G(H,I)))";
		TriTNode rootnode=BinaryTreeGlist.create(gLists);

		System.out.println();
		BinaryTreeGlist.printGenList(rootnode);

	}
}


