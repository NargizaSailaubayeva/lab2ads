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
        return size;
    }

    @Override
    public boolean contains(Object o) {
        MyNode currentElement = head;
        for (int i = 0; i < size; i++) {
            if (currentElement.data.equals(o)) {
                return true;
            }
            currentElement = currentElement.next;
        }
        return false;
    }

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }


    @Override
    public void add(T item, int index) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            if (head == null) {
                add(item);
                return;
            }
        } else if (index == 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else {
            MyNode currentElement = head;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
            newNode.next = currentElement;
            newNode.previous = currentElement.previous;
            currentElement.previous.next = newNode;
            currentElement.previous = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(T item) {
        MyNode newNode = new MyNode((T) item);
        MyNode currentNode = head;
        while (currentNode != null && !currentNode.data.equals(item)) {
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            return false;
        } else if (currentNode == head) {
            head = head.next;
            if (head != null){
                head.previous = null;
            }
            else{
                tail = null;
            }
        } else if (currentNode == tail) {
            tail = tail.previous;
            tail.next = null;
        }
        else{
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
        size--;
        return true;
    }

    @Override
    public T removed(int index) {
        T temp = get(index);
        remove(get(index));
        return temp;
    }


    @Override
    public void clear() {
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        if (index < size / 2) {
            MyNode currentElement = head;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
            return currentElement.data;
        } else {
            MyNode currentElement = tail;
            for (int i = size - 1; i > index; i--) {
                currentElement = currentElement.previous;
            }
            return currentElement.data;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o) {
        MyNode currentElement = head;
        for (int i = 0; i < size; i++) {
            if (currentElement.data.equals(o)) {
                return i;
            }
            currentElement = currentElement.next;
        }
        System.err.println("It does not exist");
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode currentElement = tail;
        int count = size;
        for (int i = size - 1; i >= 0; i--) {
            if (currentElement.data.equals(o)) {
                return i;
            }
            currentElement = currentElement.previous;
        }
        System.err.println("It does not exist");
        return -1;
    }

    @Override
    public void sort() {
        if (size <= 1){
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            MyNode currentElement = head;
            while (currentElement.next != null) {
                if (((Comparable<T>) currentElement.data).compareTo(currentElement.next.data) > 0) {
                    T temp = currentElement.data;
                    currentElement.data = currentElement.next.data;
                    currentElement.next.data = temp;
                    swapped = true;
                }
                currentElement = currentElement.next;
            }
        } while (swapped) ;
    }
}
