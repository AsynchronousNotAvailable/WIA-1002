class MyArray {
    static <E> void listAll(E[] arr) {
        for (E e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        String[] arr2 = {"Jane", "Tom", "Bob"};
        Character[] arr3 = {'a', 'b', 'c'};
        listAll(arr1);
        listAll(arr2);
        listAll(arr3);
    }
}
