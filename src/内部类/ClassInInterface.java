package 内部类;

/**
 * @author clt
 * @create 2020/7/22 13:54
 */
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }

    /**
     * 嵌套类可以作为接口的一部分。
     * 你放到接口中的任何类都自动地是 public 和 static 的。
     */

}
