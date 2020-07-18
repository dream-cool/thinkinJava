package 泛型;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author clt
 * @create 2020/7/18 11:17
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));

        String[] strs = (String[])Array.newInstance(String.class, 9);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
