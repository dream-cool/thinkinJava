import com.sun.media.sound.SoftTuning;
import 继承.h八.FinalMethod;

/**
 * @author clt
 * @create 2019/12/6 19:00
 */
public class Test {

    public static void test(){
        String str = "123";
        Class cla = str.getClass();
        System.out.println(cla.getName());
    }

    public static void test1(){
        FinalMethod obj = new FinalMethod();
        Class c = obj.getClass();
        while (c.getSuperclass() != null){
            System.out.println(c.getSuperclass());
            c = c.getSuperclass();
        }
        System.out.println(c.getSimpleName());
    }

    public static void main(String[] args) {
        test1();
    }

}
