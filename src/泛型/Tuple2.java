package 泛型;

/**
 * @author clt
 * @create 2020/7/18 9:44
 */
public class Tuple2<A, B> {
    public final A a1;
    public final B a2;
    public Tuple2(A a, B b) { a1 = a; a2 = b; }
    public String rep() { return a1 + ", " + a2; }

    @Override
    public String toString() {
        return "(" + rep() + ")";
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> tuple = new Tuple2<>("1234", 5678);
        System.out.println(tuple);
    }
}