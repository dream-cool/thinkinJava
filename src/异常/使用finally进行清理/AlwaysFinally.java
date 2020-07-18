package 异常.使用finally进行清理;

/**
 * @author clt
 * @create 2019/12/4 19:55
 * 使用finally来做什么  示例3
 */
//: exceptions/AlwaysFinally.java
// Finally is always executed.

class FourException extends Exception {}

public class AlwaysFinally {
    public static void main(String[] args) {
        System.out.println("Entering first try block");
        try {
            System.out.println("Entering second try block");
            try {
                throw new FourException();
            } finally {
                System.out.println("finally in 2nd try block");
            }
        } catch(FourException e) {
            System.out.println(
                    "Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
        /**
         * 多重异常和break和continue
         * 上面三种情况最终在finally都将被执行
         */

    }
} /* Output:
Entering first try block
Entering second try block
finally in 2nd try block
Caught FourException in 1st try block
finally in 1st try block
*///:~

