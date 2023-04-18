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


    @Override
    public void add(T item) {
    if (size == arr.length){
        increaseBuffer();
    }
    arr[size++] = item;

    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);
        if (size == arr.length){
            increaseBuffer();
        }
        for(int i = size; i>=index; i--){
            arr[i+1] = arr[i];
        }
        arr[index] = item; size++;
    }
    private void increaseBuffer(){
        T[] arr2 = (T[]) new Object[arr.length * 2];
        for(int i=0; i<arr.length; i++){
            arr2[i] = (T) arr[i];
        }
        arr=arr2;

    }
    private void checkIndex(int index){
        if (index <0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public boolean remove(T item) {
        removed(indexOf(item));

        return true;
    }


    public T removed(int index) {
        checkIndex(index);
        T[] arrNew = (T[]) new Object[arr.length];
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            arrNew[p] = arr[i];
            p++;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = arrNew[i];
        }
        size--;
        return (T) arr;
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
