package 函数式编程;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.*;

/**
 * @author clt
 * @create 2020/7/18 14:56
 */
public class Test {

    public static void main(String[] args) {
        Function<String, Integer> fun1 = var -> Integer.parseInt(var);

        System.out.println(fun1.apply("124"));

        LongBinaryOperator fun2 = (num1, num2) -> num1 + num2;
        System.out.println(fun2.applyAsLong(15, 65));

        Supplier<Integer> fun3 = () -> new Random().nextInt(100);
        System.out.println(fun3.get());

        Predicate<Integer> fun4 = num -> num % 2 == 0;
        System.out.println(fun4.test(fun3.get()));

        BinaryOperator<String> fun5 = (str1, str2) -> str1 + str2;
        System.out.println(fun5.apply("hello", "world"));

        BiFunction<Integer, Boolean, Map> fun6 =  (var1, var2) -> {
            Map<Integer, Boolean> map = new HashMap();
            map.put(var1, var2);
            return map;
        };
        System.out.println(fun6.apply(fun3.get(), fun4.test(fun3.get())));

    }
}
