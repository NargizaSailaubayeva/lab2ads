import java.util.EmptyStackException;

public class MyLinkedListStack<E> {
    private MyLinkedList<E> stack;
    public MyLinkedListStack() { //constructor
        stack = new MyLinkedList<>();
    }
    // method push

    /**
     * add the element to the stack
     * @param element that will be added
     */
    public void push(E element) {
        stack.addFirst(element);
    }
    //method pop
    /**
     * return top element of the stack and remove it
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removed(0);
    }
    //method peek
    /**
     * return the front element of the stack
     * @return the front element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(0);
    }
    // method isEmpty

    /**
     * if stack is empty return true, if not false
     * @return true or false
     */
    public boolean isEmpty() {
        if (stack.size() == 0) return true;
        return false;
    }
    //method size
    /**
     * return size or number of elements in stack
     * @return size
     */
    public int size() {
        return stack.size();
    }
}
