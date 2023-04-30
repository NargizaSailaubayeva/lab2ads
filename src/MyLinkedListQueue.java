import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> {
    private MyLinkedList<E> queue;
    public MyLinkedListQueue(){ //constructor
        queue = new MyLinkedList<>();
    }
    // method enqueue
    /**
     * add the element to the queue
     * @param element the element that will add in queue
     */

    public void enqueue(E element){
        queue.add(element, size()-1);
    }
    // method dequeue

    /**
     * remove the first elements of queue and return it
     * @return the first elements of the queue
     * @throws if the queue is empty
     */
    public E dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return queue.removed(0);
    }
    //method peek

    /**
     * return the first elements of queue
     * @return the first elements of the queue
     * @throws if the queue is empty
     */
    public E peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return queue.get(0);
        }
    }
    // method isEmpty

    /**
     * if queue is empty return true, if not false
     * @return true or false
     */
    public boolean isEmpty(){
        if (queue.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    //method size

    /**
     * return size or the number of elements in queue
     * @return size
     */
    public int size() {
        return queue.size();
    }
}
