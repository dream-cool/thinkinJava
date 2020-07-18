package 泛型;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author clt
 * @create 2020/7/18 9:47
 */
public class Tuple3<A, B, C> extends Tuple2<A, B> {
    public final C a3;
    public Tuple3(A a, B b, C c) {
        super(a, b);
        a3 = c;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a3;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("111",222);
        ArrayList arrayList = new ArrayList();
        arrayList.add("11");
        Tuple3<String, HashMap<String, Integer>, List<String>> tuple3 = new Tuple3<>(
                "hello world", hashMap,arrayList
        );
        System.out.println(tuple3);
    }
}



