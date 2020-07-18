package 继承.h八;

/**
 * @author clt
 * @create 2019/11/28 19:54
 * final类 示例
 */
//: Jurassic.java
// Making an entire class final
class SmallBrain {}
final class Dinosaur {
    int i = 7;
    final int j = 1;
    SmallBrain x = new SmallBrain();
    void f() {}
}
//! class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'
public class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
//        n.j++;
// error: Cannot change final data 'j'
        /**
         * final类仅仅是不可以被继承，类中非 final 成员变量可以更改
         */

    }
} ///:~
