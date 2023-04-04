public class L4Q1 {
    //1)
    static class Node <E>{
        E element;
        Node <E> next;

        public Node(){

        }

        public Node (E e){
            element = e;
        }
    }

    //2)
    static class MyLinkedList<E> {
        private Node <E> head;
        private Node <E> tail;
        private int size;

        public MyLinkedList(){
            head = null;
            tail = null;
        }

        public void addFirst(E e){
            Node <E> newNode = new Node<>(e);
            newNode.next = head;
            head = newNode;

            if(tail == null){
                tail = head;
            }
            size++;

        }

        public void addLast(E e){
            Node<E> newTail = new Node<>(e);
            if (tail == null)
                head = newTail;
            else
                tail.next = newTail;
            tail = newTail;
        }

        public void add(int index, E e){
            if(index == 0){
                addFirst(e);
            }
            Node <E> current = head;
            for(int i = 1; i < index; i++){
                current = current.next;
            }

            Node <E> temp = new Node<>(e);
            temp.next = current.next;
            current.next = temp;

            if(temp.next == null){
                tail = temp;
            }

            size++;
        }

        public E removeFirst(){
            E element = head.element;
            head = head.next;
            if(head == null){
                tail = null;
            }
            size--;
            return element;
        }

        public E removeLast(){
            E element = tail.element;
            if(tail == null){
                return null;
            }
            if(head == tail){
                head = tail = null;
                return element;
            }

            //update the tail
            Node<E> current = head;
            while(current.next.next!=null){
                current = current.next;
            }
            current.next = null;
            tail = current;

            size--;
            return element;
        }

        public E remove(int index){
            if(index == 0){
                removeFirst();
            }


            Node <E> current = new Node<>();
            for(int i = 1; i < index; i++){
                if(current.next == null){
                    removeLast();
                }
                current = current.next;
            }

            E element = current.next.element;
            current.next = current.next.next;
            return element;
        }

        public boolean contains(E e){
            Node <E> current = head;
            while(current.next != null){
                if(current.element.equals(e)){
                    return true;
                }else{
                    current = current.next;
                }
            }
            return false;
        }

        public E getFirst(){
            E first = head.element;
            return first;
        }

        public E getLast() {
            if (tail == null) return null;
            return tail.element;
        }

        public E get(int index) {
            if (index < 0) return null;

                Node<E> current = head;
                while (index-- > 0)
                    current = current.next;
                return current.element;

        }

        public int indexOf(E e){
            int index = 0;
            Node <E> pointer = head;
            while(pointer.next != null){
                if(pointer.element.equals(e)){
                    return index;
                }
                else{
                    pointer = pointer.next;
                    index++;
                }
            }
            return -1;
        }

        public int lastIndexOf(E e){
            int index = -1;
            int i = 0;
            for (Node<E> current = head; current != null; current = current.next) {
                if (e.equals(current.element))
                    index = i;
                i++;
            }
            return index;
        }

        public E set(int index, E e){
            int idx = 0;

            for(Node <E> current = head; current != null; current=current.next){
                if(idx == index){
                    current.element = e;
                }
                idx ++;
            }
            return e;
        }

        public void clear() {
            head = tail = null;
        }

        public void print() {
            for (Node<E> current = head; current != null; current = current.next)
                System.out.print(current.element + " ");
            System.out.println();
        }

        public void reverse() {
            String s = "";
            for (Node<E> current = head; current != null; current = current.next)
                s = current.element + " " + s;
            System.out.println(s);
        }

        public E getMiddleValue(){
            //count the size of linkedlist
            int size = 0;
            for(Node<E> current = head; current != null; current= current.next){
                size++;
            }

            int mid;
            if(size %2 == 0){
                mid = Math.floorDiv(size, 2)-1;
            }else{
                mid = Math.floorDiv(size, 2);
            }
            int count = 0;

            for(Node<E> current = head; current != null; current= current.next){
                if(count == mid){
                    return current.element;
                }
                count++;
            }
            return null;
        }


    }
}


