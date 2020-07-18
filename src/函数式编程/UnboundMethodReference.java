package 函数式编程;

/**
 * @author clt
 * @create 2020/7/18 14:20
 */
class X {
    String f() { return "X::f()"; }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        MakeString ms = new X()::f; // [1]
        TransformX sp = X::f;
        X x = new X();
        System.out.println(ms.make());
        System.out.println(sp.transform(x)); // [2]
        System.out.println(x.f()); // 同等效果
    }
}