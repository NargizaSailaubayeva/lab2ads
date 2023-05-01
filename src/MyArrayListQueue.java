import java.util.NoSuchElementException;

public class MyArrayListQueue<E> {
    private MyArrayList<E> queue;

    public MyArrayListQueue() {
        queue = new MyArrayList<>();
    }

    public void enqueue(E element) {
        queue.add(element);
    }
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removed(0);
    }
    public boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
