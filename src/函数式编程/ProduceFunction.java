package 函数式编程;

import java.util.function.Function;

/**
 * @author clt
 * @create 2020/7/18 15:16
 */
interface FuncSS extends Function<String, String> {} // [1]

public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase(); // [2]
    }

    static Function<String, String> produce1() {
        return s -> s.toUpperCase();
    }
    public static void main(String[] args) {
        FuncSS f = produce();
        Function<String, String> f2 = produce1();

        System.out.println(f.apply("YELLING"));
        System.out.println(f2.apply("hello"));

        /**
         * 这里，produce() 是高阶函数。
         * 1] 使用继承，可以轻松地为专用接口创建别名。
         *
         * [2] 使用 Lambda 表达式，可以轻松地在方法中创建和返回一个函数。
         */

    }
}
