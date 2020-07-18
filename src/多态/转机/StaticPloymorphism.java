package 多态.转机;

/**
 * @author clt
 * @create 2019/11/29 18:50
 * 静态方法
 */
class StaticSuper{

    public static String staticGet(){
        return "Base staticGet";
    }

    public  String dynamicGet(){
        return "Base dynamicGet";
    }
}
class StaticSub extends StaticSuper{
    public static String staticGet(){
        return "Derived staticGet";
    }

    public  String dynamicGet(){
        return "Derived dynamicGet";
    }
}
public class StaticPloymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());

        /**
         * static 修饰的方法从属于类 而不是对象
         * 所以虽然sup本质对象时StaticSub 但有些调用静态方法时
         * 是根据类来调用的，所以还是调用的StaticSuper类的方法
         */

    }

}
