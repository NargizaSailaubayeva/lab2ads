public class Main {
    public static void main(String[] args) {
        Integer[] array = {4,7,8,6,5};
        MyArrayList<Integer> nan = new MyArrayList<>(array);
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
        MyLinkedList link = new MyLinkedList();


    }
}