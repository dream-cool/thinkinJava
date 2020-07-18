package 继承.b二;

/**
 * @author clt
 * @create 2019/11/27 18:30
 * 7.2.1 练习5、练习7
 */
public class A extends C {
    A(int i){
        super(i);
        System.out.println("A.....");
    }
    public static void main(String[] args) {
        A a = new A(11);
        C c = new C(12);
    }

}
class B{
    B(int i){
        System.out.println("B..."+i);
    }
}
class C{
    B b ;
    C(int i){
        b = new B(i);
        System.out.println("C'...");
    }

}
