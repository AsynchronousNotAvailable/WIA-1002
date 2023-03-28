class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>> {
    private T first,second;
    public StorePairGeneric(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "First: " + first + ", Second: " + second;
    }

    // (b)
    public boolean equals(StorePairGeneric<T> other) {
        return this.first.equals(other.getFirst());
    }

    // (c)
    public int compareTo(StorePairGeneric<T> other) {
        return this.first.compareTo(other.getFirst());
    }
}

// (d)
class L2Q3 {
    public static void main(String[] args) {
        StorePairGeneric<Integer> a = new StorePairGeneric<Integer>(6,4);
        StorePairGeneric<Integer> b = new StorePairGeneric<Integer>(2,2);
        StorePairGeneric<Integer> c = new StorePairGeneric<Integer>(6,3);

        //(e)
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(b.compareTo(c));
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
    }
}
