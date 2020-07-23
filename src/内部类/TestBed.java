package 内部类;

/**
 * @author clt
 * @create 2020/7/22 13:57
 */
public class TestBed {
    public void f() { System.out.println("f()"); }
    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
