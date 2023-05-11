import java.util.Collections;
import java.util.LinkedList;

public class L7Q1 {
//    b)
    public static void main(String[] args) {
        MyQueue <String> fruitQ = new MyQueue<String>(new String[]{"Durian", "Blueberry"});
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");
        System.out.println(fruitQ.toString());
        System.out.println(fruitQ.peek());
        System.out.println(fruitQ.getSize());
        fruitQ.dequeue();
        fruitQ.getElement(2);
        System.out.println(fruitQ.contains("Cherry"));
        System.out.println(fruitQ.contains("Durian"));
        while(!fruitQ.isEmpty()){
            System.out.print(fruitQ.dequeue() + " ");
        }

    }
}

//a)
class MyQueue <E>{
    private LinkedList<E> list;

    public MyQueue(E[] e) {
        this();
        Collections.addAll(list, e);
    }
    public MyQueue() {
        list = new LinkedList<>();
    }

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E getElement(int i){
        return list.get(i);
    }

    public E peek(){
        return list.getFirst();
    }

    public int getSize(){
        return list.size();
    }

    public boolean contains (E e){
        return list.contains(e);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }

}