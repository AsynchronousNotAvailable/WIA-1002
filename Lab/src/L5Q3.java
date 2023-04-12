import java.util.NoSuchElementException;

public class L5Q3 {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        System.out.println(list.size);

        list.addFirst(1);
        list.addLast(10);
        list.addLast(100);

        list.add(2, 2);
        list.remove(3);
        System.out.println();

        list.traverseForward();
        list.traverseBackward();


        list.clear();
        System.out.println();


    }

    static class DoublyLinkedList <E> {
        private SNode<E> head;
        private SNode<E> tail;
        private int size;


        static class SNode<E> {
            E element;
            private SNode<E> prev;
            private SNode<E> next;


            public SNode(E item) {
                this.element = item;
            }
        }

        public void addFirst(E e){
            SNode<E> node = new SNode<>(e);
            node.next = head;
            if (head != null) head.prev = node;
            head = node;

            if (tail == null) tail = head;
            size++;
            System.out.println("adding: " + e);
        }

        public void addLast(E e){
            SNode<E> node = new SNode<>(e);
            if(tail != null){
                tail.next = node;
            }
            node.prev = tail;
            tail = node;
            if (head == null){
                head = tail;
            }
            size++;
            System.out.println("adding: "+ e);
        }

        public void add(int idx, E e){
            if(idx == 0){
                addFirst(e);
            }
            else if(idx == size){
                addLast(e);
            }
            else if(idx > size){
                System.out.printf("There is still empty spots before index %d", idx);
                System.exit(0);
            }
            else{
                SNode<E> current = head;
                for(int i = 1; i < idx; i++){
                    current = current.next;
                }
                SNode <E> newNode =  new SNode<>(e);
                current.next = newNode;
                current.next.prev = newNode;
                newNode.prev = current;
                newNode.next = current.next;
            }
            size++;

        }

        public E removeFirst(){
            if (head == null) {
                throw new NoSuchElementException();
            }
            E item = head.element;
            head = head.next;
            if(head != null){
                head.prev = null;
            }
            else{
                tail = null;
            }
            size--;
            System.out.println("Removed First: " + item);
            return item;

        }

        public E removeLast(){
            if(tail == null){
                throw new NoSuchElementException();
            }
            E item = tail.element;
            tail = tail.prev;
            if(tail != null){
                tail.next = null;
            }
            else{
                head = null;
            }
            size--;
            System.out.println("Removed Last: "+ item);
            return item;
        }

        public E remove(int idx){
            if(idx == 0){
                removeFirst();
            }
            else if(idx == size-1){
                removeLast();
            }
            else {
                SNode<E> current = head;
                for (int i = 1; i < idx; i++) {
                    current = current.next;
                }
                E item = current.element;
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                System.out.println("Deleted item: " + item);
                return item;
            }
            return null;
        }

        public void traverseForward(){
            for(SNode current = head; current.next != null; current = current.next){
                System.out.print(current.element + " ");
            }
            System.out.println();
        }

        public void traverseBackward(){
            for(SNode current = tail; current.prev != null;current = current.prev ){
                System.out.print(current.element + " ");
            }
            System.out.println();
        }

        public void clear(){
            head = tail = null;
            size = 0;
            System.out.println("cleared");
        }

        public void display(){
            for(SNode current = head; current != null; current= current.next){
                System.out.print(current.element + " ");

            }
            System.out.println();
        }
    }


}



