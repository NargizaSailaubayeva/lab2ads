import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> {
    private MyLinkedList<E> queue;
    public MyLinkedListQueue(){
        queue = new MyLinkedList<>();
    }


    public int size() {
        return queue.size();
    }
}
