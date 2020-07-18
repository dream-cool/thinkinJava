package 多态.转机;

/**
 * @author clt
 * @create 2019/11/28 21:41
 * 可扩展性 练习10
 */
class Father{
    public void makeMoney(){
        this.tune();
    }

    public void tune(){
        System.out.println("Father makeMoney  ....");
    }
}
public class Son extends Father {

    @Override
    public void tune() {
        System.out.println("Override");
    }

    public static void main(String[] args) {
        Son son = new Son();
        Father obj = son;
        obj.makeMoney();
    }
}
