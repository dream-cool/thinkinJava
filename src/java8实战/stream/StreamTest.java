package java8实战.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author clt
 * @create 2020/7/24 20:37
 */
public class StreamTest {

    public static void test1(){
        List<String> stringList = Arrays.asList("aaaa","bbbb","ccc","dddd","eeeeee");
        stringList.stream()
                .peek(System.out::println)
                .filter( str -> str.length() > 3)
                .map( str -> str.substring(2))
                .distinct()
                .skip(1)
                .limit(2)
                .sorted()
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
         test1();


        //  stream --> optional  by findAny
        //  optional --> stream  by map(stream::of)


        // static method
        // test concat
        // Stream.concat(list1().stream(), list2().stream()).forEach(System.out::println)
        // Stream.of("hello").forEachOrdered(System.out::println)
        // Stream.builder().add(11).add(22).build().forEach(System.out::println);
    }

    public static List<String> list1() {
        return Arrays.asList(new String[]{"11", "22"});
    }

    public static List<String> list2() {
        return Arrays.asList(new String[]{"33", "44"});
    }

}
