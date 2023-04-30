import java.util.EmptyStackException;
public class MyArrayListStack<E> {
    private MyArrayList<E> stack;
    public MyArrayListStack(){ //constructor
        stack = new MyArrayList<>();
    }
    // method push

    /**
     * add the element to the stack
     * @param element that will be added
     */
    public void push(E element){
        stack.add(element);
    }
    // method pop

    /**
     * return top element of the stack and remove it
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    public E pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removed(stack.size() -1);
    }
    // method peek

    /**
     * return the first elements of stack
     * @return the first elements of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }
    // method isEmpty

    /**
     * if stack is empty return true, if not false
     * @return true or false
     */
    public boolean isEmpty(){
        if (stack.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    // method size

    /**
     * return size or number of elements in stack
     * @return size
     */
    public int size() {
        return stack.size();
    }
}
