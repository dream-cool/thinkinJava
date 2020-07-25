package java8实战;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author clt
 * @create 2020/7/25 16:12
 */
public class OptionalTest {
    public static void test1(){
        List<String> data = Arrays.asList("aaa","bbbb", null,"eeee");
        data.stream()
                .map(var -> Optional.ofNullable(var))
                .forEach(var -> var.ifPresent(System.out::println));
    }

    public static void main(String[] args) {
        test1();
    }
}
