import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> {
    private MyLinkedList<E> queue;
    public MyLinkedListQueue(){
        queue = new MyLinkedList<>();
    }
    public void enqueue(E element){
        queue.add(element, size()-1);
    }
    public boolean isEmpty(){
        if (queue.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public int size() {
        return queue.size();
    }
}
