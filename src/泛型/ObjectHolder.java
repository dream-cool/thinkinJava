package 泛型;

/**
 * @author clt
 * @create 2020/7/18 9:21
 */
public class ObjectHolder {

    private Object a;
    public ObjectHolder(Object a) { this.a = a; }
    public void set(Object a) { this.a = a; }
    public Object get() { return a; }

    public static void main(String[] args) {
        ObjectHolder h2 = new ObjectHolder(new Automobile());
        Automobile a = (Automobile)h2.get();
        h2.set("Not an Automobile");
        String s = (String)h2.get();
        h2.set(1); // 自动装箱为 Integer
        Integer x = (Integer)h2.get();
        /**
         * ObjectHolder 可以持有任何类型的对象，在上面的示例中，
         * 一个 ObjectHolder 先后持有了三种不同类型的对象。
         * 不过上面这种方式你每次放入对象后 获取对象时必须手动得强转
         */

    }
}

class Automobile {}
