public interface Stack<T> {

	public abstract boolean isEmpty();//栈是否为空
	public abstract void push(T x);//元素x入栈
	public abstract T peek();//返回栈顶元素，为出栈
	public abstract T pop();//出栈,返回栈顶元素


}
