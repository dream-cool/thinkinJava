package 内部类;

/**
 * @author clt
 * @create 2020/7/22 10:16
 */
abstract class Base {
    Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }
    public abstract void f();
}
public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            { System.out.println(
                    "Inside instance initializer"); }
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }
    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
        /**
         * Base constructor, i = 47
         * Inside instance initializer
         * In anonymous f()
         */

        /**
         * 在匿名类中不可能有命名构造器（因为它根本没名字！），但通过实例初始化，
         * 就能够达到为匿名内部类创建一个构造器的效果，就像这样
         */

    }
}

