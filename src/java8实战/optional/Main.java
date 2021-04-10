package java8实战.optional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description
 * @author: clt
 * @create: 2021-04-10 14:38
 **/
public class Main {
    public static void main(String[] args) {
        // test flatMap、map
        // testStreamData();

        // testMatch();

        // testFilter();

    }

    private static void testFilter() {
        String hello = Optional.ofNullable("ch1enliutao")
                .filter(item -> item.startsWith("chen"))
                .orElse("chenxxx");
        System.out.println(hello);
    }

    private static void testMatch() {
        boolean b = Optional.ofNullable(testStreamData())
                .map(Stream::of)
                .orElse(Stream.empty())
                .flatMap(Collection::stream)
                .anyMatch(item -> item.endsWith("1"));
                // .allMatch(item -> item.endsWith("1")) false
        System.out.println(b);
    }


    private static List<String> testStreamData() {
        // 将 Map<String, List<String>> 中的所有 value 数据重新转换成一个新的 List<String>
        Map<String, List<String>> data = buildBigObject();
        return Optional.ofNullable(data)
                .map(Map::values)
                .map(Stream::of)
                .orElse(Stream.empty())
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static Map<String, List<String>> buildBigObject() {
        Map<String, List<String>> data = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                list.add(i + "" + j);
            }
            data.put(String.valueOf(i), list);
        }
        return data;
     }
}
