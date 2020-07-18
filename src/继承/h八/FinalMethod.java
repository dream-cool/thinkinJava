package 继承.h八;

/**
 * @author clt
 * @create 2019/11/28 19:40
 * final方法  练习21
 */
class BaseMethod{
    private void say(){
        System.out.println("BaseMethod say");
    }
    public void eat(){
        System.out.println("BaseMethod eat");
    }
}

class Method extends BaseMethod{

    private final void say(){
        System.out.println("method say");
    }

    @Override
    public final void eat(){
        System.out.println("method eat");
    }
}
public class FinalMethod extends Method{

    public final void say(){
        System.out.println("FinalMethod say");
    }

    /**
     * 无法通过编译
     * 被final修饰的方法 子类还是用于它，还是能调用，只是无法覆盖它
     */
//    public final void eat()
    public static void main(String[] args) {
        FinalMethod finalMethod = new FinalMethod();
        finalMethod.say();
    }
}

