package 内部类;

/**
 * @author clt
 * @create 2020/7/22 15:03
 */
class WithInner {
    class Inner {}
}
public class InheritInner extends WithInner.Inner {
    //InheritInner() {} // Won't compile
    InheritInner(WithInner wi) {
        wi.super();
    }
    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }

    /**
     * 可以看到，InheritInner 只继承自内部类，而不是外部类。
     * 但是当要生成一个构造器时，默认的构造器并不算好，而且不能只是传递一个指向外部类对象的引用。
     * 必须在构造器内调用所继承内部类的外部构造初始化，这样才提供了必要的引用，然后程序才能编译通过。
     * 因为内部类会包含外部类的引用
     */

}
