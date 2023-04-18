public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;
public MyArrayList(T[] arr){
    this.arr = arr;
    this.size = arr.length;
}
public int size(){
    return size;
    }
    @Override
    public boolean contains(Object o) {
        for(int i=0;i<size;i++){
            if(arr[i]==o){
               return true;
            }
        }
    return false;
    }
    private void increaseBuffer(){
    T[] arr2 = (T[]) new Object[arr.length * 2];
    for(int i=0; i<arr.length; i++){
        arr2[i] = (T) arr[i];
    }
    arr=arr2;
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
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {
    T[] arr2 = (T[]) new Object[5];
    arr=arr2;
    size = 0;
    }

    @Override
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(arr[i]==o){
                return i;
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size-1; i >= 0;i--){
            if(arr[i]==o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {

    }
}
