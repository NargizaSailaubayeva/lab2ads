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
        nan.add(66);
        //nan.clear();
        nan.sortsubl();
        for( int i=0; i<nan.size(); i++){
            System.out.print(nan.get(i) + " ");
        }
        /*
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
        } */
    }
}