package 异常.创建自定义异常;

import java.util.Random;

/**
 * @author clt
 * @create 2019/12/3 19:47
 */
public class Practice5 {
    public static void main(String[] args) {
        Random random = new Random();
        boolean flag = true;
        while (flag){
            try {
                int num = random.nextInt(21);
                if (num < 20){
                    throw new Exception(String.valueOf(num));
                }
                flag = false;
                System.out.println(num+"  not found exception");
            } catch (Exception e) {
                System.out.println(e.getMessage() +"   occur exception, program continue");
            }
        }
        System.out.println("program end");
        /**
         * 恢复模型，当程序发生异常时，程序将一直执行while循环
         * 只有随机数等于20时才不再抛出异常，程序将跳出循环
         */

    }

}
