package 异常.异常链;

/**
 * @author clt
 * @create 2019/12/4 19:04
 */
class MyselfException1 extends RuntimeException{
    public MyselfException1() {
    }

    public MyselfException1(String s) {
        super(s);
    }
}
class MyselfException2 extends RuntimeException{
    public MyselfException2() {
    }

    public MyselfException2(String s) {
        super(s);
    }
}

public class Practice10 {
    static void f(){
        g();
        throw new MyselfException1("I am the first MyselfException1");
    }

    static void g(){
        throw new MyselfException2("I am the second MyselfException2");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyselfException2 e2){
            System.out.println("Caught MyselfException2");
            try {
                throw new MyselfException1("throw the first MyselfException1");
            } catch (MyselfException1 e1){
                System.out.println("Caught MyselfException1");
            }
        }
    }

}
