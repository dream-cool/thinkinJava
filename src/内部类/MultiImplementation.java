package 内部类;

/**
 * @author clt
 * @create 2020/7/22 14:08
 */
class D {}

abstract class E {}

class Z extends D {
    E makeE() {
        return new E() {};
    }
}

public class MultiImplementation {
    static void takesD(D d) {}
    static void takesE(E e) {}

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());

        /**
         * 内部类可以有多个实例，每个实例都有自己的状态信息，并且与其外部类对象的信息相互独立。
         * 在单个外部类中，可以让多个内部类以不同的方式实现同一个接口，或继承同一个类。 稍后就会展示一个这样的例子。
         * 创建内部类对象的时刻并不依赖于外部类对象的创建
         * 内部类并没有令人迷惑的"is-a”关系，它就是一个独立的实体
         */

    }
}