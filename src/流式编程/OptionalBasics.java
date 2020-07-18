package 流式编程;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author clt
 * @create 2020/7/18 16:39
 */
public class OptionalBasics {
    static void test(Optional<String> optString) {
        if(optString.isPresent())
            System.out.println(optString.get());
        else
            System.out.println("Nothing inside!");
    }
    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
