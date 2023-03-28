class MinMaxTwoDArray {
    public static <E extends Comparable<E>> E min(E[][] list) {
        E min = list[0][0];
        for (E[] e : list) {
            for (E f : e) {
                if (f.compareTo(min) < 0) {
                    min = f;
                }
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        for (E[] e : list) {
            for (E f : e) {
                if (f.compareTo(max) > 0) {
                    max = f;
                }
            }
        }
        return max;
    }
}

class L2Q6 {
    public static void main(String[] args) {
        Integer[][] arr = {{4,5,6},{1,2,3}};
        System.out.println(MinMaxTwoDArray.min(arr));
        System.out.println(MinMaxTwoDArray.max(arr));
    }
}
