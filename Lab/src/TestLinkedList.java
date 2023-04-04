public class TestLinkedList {
    public static void main(String[] args) {
        L4Q1.MyLinkedList <Character> list = new L4Q1.MyLinkedList<Character>();

        for(char c = 'a'; c <= 'e'; c++){
            list.addLast(c);
        }
        list.print();
        list.reverse();
        int size = list.lastIndexOf(list.getLast())+1;
        System.out.println(size);

        System.out.println("First Value: "+ list.getFirst());
        System.out.println("Last value: " + list.getLast());

        System.out.println("Second value: " + list.get(1));
        System.out.println("Third value: " + list.get(2));

        System.out.println(list.contains('d'));

        list.set(0, 'j');
        list.set(1, 'a');
        list.set(2, 'v');
        list.set(3, 'a');
        list.removeLast();
        list.print();

        System.out.println(list.getMiddleValue());
    }
}
