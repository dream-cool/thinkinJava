package 异常.使用finally进行清理;

/**
 * @author clt
 * @create 2019/12/4 19:26
 * 使用finally进行清理  示例
 */
//: exceptions/FinallyWorks.java
// The finally clause is always executed.

class ThreeException extends Exception {}

public class FinallyWorks {
    static int count = 0;
    public static void main(String[] args) {
        while(true) {
            try {
                // Post-increment is zero first time:
                if(count++ == 0)
                    throw new ThreeException();
                System.out.println("No exception");
            } catch(ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if(count == 2) break; // out of "while"
            }
            /**
             * 无论是否异常被抛出
             * finally语句块的代码都将会被执行
             */

        }
    }
} /* Output:
ThreeException
In finally clause
No exception
In finally clause
*///:~
