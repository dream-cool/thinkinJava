package 内部类;

/**
 * @author clt
 * @create 2020/7/22 13:59
 */
class MNA {
    private void f() {}
    class A {
        private void g() {}
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}
public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
        /**
         * 可以看到在 MNA.A.B 中，调用方法 g() 和 f() 不需要任何条件（即使它们被定义为 private）。
         * 这个例子同时展示了如何从不同的类里创建多层嵌套的内部类对象的基本语法。
         * ".new"语法能产生正确的作用域，所以不必在调用构造器时限定类名
         */

        /**
         * 使用内部类最吸引人的原因是：
         *
         * 每个内部类都能独立地继承自一个（接口的）实现，所以无论外部类是否已经继承了某个（接口的）实现，对于内部类都没有影响。
         *
         * 如果没有内部类提供的、可以继承多个具体的或抽象的类的能力，一些设计与编程问题就很难解决。
         * 从这个角度看，内部类使得多重继承的解决方案变得完整。
         * 接口解决了部分问题，而内部类有效地实现了“多重继承”。
         * 也就是说，内部类允许继承多个非接口类型（译注：类或抽象类）。
         */


    }
}

