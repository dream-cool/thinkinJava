package 流式编程;

import java.util.Arrays;

/**
 * @author clt
 * @create 2020/7/18 16:24
 */
public class Peeking {
    public static void main(String[] args) throws Exception {
        Arrays.stream(new String[]{"hello", "world", "CLT"})
                //.skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}