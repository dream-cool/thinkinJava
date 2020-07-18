package other.proxy;

/**
 * @author clt
 * @create 2020/5/24 10:06
 */
public class Dog implements  Animal {
    @Override
    public void call() {
        System.out.println("汪汪汪----");
    }

    @Override
    public void run() {
        System.out.println("跑跑跑");
    }
}
