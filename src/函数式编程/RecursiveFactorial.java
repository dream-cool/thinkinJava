package 函数式编程;

/**
 * @author clt
 * @create 2020/7/18 14:10
 */

interface IntCall {
    int call(int arg);
}
public class RecursiveFactorial {
    static IntCall fact;
    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        for(int i = 0; i <= 10; i++)
            System.out.println(fact.call(i));
    }
    /**
     * 递归方法必须是实例变量或静态变量，否则会出现编译时错误
     */

}
