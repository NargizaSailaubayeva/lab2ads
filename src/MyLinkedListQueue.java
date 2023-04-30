import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> {
    private MyLinkedList<E> queue;
    public MyLinkedListQueue(){
        queue = new MyLinkedList<>();
    }
    public void enqueue(E element){
        queue.add(element, size()-1);
    }
    public int size() {
        return queue.size();
    }
}
