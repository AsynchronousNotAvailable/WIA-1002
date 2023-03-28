class FindMax {
    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (E e : list) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }
}

class Circle implements Comparable<Circle> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle other) {
        if (this.radius > other.radius) {
            return 1;
        } else if (this.radius < other.radius) {
            return -1;
        } else {
            return 0;
        }
    }

}

class L2Q5 {
    public static void main(String[] args) {
        Integer[] intArray = {1,2,3};
        String[] strArray = {"red", "green", "blue"};
        Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};

        System.out.println(FindMax.max(intArray));
        System.out.println(FindMax.max(strArray));
        System.out.println(FindMax.max(circles));
    }
}