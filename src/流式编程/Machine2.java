package 流式编程;

import java.util.Arrays;

/**
 * @author clt
 * @create 2020/7/18 16:20
 */
public class Machine2 {
    public static void main(String[] args) {
        Arrays.stream(new int[]{1,2,3,4
        }).forEach(System.out::println);
    }
}