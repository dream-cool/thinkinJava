package java8实战;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author clt
 * @create 2020/7/25 9:10
 */
public class FlatMapTest {
    public static void test1(){
        List<String> words = new ArrayList<>(Arrays.asList("hello","world")) ;

        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(toList());
        System.out.println(uniqueCharacters);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
        System.out.println();
        List<int[]> pairs1 =
                numbers1.stream()
                        .flatMap(i ->
                                numbers2.stream()
                                        .filter(j -> (i + j) % 3 == 0)
                                        .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        for (int[] pair : pairs1) {
            System.out.println(Arrays.toString(pair));
        }


    }

    public static void main(String[] args) {
        test1();
    }
}
