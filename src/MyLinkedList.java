public class MyLinkedList<T> implements MyList<T> {
    private int size = 0;
    private MyNode head;
    private MyNode tail;
    public class MyNode {
        MyNode next;
        MyNode previous;
        T data;
        MyNode(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(T item) {

    }

    @Override
    public void add(T item, int index) {

    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public T removed(int index) {
        return null;
    }



    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
