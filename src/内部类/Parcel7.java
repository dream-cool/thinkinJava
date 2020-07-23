package 内部类;

/**
 * @author clt
 * @create 2020/7/22 10:00
 */
public class Parcel7 {
    //匿名内部类实现
    public Contents contents() {
        return new Contents() { // Insert class definition
            private int i = 11;

            @Override
            public int value() { return i; }
        }; // Semicolon required
    }

    //非匿名内部类实现
    class MyContents implements Contents {
        private int i = 11;
        @Override
        public int value() { return i; }
    }

    public Contents contents1() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents a = p.contents();
        Contents b = p.contents1();
        System.out.println(a.value());
        System.out.println(b.value());

        //这个类是匿名的，它没有名字。更糟的是，看起来似乎是你正要创建一个 Contents 对象。
        // 但是然后（在到达语句结束的分号之前）你却说：“等一等，我想在这里插入一个类的定义。
    }
}
