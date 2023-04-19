# Laboratory 2 Algorithms and Data Structures
![hello](https://media3.giphy.com/media/E1w0yvMxBIv5M8WkL8/giphy.gif)

## Description
In this repository, I made laboratory 2 for Algorithms and Data Structures by creating classes MyArrayList and MyLinkedList which are implementations of ArrayList and LinkedList respectively.
We have interface `MyList`
```java
 public interface MyList<T> {
        int size();
        boolean contains(Object o);
        void add(T item);
        void add(T item, int index);
        boolean remove(T item);
        T removed(int index);
        void clear();
        T get(int index);
        int indexOf(Object o);
        int lastIndexOf(Object o);
        void sort();
    }
```
`MyArrayList` and `MyLinkedList` are implementation of a linked list in Java, which implement the 'MyList' interface
+ ***Array*** is a data structure of related data items, a set of variables of the same type.
+ ***ArrayList*** is a variable length Collection class. ArrayList can also be of generic type <T>
+ An Iterator is an object that can be used to loop through collections. MyArrayList can also implement an Iterable<T> interface 
+ ***LinkedList***  is a series of connected nodes
+ A node is an object that must hold a value and some references to other nodes 
![array](https://media.geeksforgeeks.org/wp-content/uploads/20210908120146/ArrayListIntegerObjecttype-660x268.png)
![linked](https://media.geeksforgeeks.org/wp-content/uploads/20220816144425/LLdrawio.png)

___
### MyArrayList
 ```java
 /**
 * MyArrayList is a custom implementation of the Java ArrayList class.
 * @param <T> the type of elements stored in this list
 */
public class MyArrayList<T> implements MyList<T> {
    // create and provided constructors for the MyArrayList
    private T[] arr; // create array
    private int size; // create size of array
    public MyArrayList(T[] arr){
    this.arr = arr;
    this.size = arr.length;
}

    public int size(){  // it returns size of array
    return size;
    }

    @Override
    public boolean contains(Object o) { // returns true if the specified element is found in this list, false otherwise
        for(int i=0;i<size;i++){
            if(arr[i]==o){
               return true; // if in array we have o it returns true
            }
        }
    return false; // if we don't have its returns false
    }
    /**
     * Appends the specified element to the end of this list.
     * If the list is full, it increases its buffer size by creating a new array with double the size
     *
     * @param item the element to be appended to this list
     */
    @Override
    public void add(T item) { // add item to the array list
    if (size == arr.length){
        increaseBuffer(); // it increased buffer
    }
    arr[size++] = item;
    }
    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param item the element to add
     * @param index the index at which the element is to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(T item, int index) { // add item and index
        checkIndex(index);
        if (size == arr.length){
            increaseBuffer(); //it increased buffer
        }
        for(int i = size; i>=index; i--){
            arr[i+1] = arr[i];
        }
        arr[index] = item; size++; // make size bigger
    }
    /**
     * Increases the capacity of the array by creating a new array with
     * double the capacity of the current array, copying the elements from
     * the current array to the new array, and setting the `arr` variable
     * to refer to the new array.
     */
    private void increaseBuffer(){ // increased buffer and make array bigger
        T[] arr2 = (T[]) new Object[arr.length * 2];
        for(int i=0; i<arr.length; i++){
            arr2[i] = (T) arr[i];
        }
        arr=arr2;

    }

    /**
     * this is helper method
     * @param index an integer representing the index to check
     */
    private void checkIndex(int index){ // checks index with using exception
        if (index <0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public boolean remove(T item) { // remove item in array list
        removed(indexOf(item));

        return true;
    }
    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index >= size)
     */
    public T removed(int index) { // remove item by index
        checkIndex(index);
        T[] arrNew = (T[]) new Object[arr.length];
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) { // checks every element if it = index
                continue;
            }
            arrNew[p] = arr[i];
            p++;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = arrNew[i];
        }
        size--; // reduces the size when we remove item
        return (T) arr;
    }

    @Override
    public void clear() { // this method clears the list by creating a new array of type T with size 5 and assigning it to the existing array
        this.arr = (T[]) new Object[5];
        this.size = 0; //set size to 0
    }

    /**
     * this method is used to retrieve an element from the 'MyArrayList' at a specific index
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    @Override
    public T get(int index) { // get index
        return (T) arr[index]; // return array by index
    }
    /**
    * Returns the index of the first occurrence of the specified element in this list,or -1 if this list does not contain the element.
    * @param o the element to search for
    * @return the index of the first occurrence of the specified element in this list,or -1 if this list does not contain the element
    */
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(arr[i]==o){
                return i;
            }

        }
        return -1;
    }
    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object o) {
        for(int i = size-1; i >= 0;i--){
            if(arr[i]==o){
                return i;
            }
        }
        return -1;
    }
    /**
     * Sorts the elements of the MyArrayList in ascending order. Only works for MyArrayList of Integer elements.
     * Uses the merge sort algorithm to sort the array.
     */
    @Override
    public void sort() {
        if (arr[0] instanceof Integer) {
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                temp[i] = (Integer) arr[i];
                }
            mergeSort(temp, 0, temp.length - 1);
            for (int i = 0; i < size; i++) {
                arr[i] = (T) (Integer) temp[i];
                }
            } else {
                System.out.println("System is not a Integer");
            }
        }
        private static void mergeSort(int[] arr, int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                mergeSort(arr, start, mid);
                mergeSort(arr, mid + 1, end);
                merge(arr, start, mid, end);
            }
        }

        private static void merge(int[] arr, int start, int mid, int end) {
            int[] temp = new int[end - start + 1];
            int i = start, j = mid + 1, k = 0;
            while (i <= mid && j <= end) {
                if (arr[i] < arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }
            while (i <= mid) {
                temp[k++] = arr[i++];
            }
            while (j <= end) {
                temp[k++] = arr[j++];
            }
            for (i = start; i <= end; i++) {
                arr[i] = temp[i - start];
            }
        }


}

 ```
___
### MyLinkedList
```java
/**
 * this is implementation of a linked list in Java, which implements th 'MyList' interface
 * @param <T> the type of elements stored in this list
 * size(): returns the number of elements in the list.
 * contains(Object o): returns true if the list contains the specified element.
 * add(T item): adds the specified element to the end of the list.
 * add(T item, int index): adds the specified element at the specified index in the list.
 * remove(T item): removes the first occurrence of the specified element from the list, if it exists.
 * removed(int index): removes the element at the specified index from the list and returns it.
 * clear(): removes all elements from the list.
 * get(int index): returns the element at the specified index in the list.
 * indexOf(Object o): returns the index of the first occurrence of the specified element in the list, or -1 if the element is not in the list.
 * lastIndexOf(Object o): returns the index of the last occurrence of the specified element in the list, or -1 if the element is not in the list.
 * checkIndex(int index) checks if the specified index is valid and throws an 'IndexOutOfBoundsException' if it is not
 * sort(): sorts the elements in the list in ascending order using the natural ordering of the elements.
 */
public class MyLinkedList<T> implements MyList<T> {
    private int size = 0;
    private MyNode head;
    private MyNode tail;

    public class MyNode { // represents a node in the linked list, has 3 fields: next, previous, data
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
        head = null;
        tail = null;
        size = 0;
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
``` 
___         

### Main
```java
/**
 * check MyArrayList and MyLinkedList if it works
 */
public class Main {
    public static void main(String[] args) {
        Integer[] array = {4,7,8,6,5}; // give array to check it
        MyArrayList<Integer> nan = new MyArrayList<>(array); //check MyArrayList
        System.out.println(nan.size());
        System.out.println(nan.get(3));
        System.out.println(nan.indexOf(5));
        System.out.println(nan.lastIndexOf(7));
        System.out.println(nan.contains(6));

        nan.add(13,2);
        nan.add(3);
        nan.add(56);
        nan.add(55);
        nan.remove(4);
        nan.removed(3);
        nan.sort();
        nan.clear();
        for( int i=0; i<nan.size(); i++){
            System.out.print(nan.get(i) + " ");
        }

        MyLinkedList link = new MyLinkedList(); //check MyLinkedList
        link.add(5);
        link.add(7);
        link.add(8);
        link.add(6);
        link.add(9,2);
        link.add(4,3);
        System.out.println(link.contains(7));
        System.out.println(link.indexOf(8));
        System.out.println(link.lastIndexOf(6));
        link.remove(8);
        link.removed(4);
        link.sort();
        link.clear();
        for (int i = 0; i<link.size(); i++){
            System.out.print(link.get(i) + " ");
        }
    }
}         
``` 
## Installation
IntelliJ IDEA 2022.3.1
## Contributing
Bug reports and\or pull requests are 
![gif](https://img.wattpad.com/6c151ba821ca2c749493262d427fb9d0324ec0fc/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f6147354e6948476d6c62704b50673d3d2d3636303937343137322e313537323431383735386537393136303532343031303939363231302e676966)

![welcome](https://poster.keepcalmandposters.com/4220629.jpg)

![bye]([https://media.tenor.com/5DcYGrosKfQAAAAC/bye-see-you.gif](https://media.tenor.com/5g95hQQSoj8AAAAC/bye-bye-bye.gif))
