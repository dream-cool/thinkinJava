package 泛型;

/**
 * @author clt
 * @create 2020/7/18 10:21
 */
public class GenericMethods {

    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);

        /**
         * 泛型方法独立于类而改变方法。作为准则，请“尽可能”使用泛型方法。
         * 通常将单个方法泛型化要比将整个类泛型化更清晰易懂。
         *
         * 如果方法是 static 的，则无法访问该类的泛型类型参数，
         * 因此，如果使用了泛型类型参数，则它必须是泛型方法。
         */

    }
}
