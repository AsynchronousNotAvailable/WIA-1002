package SList;

public class SNode <E> {
    E element;
    SNode<E> head;
    SNode<E> tail;
    SNode<E> next;
    public SNode(){
        element = null;
        next = null;
    }

    public SNode(E item){
        element = item;

    }
}

class SList<E> extends SNode<E>{
    private SNode []  list;
    int size;
    public SList(int size){
        this.size = size;
        list = new SNode[this.size];
    }

    public void appendEnd(E e){
        SNode<E> node = new SNode<>(e);
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = tail;
        size++;
    }

    public E removeInitial(){
        if (head == null) return null;
        E temp = head.element;
        head = head.next;
        size --;
        return temp;
    }

    public boolean contains(E e){
        for (SNode<E> node = head; node != null; node = node.next)
            if (e.equals(node.element))
                return true;
        return false;
    }

    public void clear(){
            head = tail = null;
            size = 0;
            System.out.println("The list is empty.");
    }

    public void display(){
        for (SNode<E> node = head; node != null; node = node.next)
            System.out.print(node.element + " "+ "\n");
    }
}


class TestSList{
    public static void main(String[] args) {
        SList <String> doublyLinkedList = new SList<String>(10);
        doublyLinkedList.appendEnd("Linked List");
        doublyLinkedList.appendEnd("is");
        doublyLinkedList.appendEnd("easy");

        doublyLinkedList.display();
        System.out.println(doublyLinkedList.removeInitial());
        System.out.println(doublyLinkedList.contains("difficult"));
        doublyLinkedList.clear();
    }
}
