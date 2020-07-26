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
//                .filter( str ->{
//                    System.out.println("1"+str);
//                    return str.length() > 3;
//                })
                .map( str-> {
                    System.out.println("2"+str);
                    return str.substring(1);
                })
                .filter( str -> {
                    System.out.println("3"+str);
                    return str.length() > 3;
                })
                .limit(2)
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        test1();
    }
}
