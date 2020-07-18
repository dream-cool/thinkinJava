package 泛型;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author clt
 * @create 2020/7/18 9:48
 */
public class Tuple5<A, B, C, D, E>
        extends Tuple4<A, B, C, D> {
    public final E a5;
    public Tuple5(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        a5 = e;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a5;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("111",222);
        ArrayList arrayList = new ArrayList();
        arrayList.add("11");
        Tuple5<String, HashMap<String, Integer>, List<String>, Integer, Long> tuple5 = new Tuple5<>(
                "hello world", hashMap,arrayList, 11, 12L
        );
        System.out.println(tuple5);
    }
}

