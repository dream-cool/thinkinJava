package 继承.h八;

/**
 * @author clt
 * @create 2019/11/28 19:30
 * 7.8.1 final参数 示例
 */
//: FinalArguments.java
// Using "final" with method arguments
class Gizmo {
    public String name = "name";
    public void spin() {}
}
public class FinalArguments {
    void with(final Gizmo g) {
        //! g = new Gizmo(); // Illegal -- g is final
        g.spin();
    }
    void without(Gizmo g) {
        g = new Gizmo(); // OK -- g not final
        g.spin();
    }
    // void f(final int i) { i++; } // Can't change
    // You can only read from a final primitive:
    int g(final int i) { return i + 1; }
    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(new Gizmo());
        Gizmo g = new Gizmo();
        g = new Gizmo();
        bf.with(g);
    }
} ///:~
