package 函数式编程;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * @author clt
 * @create 2020/7/18 15:22
 */
class Closure1 {
    int i;
    IntSupplier makeFun(int x) {
        return () -> x + i++;
        /**
         * 为什么变量 i 被修改编译器却没有报错呢。 它既不是 final 的，也不是等同 final 效果的。
         * 因为 i 是外围类的成员，所以这样做肯定是安全的（除非你正在创建共享可变内存的多个函数）。
         * 是的，你可以辩称在这种情况下不会发生变量捕获（Variable Capture）。
         * 但可以肯定的是，Closure3.java 的错误消息是专门针对局部变量的。
         * 因此，规则并非只是“在 Lambda 之外定义的任何变量必须是 final 的或等同 final 效果那么简单。
         * 相反，你必须考虑捕获的变量是否是等同 final 效果的。
         * 如果它是对象中的字段，那么它拥有独立的生存周期，并且不需要任何特殊的捕获，以便稍后在调用 Lambda 时存在。
         *
         *
         * 实际上只要有内部类，就会有闭包（Java 8 只是简化了闭包操作）。
         * 在 Java 8 之前，变量 x 和 i 必须被明确声明为 final。
         * 在 Java 8 中，内部类的规则放宽，包括等同 final 效果。
         */
    }
}
class Closure2 {
    IntSupplier makeFun(int x) {
        int i = 0;
        return () -> x + i;
    }
}
class Closure3 {
    IntSupplier makeFun(int x) {
        int i = 0;
        // x++ 和 i++ 都会报错：
        //return () -> x++ + i++;
        return () -> i;
    }
}
class Closure4 {
    IntSupplier makeFun(final int x) {
        final int i = 0;
        return () -> x + i;
    }
}
class Closure5 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        //return () -> x + i;
        return () -> 1;
    }
}
class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        final int iFinal = i;
        final int xFinal = x;
        return () -> xFinal + iFinal;
    }
}
class Closure7 {
    IntSupplier makeFun(int x) {
        Integer i = 0;
        i = i + 1;
        return () -> x ;
        //return () -> x + i;
    }
}
class Closure8 {
    Supplier<List<Integer>> makeFun() {
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }
    public static void main(String[] args) {
        Closure8 c7 = new Closure8();
        List<Integer>
                l1 = c7.makeFun().get(),
                l2 = c7.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);
    }
}
class Closure9 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> ai = new ArrayList<>();
        //ai = new ArrayList<>(); // Reassignment
        return () -> ai;
    }
}
public class SharedStorage {
    public static void main(String[] args) {
        Closure1 c1 = new Closure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
    }

    /**
     * 每次调用 getAsInt() 都会增加 i，表明存储是共享的
     */

}
