package 流式编程;

import java.util.stream.Stream;

/**
 * @author clt
 * @create 2020/7/18 16:35
 */
public class FlatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Fozzie", "Beaker"))
                .forEach(System.out::println);
    }
}