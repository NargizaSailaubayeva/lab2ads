import java.util.NoSuchElementException;

public class MyArrayListQueue<E> {
    private MyArrayList<E> queue;

    public MyArrayListQueue() { //constructor
        queue = new MyArrayList<>();
    }
    // method enqueue
    /**
     * add the element to the queue
     * @param element the element that will add in queue
     */

    public void enqueue(E element) {
        queue.add(element);
    }
    // method dequeue

    /**
     * remove the front element of the queue and return it
     * @return the front element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removed(0);
    }
    //method peek
    /**
     * return the front element of the queue
     * @return the front elements of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.get(0);
    }
    // method isEmpty

    /**
     * if queue is empty return true, if not false
     * @return true or false
     */
    public boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    //method size
    /**
     * return size or number of elements in queue
     * @return size
     */
    public int size() {
        return queue.size();
    }
}
