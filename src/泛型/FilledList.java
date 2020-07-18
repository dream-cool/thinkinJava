package 泛型;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author clt
 * @create 2020/7/18 11:23
 */
public class FilledList<T> extends ArrayList<T> {
    FilledList(Supplier<T> gen, int size) {
        Suppliers.fill(this, gen, size);
    }

    public FilledList(T t, int size) {
        for (int i = 0; i < size; i++) {
            this.add(t);
        }
    }

    public static void main(String[] args) {
        List<String> list = new FilledList<>("Hello", 4);
        System.out.println(list);
        // Supplier version:
        List<Integer> ilist = new FilledList<>(() -> 47, 4);
        System.out.println(ilist);

        /**
         * 即使编译器无法得知 add() 中的 T 的任何信息，但它仍可以在编译期确保你放入 FilledList 中的对象是 T 类型。
         * 因此，即使擦除移除了方法或类中的实际类型的信息，编译器仍可以确保方法或类中使用的类型的内部一致性。
         *
         * 泛型的所有动作都发生在边界处——对入参的编译器检查和对返回值的转型。
         * 这有助于澄清对擦除的困惑，记住：“边界就是动作发生的地方”。
         */

    }
}
