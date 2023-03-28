import java.util.Arrays;

public class L2Q4 {
    public static <T extends Comparable<T>> String minmax(T[] arr){
        T max = arr[0], min = arr[0];
        for (T e : arr) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
            if (e.compareTo(min) < 0) {
                min = e;
            }
        }
        return ("Min: " + min + ", Max: " + max);
    }

    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};
        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }
}
