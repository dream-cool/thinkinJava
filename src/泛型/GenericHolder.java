package 泛型;

/**
 * @author clt
 * @create 2020/7/18 9:25
 */
public class GenericHolder<T> {
    private T a;
    public GenericHolder() {}
    public void set(T a) { this.a = a; }
    public T get() { return a; }

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        h3.set(new Automobile()); // 此处有类型校验
        Automobile a = h3.get();  // 无需类型转换
        //- h3.set("Not an Automobile"); // 报错
        //- h3.set(1);  // 报错

        GenericHolder h4 = new GenericHolder();
        h4.set(new Automobile()); // 此处无类型校验
        Automobile b = (Automobile) h4.get();  // 需类型转换
        h4.set("Not an Automobile"); // 此处无类型校验
        String str = (String) h4.get(); // 需类型转换
        h4.set(1);// 此处无类型校验
        Integer num = (Integer) h4.get();// 需类型转换

        /**
         * 创建对象时不传递泛型则跟之前的object持有任意类型对象一致
         * 在放入对象时不做校验，所以获取对象时只能获取到object 必须手动强转
         *
         * 传入泛型的话，则将制定该对象持有的类型，
         * 放入对象时将对对象类型进行检查
         * 获取对象时，自动获取到之前持有的类型对象  无需显示强转
         */

    }
}
