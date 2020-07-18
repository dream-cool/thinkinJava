package 异常.使用finally进行清理;

/**
 * @author clt
 * @create 2019/12/4 19:43
 * 使用finally来做什么 示例 练习14
 */
//: exceptions/OnOffSwitch.java
// Why use finally?
class OnOffException1 extends  Exception{}
class OnOffException2 extends  Exception{}

public class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f()
            throws OnOffException1,OnOffException2 {
//        throw new OnOffException1();
//        throw new OnOffException2();
//        throw new  NullPointerException();
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f();
            sw.off();

        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
        /**
         * 程序的目的是无论发生什么都希望开关是关闭的
         * 当f方法正常执行时 或者抛出OnOffException1 和OnOffException2异常时
         * 开关都将被关闭 达得到目的，
         * 但当程序抛出其他异常时则无法捕获到异常无法正常关闭
         * 必须在finally语句块中来执行这些操作
         */

    }
} /* Output:
on
off
*///:~
