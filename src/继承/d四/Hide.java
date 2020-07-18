package 继承.d四;

/**
 * @author clt
 * @create 2019/11/27 20:09
 * 7.4.2 名称屏蔽 示例
 */
class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }
    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
    void doh(Milhouse m) {
        System.out.println("sub doh(Milhouse)");
    }
}
class Milhouse {}
class Bart extends Homer {
    @Override
    void doh(Milhouse m) {
        System.out.println("sup doh(Milhouse)");
    }
}
public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1); // doh(float) used
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());

        Homer h = new Homer();
        h.doh(1); // doh(float) used
        h.doh('x');
        h.doh(1.0f);
        h.doh(new Milhouse());
    }
    /**
     * doh(float)
     * doh(char)
     * doh(float)
     * sup doh(Milhouse)
     * doh(float)
     * doh(char)
     * doh(float)
     * sub doh(Milhouse)
     */

} ///:~