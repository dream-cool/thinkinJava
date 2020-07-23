package 内部类;

/**
 * @author clt
 * @create 2020/7/22 9:57
 */
public class Parcel5 {

    public Destination destination(String s) {
        final class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() { return label; }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
        //一个定义在方法中的类。

        //PDestination 类是 destination() 方法的一部分，而不是 Parcel5 的一部分。
        // 所以，在 destination() 之外不能访问 PDestination，
    }
}
