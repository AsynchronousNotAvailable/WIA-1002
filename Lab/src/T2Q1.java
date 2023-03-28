class Container<T> {
    private T t;
    public Container(){
    }

    void add(T t){
        this.t = t;
    }

    T retrieve(){
        return t;
    }

    public static void main(String[] args) {
        Container<Integer> c1 = new Container<Integer>();
        Container<String> c2 = new Container<String>();
        c1.add(50);
        c2.add("Java");
        System.out.println(c1.retrieve());
        System.out.println(c2.retrieve());
    }
}


