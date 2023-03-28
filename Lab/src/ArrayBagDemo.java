public class ArrayBagDemo {

    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.print("Adding ");
        for(String i: content){
            aBag.add(i);
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void displayBag(BagInterface<String> bag){
        Object[] arr = bag.toArray();
        System.out.printf("The bag contains %d string(s), as follows:\n", bag.getCurrentSize());
        for (Object o : arr)
            System.out.print(o + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Bag 1:");
        ArrayBag<String> bag1 = new ArrayBag<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(bag1, contentsOfBag1);
        displayBag(bag1);

        System.out.println("Bag 2:");
        ArrayBag<String> bag2 = new ArrayBag<>();
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
        testAdd(bag2, contentsOfBag2);
        displayBag(bag2);

        System.out.println("Bag 3:");
        ArrayBag<String> bag3 = (ArrayBag<String>) bag1.union(bag2);
        displayBag(bag3);

        System.out.println("Bag 4:");
        BagInterface<String> bag4 = new ArrayBag<>();
        bag4 = bag1.intersection(bag2);
        displayBag(bag4);

        System.out.println("Bag 5:");
        BagInterface<String> bag5 = new ArrayBag<>();
        bag5 = bag1.difference(bag2);
        displayBag(bag5);
    }
}
