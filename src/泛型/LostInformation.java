package 泛型;

import java.util.*;

/**
 * @author clt
 * @create 2020/7/18 10:51
 */

class Frob {}
class Fnorkle {}
class Quark<Q> {}

class Particle<POSITION, MOMENTUM> {}
public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));

        /**
         * Class.getTypeParameters() “返回一个 TypeVariable 对象数组，表示泛型声明中声明的类型参数...”
         * 这暗示你可以发现这些参数类型。但是正如上例中输出所示，你只能看到用作参数占位符的标识符，这并非有用的信息
         *
         * 在泛型代码内部，无法获取任何有关泛型参数类型的信息。
         * 因此，你可以知道如类型参数标识符和泛型边界这些信息，但无法得知实际的类型参数从而用来创建特定的实例。
         */

        /**
         * Java 泛型是使用擦除实现的。这意味着当你在使用泛型时，任何具体的类型信息都被擦除了，你唯一知道的就是你在使用一个对象。
         * 因此，List<String> 和 List<Integer> 在运行时实际上是相同的类型。它们都被擦除成原生类型 List。
         *
         * 理解擦除并知道如何处理它，是你在学习 Java 泛型时面临的最大障碍之一
         */


    }
}
