import java.util.NoSuchElementException;
public class MyArrayListQueue<E> {
    private MyArrayList<E> queue;
    public MyArrayListQueue() {
        queue = new MyArrayList<>();
    }
    public void enqueue(E element) {
        queue.add(element);
    }

}
