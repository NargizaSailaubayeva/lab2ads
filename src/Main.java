public class Main {
    public static void main(String[] args) {
        Integer[] array = {4,7,8,6,7,5};
        MyArrayList<Integer> arr = new MyArrayList<>(array);
        System.out.println(arr.size());
        System.out.println(arr.get(3));
        System.out.println(arr.indexOf(8));
        System.out.println(arr.lastIndexOf(7));
        System.out.println(arr.contains(6));
    }
}