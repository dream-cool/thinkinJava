package 继承.f六;

/**
 * @author clt
 * @create 2019/11/27 20:39
 * 7.6 protected关键字 示例  and 练习16
 */
//: Orc.java
// The protected keyword
import 继承.e五.Car;

import java.util.*;

//测试Car 中protected修饰的test方法 能夸包被访问
class Villain extends Car {
    private int i;
    protected int read() { return i; }
    protected void set(int ii) { i = ii; }
    public Villain(int ii) { i = ii; }
    public int value(int m) { return m*i; }
}
public class Orc extends Villain {
    private int j;
    public Orc(int jj) { super(jj); j = jj; }
    public void change(int x) {
        set(x);
        test();
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
} ///:~

