package 泛型;

/**
 * @author clt
 * @create 2020/7/18 11:44
 */
class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

public class CovariantArrays {

    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
        /**
         * 第一行创建了 Apple 数组，并赋值给一个 Fruit 数组引用。这是有意义的，因为 Apple 也是一种 Fruit，
         * 因此 Apple 数组应该也是一个 Fruit 数组
         * 但是，如果实际的数组类型是 Apple[]，你可以在其中放置 Apple 或 Apple 的子类型，
         * 这在编译期和运行时都可以工作。但是你也可以在数组中放置 Fruit 对象。这对编译器来说是有意义的，因为它有一个 Fruit[]
         * 引用——它有什么理由不允许将 Fruit 对象或任何从 Fruit 继承出来的对象（比如 Orange），放置到这个数组中呢？
         * 因此在编译期，这是允许的。然而，运行时的数组机制知道它处理的是 Apple[]，因此会在向数组中放置异构类型时抛出异常
         */

    }
}
