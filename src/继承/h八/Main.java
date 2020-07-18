package 继承.h八;

/**
 * @author clt
 * @create 2019/11/28 20:10
 * 继承与初始化 练习23
 */
class First {

    public static String first = new String("FIRST");

    static {
        System.out.println(first + "first has been load");
    }

}

class Second extends First {
    public static String second = new String("SECOND");

    static {
        System.out.println(second + "second has been load");
    }
}

class Third extends Second {
    public static String third = new String("THIRD");

    static {
        System.out.println(third + "third has been load");
    }
}

public class Main extends Third {

    public static void main(String[] args) {
        Third.third = "aaa";
        /**
         * FIRSTfirst has been load
         * SECONDsecond has been load
         * THIRDthird has been load
         */

        Second second = new Second();
        /**
         *  当通过访问类的静态成员属性或通过该类构造示例时，类将会被加载
         *  且只会被加载一次
         */

    }
}
