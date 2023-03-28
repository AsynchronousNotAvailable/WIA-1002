class MyGeneric<E> {
    private E e;

    public MyGeneric(){}

    public MyGeneric(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}

class L2Q1 {
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<String>();
        MyGeneric<Integer> intObj = new MyGeneric<Integer>();
        strObj.setE("Hello");
        intObj.setE(10);
        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
    }
}
