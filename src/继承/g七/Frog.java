package 继承.g七;

/**
 * @author clt
 * @create 2019/11/27 21:16
 * 7.7 练习16、练习17
 */
class Amphibian{

    public void test1(){
        System.out.println("sup test1.....");
    }

    public void test2(){
        System.out.println("sup test2.....");
    }
}
public class Frog extends Amphibian{

    public static void main(String[] args) {
        Frog frog = new Frog();
        Amphibian amphibian = frog;
        amphibian.test1();
        amphibian.test2();

        Frog frog1 = new Frog();
        frog1.test1();
        frog1.test2();

        Amphibian amphibian1 = new Amphibian();
        amphibian1.test1();
    }

    @Override
    public void test1(){
        System.out.println("sub  test1.....");
    }
}
