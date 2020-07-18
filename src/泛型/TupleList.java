package 泛型;

import java.util.ArrayList;

/**
 * @author clt
 * @create 2020/7/18 10:42
 */
public class TupleList<A, B, C, D>
        extends ArrayList<Tuple4<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl =
                new TupleList<>();
        tl.add(TupleTest2.h());
        tl.add(TupleTest2.h());
        tl.forEach(System.out::println);
        /**
         * 泛型的一个重要好处是能够简单安全地创建复杂模型
         */

    }
}
