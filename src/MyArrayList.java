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

        public void sortsubl(){
        if(arr[0] instanceof Integer){
            int index1, index2;
            int[] p = new int[size];
            for(int i =0; i< size; i++) {
                index1 =i;
                index2 = p.length-1;
                p[i] = (Integer) arr[i];
            }
            mergeSort(p, 0, p.length-1);
            for (int i = 0; i<size; i++){
                index1=i;
                index2 =p.length-1;
                arr[i]= (T)(Integer) p[i];
            }
        }
        else{
            System.out.println("something wrong");
        }

        }

}
