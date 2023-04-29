import java.util.EmptyStackException;
public class MyArrayListStack<E> {
    private MyArrayList<E> stack;
    public MyArrayListStack(){
        stack = new MyArrayList<>();
    }
    public void push(E element){
        stack.add(element);
    }

    public boolean isEmpty(){
        if (stack.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
