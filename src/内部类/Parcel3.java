package 内部类;

/**
 * @author clt
 * @create 2020/7/22 9:46
 */
public class Parcel3 {
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }
    class Destination {
        private String label;
        Destination(String whereTo) { label = whereTo; }
        String readLabel() { return label; }
    }
    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        // Must use instance of outer class
        // to create an instance of the inner class:
        Parcel3.Contents c = p.new Contents();
        Parcel3.Destination d =
                p.new Destination("Tasmania");

        //静态内部类实例的创建方式
        //Parcel3.Contents e = new Parcel3.Contents();

        /**
         * 要想直接创建内部类的对象，你不能按照你想象的方式，
         * 去引用外部类的名字 Parcel3，而是必须使用外部类的对象来创建该内部类对象
         *
         * 在拥有外部类对象之前是不可能创建内部类对象的。这是因为内部类对象会暗暗地连接到建它的外部类对象上。
         * 但是，如果你创建的是嵌套类（静态内部类），那么它就不需要对外部类对象的引用。
         */

    }
}
