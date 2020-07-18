package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clt
 * @create 2020/7/18 11:22
 */
public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> stringList = stringMaker.create();
        System.out.println(stringList);
    }
}
