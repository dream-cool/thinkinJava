package 异常.创建自定义异常;

/**
 * @author clt
 * @create 2019/12/2 21:33
 */
class SimpleException extends Exception{}
public class InheritingExceptions {

    public void f() throws SimpleException {
        System.out.println("Throw SimpleException form f()");
        throw  new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (Exception e){
            System.out.println("catch it");
        }

        /**
         * Throw SimpleException form f()
         * catch it
         */

    }

}
