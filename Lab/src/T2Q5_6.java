class Duo<A,B> {
    private A first;
    private B second;
    public Duo(A first, B second){
        this.first = first;
        this.second = second;
    }
}

class T2Q6 {
    public static void main(String[] args) {
        Duo<String, Integer> sideShape = new Duo<>("lmao", 69);
        Duo<Double, Double> points = new Duo<>(3.14, 4.20);
    }
}
