package 接口.抽象类和抽象方法;

/**
 * @author clt
 * @create 2019/11/29 21:18
 * 抽象类和抽象方法  练习3
 */

abstract class Base{
    Base(){
        print();
    }

    public abstract void print();
}

public class SuperClass extends Base {
    private int a = 5;

    @Override
    public void print() {
        System.out.println("SuperClass print");
    }

    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        superClass.print();

        /**
         * 构造器内部的多态方法
         */

    }
}
