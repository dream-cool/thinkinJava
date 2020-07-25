package java8实战;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;

/**
 * @author clt
 * @create 2020/7/25 10:40
 */
public class CollectorTest {
    public static void test1(){
        Function<Object, Integer> intFun = var -> var.toString().length();

        List<Object> data = new ArrayList<>(Arrays.asList("hell",1111,22222222L,'c',"world")) ;

        //分组
        System.out.println(data.stream().collect(groupingBy(var -> var.toString().length() > 4)));

        System.out.println(data.stream().collect(groupingBy(intFun)));

        System.out.println(data.stream().collect(groupingBy(var -> var.getClass())));

        System.out.println(data.stream().collect(counting()));

        data.stream().max(Comparator.comparingInt(var -> var.toString().length())).ifPresent(System.out::println);

        System.out.println(data.stream().collect(summarizingInt(var -> var.toString().length())));

        //拼接
        System.out.println(data.stream().map(var -> var.toString()).collect(joining()));

        System.out.println(data.stream().map(var -> var.toString()).collect(joining(",")));

        System.out.println(data.stream().map(var -> var.toString()).collect(joining(",","[","]")));

        //规约
        System.out.println(data.stream().collect(reducing(0, intFun ,(i,j) -> i + j)));

        System.out.println(data.stream().collect(reducing(0, intFun ,Integer::sum)));
        //分区
        System.out.println(data.stream().collect(partitioningBy(var -> var.toString().length() > 4)));
        //分区再分组
        System.out.println(data.stream().collect(partitioningBy(var -> var.toString().length() > 4, groupingBy(var -> var.getClass()))));
    }

    public static void main(String[] args) {
        test2();
    }

    public static void test2(){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, 10_000_000L).parallel().forEach(accumulator::add);
        System.out.println(accumulator.total);
    }
}
class Accumulator {
    public AtomicLong total = new AtomicLong(0);
    public void add(long value) { total.addAndGet(value); }
}
