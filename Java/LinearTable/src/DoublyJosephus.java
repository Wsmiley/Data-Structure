/**
 * FileName: DoublyJosephus
 * Author:   Smiley
 * Date:     2019/4/6 13:51
 * Description:
 * History:
 */

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Smiley
 * @create 2019/4/6
 * @since 1.0.0
 */
public class DoublyJosephus {

	public DoublyJosephus(int number,int start,int distance){
		String[] values=new String[number];
		System.out.println("DoublyJosephus("+number+","+start+","+distance+")");

		int counter=number;

		for(int j=0;j<number;j++){
			values[j]=""+(char)('A'+j);
		}
		DoublyList<String>list=new DoublyList<>(values);
		System.out.println(list.toString());

		DoubleNode<String>front=list.head;

		for(int j=0;j<=start;j++){
			front=front.next;
		}
		DoubleNode<String>tail=list.head;
		while(tail.next!=null){
			tail=tail.next;
		}
		tail.next=list.head;
		while(counter>1) {
			tail.next=list.head;
			for (int j = 0; j < distance - 1; j++) {
				if (front.next != list.head) {
					front = front.next;
				} else {
					front = front.next.next;
				}
			}
			System.out.print("删除" + front.data.toString());
			front.prev.next = front.next;
			front.next.prev = front.prev;
			if(front.next==list.head) {
				tail=front.prev;
				front = front.next.next;
				tail.next=null;
			}else {
				front=front.next;
				tail.next=null;
			}
			counter--;
			System.out.println("---"+list.toString());
		}
		System.out.println("被赦免者是"+list.toString());
	}
	public static void main(String[] args) {
		DoublyJosephus jos=new DoublyJosephus(5,0,2);
	}
}

