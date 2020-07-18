package 多态.构造器和多态;


/**
 * @author clt
 * @create 2019/11/29 19:05
 * 构造器和多态  练习11
 */

class Bread{
    Bread(){
        System.out.println("print(Bread)");
    }
}
class Cheese{
    Cheese(){
        System.out.println("print(Cheese)");
    }
}
class Lettuce{
    Lettuce(){
        System.out.println("print(Lettuce)");
    }
}
class Pickle{
    Pickle(){
        System.out.println("print(Pickle)");
    }
}
class Meal{
    Meal(){
        System.out.println("print(Meal)");
    }
}
class Lunch extends Meal{
    Lunch(){
        System.out.println("print(Lunch)");
    }
}
class PortableLunch extends Lunch{
    private Bread bread = new Bread();
    private Cheese Cheese = new Cheese();
    private Lettuce lettuce = new Lettuce();
    private Pickle pickle = new Pickle();

    PortableLunch(){
        System.out.println("print(PortableLunch)");
    }
}
public class Sandwich extends PortableLunch{
    public static void main(String[] args) {
        new Sandwich();
        /**
         * print(Meal)
         * print(Lunch)
         * print(Bread)
         * print(Cheese)
         * print(Lettuce)
         * print(PortableLunch)
         * 先向基类进行向上追溯 调用构造方法，
         * 然后初始化自己本类实例成员变量
         * 最后执行自己本类构造方法
         * 即构造执行顺序  基类  > 组合 > 本类
         */

    }
}
