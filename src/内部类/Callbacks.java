package 内部类;

/**
 * @author clt
 * @create 2020/7/22 14:27
 */
interface Incrementable {
    void increment();
}
// Very simple to just implement the interface:
class Callee1 implements Incrementable {
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}
class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }
    static void f(MyIncrement mi) { mi.increment(); }
}
// If your class must implement increment() in
// some other way, you must use an inner class:
class Callee2 extends MyIncrement {
    private int i = 0;
    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements Incrementable {
        @Override
        public void increment() {
            // Specify outer-class method, otherwise
            // you'll get an infinite recursion:
            //Callee2.this.increment();
            System.out.println("i am closure increment");
        }
    }
    Incrementable getCallbackReference() {
        return new Closure();
    }
}
class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }
    void go() { callbackReference.increment(); }
}
public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 =
                new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }

    /**
     * 这个例子进一步展示了外部类实现一个接口与内部类实现此接口之间的区别。就代码而言，Callee1 是更简单的解决方式。
     * Callee2 继承自 MyIncrement，后者已经有了一个不同的 increment() 方法，
     * 并且与 Incrementable 接口期望的 increment() 方法完全不相关。
     * 所以如果 Callee2 继承了 MyIncrement，就不能为了 Incrementable 的用途而覆盖 increment() 方法，
     * 于是只能使用内部类独立地实现 Incrementable，还要注意，当创建了一个内部类时，并没有在外部类的接口中添加东西，也没有修改外部类的接口。
     */


    /**
     * 闭包（closure）是一个可调用的对象，它记录了一些信息，这些信息来自于创建它的作用域。
     * 通过这个定义，可以看出内部类是面向对象的闭包，因为它不仅包含外部类对象（创建内部类的作用域）的信息，
     * 还自动拥有一个指向此外部类对象的引用，在此作用域内，内部类有权操作所有的成员，包括 private 成员。
     */
}