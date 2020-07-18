package 异常.创建自定义异常;

/**
 * @author clt
 * @create 2019/12/3 19:34
 */
public class Practice2 {
    public static void main(String[] args) {
        Object obj = null;
        try {
            int hash  = obj.hashCode();
        }catch (NullPointerException e){
            System.out.println("an exception has happened");
        }
        System.out.println("this will continue execute");
        /**
         * obj为null 当它调用方法时将抛出空指针异常
         * 对该语句进行捕获异常后 将顺利执行后面的代码
         * 若没有对异常进行捕获，程序将直接被终止
         */

    }
}
