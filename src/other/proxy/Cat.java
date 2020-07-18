package other.proxy;

/**
 * @author clt
 * @create 2020/5/24 10:00
 */
public class Cat implements Animal {
    @Override
    public void call() {
        System.out.println("喵喵喵  ");
    }

    @Override
    public void run() {
        System.out.println("跑跑跑");
    }
}
