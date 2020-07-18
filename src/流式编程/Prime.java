package 流式编程;

import java.util.stream.DoubleStream;

import static java.util.stream.DoubleStream.iterate;
import static java.util.stream.LongStream.rangeClosed;

/**
 * @author clt
 * @create 2020/7/18 16:28
 */
public class Prime {
    public static Boolean isPrime(long n) {
        return rangeClosed(2, (long)Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }
    public DoubleStream numbers() {
        return iterate(2, i -> i + 1)
                .filter(value -> value > 1);
    }
    public static void main(String[] args) {
        new Prime().numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        new Prime().numbers()
                .skip(90)
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
    }
}
