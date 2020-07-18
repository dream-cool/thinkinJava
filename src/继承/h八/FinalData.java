package 继承.h八;

import java.util.Arrays;

/**
 * @author clt
 * @create 2019/11/28 18:48
 * 7.8.1 final数据 示例
 */
//: FinalData.java
// The effect of final on fields
class Value {
    int i = 1;
}
public class FinalData {
    // Can be compile-time constants
    final int i1 = 9;
    static final int I2 = 99;
    // Typical public constant:
    public static final int I3 = 39;
    // Cannot be compile-time constants:
    final int i4 = (int)(Math.random()*20);
    static final int i5 = (int)(Math.random()*20);
    /**
     * 并不是被final修饰的基本类型就是固定数值可以用函数返回值赋值，
     * 则final修饰的基本类型也将不确定
     * final修饰虽然是不可更改的 但没有static修饰就可以有多份
     * 所以当多个实例调用函数赋值的成员变量时，值会有所不同，
     * 所以只有static  final 修饰才是真正的常量
     */
    public static final int i6 = (int)(Math.random()*20);
    Value v1 = new Value();
    final Value v2 = new Value();
    static final Value v3 = new Value();
    //! final Value v4; // Pre-Java 1.1 Error:
    // no initializer
    // Arrays:
    final int[] a = { 1, 2, 3, 4, 5, 6 };
    public void print(String id) {
        System.out.println(
                id + ": " + "i4 = " + i4 +
                        ", i5 = " + i5);
    }
    public static void main(String[] args) {
        FinalData fd1 = new FinalData();
        //! fd1.i1++; // Error: can't change value
        fd1.v2.i++; // Object isn't constant!
        fd1.v1 = new Value(); // OK -- not final
        for(int i = 0; i < fd1.a.length; i++)
            fd1.a[i]++; // Object isn't constant!
        System.out.println("a"+Arrays.toString(fd1.a));
        //! fd1.v2 = new Value(); // Error: Can't
        //! fd1.v3 = new Value(); // change handle
        //! fd1.a = new int[3];
        fd1.print("fd1");
        System.out.println("Creating new FinalData");
        FinalData fd2 = new FinalData();
        fd1.print("fd1");
        fd2.print("fd2");
    }
} ///:~