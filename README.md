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
