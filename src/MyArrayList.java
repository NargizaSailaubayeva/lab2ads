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
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {

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
