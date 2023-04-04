public class T4Q2 {


}

class LinkedLists<E>{
    private Node<E> head = null;
    private Node<E> tail = null;

    public boolean contains(E element){
        Node <E> current = head;
        if (head == null){
            head = tail = null;
            return false;
        }
        while(current.next != null){
            if(current.element.equals(element)){
                return true;
            }
            else{
                current = current.next;
            }
        }
        return false;
    }
    private class Node<E> {
        E element;
        Node<E> next;
    }
}


