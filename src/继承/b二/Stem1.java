package 继承.b二;

/**
 * @author clt
 * @create 2019/11/27 18:57
 * 7.2.1练习10
 */
class Component11{
    Component11(int i){
        System.out.println("Component1....."+i);
    }
}
class Component12{
    Component12(int i){
        System.out.println("Component2......"+i);
    }
}
class Component13{
    Component13(int i){
        System.out.println("Component3......"+i);
    }

}

class Root1{
    Component11 component1;
    Component12 component2;
    Component13 component3;
    Root1(int i){
        component1 = new Component11(1);
        component2 = new Component12(2);
        component3 = new Component13(3);
        System.out.println("Root....."+i);
    }
}

public class Stem1 extends Root1{
    Stem1(int i){
        super(i);
        System.out.println("Stem........."+i);
    }
    public static void main(String[] args) {
        Stem1 s = new Stem1(4);
        /**
         * Component1.....1
         * Component2......2
         * Component3......3
         * Root.....4
         * Stem.........4
         */
    }
}
