package java8实战.方法引用;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author clt
 * @create 2020/7/24 19:04
 */
public class MethodReference {
    private static List<String> stringList = new ArrayList<>();
    static {
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
    }

    /**
     *  方法引用测试
     */
    public static void test1() {
        //静态方法引用
        stringList.forEach(System.out::print);
        stringList.forEach(str -> System.out.print(str));
        System.out.println();
        //首位参数作为实例 方法引用
        Function<String,Integer> fun = String::length;
        System.out.println(fun.apply("abc0123"));
        Function<String,Integer> fun1 = str -> str.length();
        System.out.println(fun1.apply("abc0123"));
        //本地实例 方法引用
        Function<Integer, String> fun2 = stringList::get;
        System.out.println(fun2.apply(0));
        Function<Integer,String> fun3 = index -> stringList.get(index);
        System.out.println(fun3.apply(0));
        /**
         * aaabbbcccaaabbbccc
         * 7
         * 7
         * aaa
         * aaa
         */
    }

    public static String fun1(String str, Integer index){
        return str.substring(index);
    }

    public static void main(String[] args) {
        test1();
    }
}
