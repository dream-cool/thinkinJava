package 内部类;

/**
 * @author clt
 * @create 2020/7/22 9:45
 */
public class DotNew {
    public class Inner {}
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
    }
}
