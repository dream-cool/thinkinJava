package 内部类;

/**
 * @author clt
 * @create 2020/7/22 13:48
 */
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;
        @Override
        public int value() { return i; }
    }
    protected static final class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String whereTo) {
            label = whereTo;
        }
        @Override
        public String readLabel() { return label; }
        // Nested classes can contain other static elements:
        public static void f() {}
        static int x = 10;
        static class AnotherLevel {
            public static void f() {}
            static int x = 10;
        }
    }
    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }
    public static Contents contents() {
        return new ParcelContents();
    }
    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
        /**
         * 要创建嵌套类的对象，并不需要其外部类的对象。
         * 不能从嵌套类的对象中访问非静态的外部类对象。
         */
        /**
         * 在一个普通的（非 static）内部类中，通过一个特殊的 this 引用可以链接到其外部类对象。
         * 嵌套类就没有这个特殊的 this 引用，这使得它类似于一个 static 方法。
         */

    }
}
