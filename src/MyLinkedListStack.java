import java.util.EmptyStackException;

public class MyLinkedListStack<E> {
    private MyLinkedList<E> stack;
    public MyLinkedListStack() {
        stack = new MyLinkedList<>();
    }
    public void push(E element) {
        stack.addFirst(element);
    }
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removed(0);
    }
    public boolean isEmpty() {
        if (stack.size() == 0) return true;
        return false;
    }

}
