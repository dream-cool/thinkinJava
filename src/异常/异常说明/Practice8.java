package 异常.异常说明;

/**
 * @author clt
 * @create 2019/12/3 20:18
 */
public class Practice8 {

    public static void main(String[] args) {
        if (Math.random() > 0.5){
            try {
                throw new Exception();
            }catch (Exception e){

            }
        } else {
            throw new NullPointerException();
        }
        /**
         * NullPointerException 继承 RuntimeException 可以直接抛出，无需强制捕获
         * Exception 必须被捕获
         * 从RuntimeException继承的异常可以无需捕获且不捕获无需声明thorws
         */
    }
}
