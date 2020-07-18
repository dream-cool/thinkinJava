package 异常.捕获异常;

/**
 * @author clt
 * @create 2019/12/2 21:12
 * 12.3捕获异常  示例
 */
public class ExceptionTest {

    public static void test1() throws InterruptedException {
        try {
            System.out.println(1);
            System.out.println(1/0);
            System.out.println(2);
        } catch (Exception e){
            System.out.println(1);
            e.printStackTrace();
            System.out.println(2);
            Thread.sleep(3000);
            System.out.println(3);
        }
        System.out.println(4);
    }

    public static void test2(){
        System.out.println(1);
        System.out.println(1/0);

        System.out.println(4);
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
//        test2();

        /**
         * 一旦发生了异常，异常后面的代码部分将不再执行，如果异常被catch了
         * 则将执行catch块代码，然后接着catch后面继续执行
         */


    }
}
