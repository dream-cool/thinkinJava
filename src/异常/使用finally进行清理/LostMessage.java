package 异常.使用finally进行清理;

/**
 * @author clt
 * @create 2019/12/4 20:59
 * 遗憾：异常丢失 示例
 */
//: exceptions/LostMessage.java
// How an exception can be lost.

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
//          1
            lm.dispose();
// 2               return;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        /**第一种情况
         * A trivial exception
         * 只能看到HoHumException的信息
         * VeryImportantException信息被丢失
         * 第二种情况
         * 在异常信息直接被丢失  程序将如没有发生异常一样
         */

    }
} /* Output:
A trivial exception
*///:~
