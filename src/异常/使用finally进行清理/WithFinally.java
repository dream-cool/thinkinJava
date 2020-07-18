package 异常.使用finally进行清理;

/**
 * @author clt
 * @create 2019/12/4 19:53
 * 使用finally来做什么  示例 练习15
 */
//: exceptions/WithFinally.java
// Finally Guarantees cleanup.

public class WithFinally {
    static Switch sw = new Switch();
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            OnOffSwitch.f();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
        /**
         * 使用finally来关闭开关
         * 无论发送什么，finally语句块的代码都将得到执行
         */

    }
} /* Output:
on
off
*///:~

