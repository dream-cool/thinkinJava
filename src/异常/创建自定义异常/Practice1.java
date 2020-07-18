package 异常.创建自定义异常;

/**
 * @author clt
 * @create 2019/12/3 19:27
 */
public class Practice1 {
    public static void main(String[] args) {
        System.out.println(1);
        try {
            throw new Exception("throw a exception");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("catch a exception");
        }
        try {
            System.out.println(1/0);;
        }finally {
            System.out.println("this will be executed");
        }
        /**
         * 先抛出一个异常，然后对异常进行捕获
         * 如果捕获到异常，则打印异常调用栈信息
         * 随后打印异常的message信息 即入参构造信息
         * 最后验证finally一定被执行
         */

    }
}
