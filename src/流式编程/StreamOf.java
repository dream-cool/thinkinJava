package 流式编程;

import java.util.stream.Stream;

/**
 * @author clt
 * @create 2020/7/18 16:02
 */
public class StreamOf {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map( var -> var+" ")
                .forEach(System.out::print);
        System.out.println();
        Stream.of("It's ", "a ", "wonderful ", "day ", "for ", "pie!")
                .map( var -> var+" ")
                .forEach(System.out::print);
        System.out.println();
        Stream.of(3.14159, 2.718, 1.618)
                .map( var -> var+" ")
                .forEach(System.out::print);
    }
}
