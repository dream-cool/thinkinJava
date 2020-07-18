package 继承.d四;

/**
 * @author clt
 * @create 2019/11/27 20:17
 * 7.4.2 练习13
 */
class MathBase{
    int add(int a,int b){
        return a+b;
    }
    long add(long a, long b){
        return a+b;
    }
    float add(float a, float b){
        return  a+b;
    }
}
public class MathSelf extends MathBase {

    String add(String a, String b){
        return a+b;
    }

    public static void main(String[] args) {
        MathSelf mathSelf = new MathSelf();
        System.out.println(mathSelf.add(1,1));;
        System.out.println(mathSelf.add(1.5f,1));;
        System.out.println(mathSelf.add("1","1"));;
    }
}


