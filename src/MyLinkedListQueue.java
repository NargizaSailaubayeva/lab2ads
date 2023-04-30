import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> {
    private MyLinkedList<E> queue;
    public MyLinkedListQueue(){
        queue = new MyLinkedList<>();
    }
    public void enqueue(E element){
        queue.add(element, size()-1);
    }
    public E dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return queue.removed(0);
    }
    public E peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return queue.get(0);
        }
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
